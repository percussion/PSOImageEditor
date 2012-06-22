/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * com.percussion.pso.imageedit.web ImagePersistenceManagerImpl.java
 *
 */
package com.percussion.pso.imageedit.web.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.percussion.cms.objectstore.PSCoreItem;
import com.percussion.cms.objectstore.PSItemChildEntry;
import com.percussion.cms.objectstore.PSItemField;
import com.percussion.design.objectstore.PSLocator;
import com.percussion.pso.imageedit.data.MasterImageMetaData;
import com.percussion.pso.imageedit.data.OpenImageResult;
import com.percussion.pso.imageedit.data.SimpleImageMetaData;
import com.percussion.pso.imageedit.data.SizedImageMetaData;
import com.percussion.pso.imageedit.web.ImagePersistenceManager;
import com.percussion.services.content.data.PSItemStatus;
import com.percussion.utils.guid.IPSGuid;
import com.percussion.webservices.PSErrorsException;

/**
 * 
 *
 * @author DavidBenua
 *
 */
public class ImagePersistenceManagerImpl extends ImageItemSupport 
  implements ImagePersistenceManager   
{
   private static Log log = LogFactory.getLog(ImagePersistenceManagerImpl.class);
   
   private boolean extralogging = true; 
   private String imageContentType; 
   
   private Map<String, String> masterFieldMap;
   private Map<String, String> childFieldMap; 
   
   public ImagePersistenceManagerImpl()
   {
      
   }
   
   
   /**
    * @see com.percussion.pso.imageedit.web.ImagePersistenceManager#CreateImage(com.percussion.pso.imageedit.data.MasterImageMetaData, String, boolean, java.lang.String, java.lang.String)
    */
   public String CreateImage(MasterImageMetaData master, String folderid,
         boolean checkin, String session, String user) throws Exception
   {
      initServices();
      log.debug("CreateImage: creating image..."); 
      List<PSCoreItem> ilist = cws.createItems(imageContentType, 1, session, user);
      log.debug("CreateImage: a content item has been created");
      PSCoreItem item = ilist.get(0);
      log.debug("CreateImage: writing the metadata for master");
      writeMetaData(item, master, masterFieldMap);
      log.debug("CreateImage: master metadata written, going to save");
      List<IPSGuid> glist = cws.saveItems(ilist, false, false, session, user);
      log.debug("CreateImage: master saved");
      IPSGuid itemGuid = glist.get(0);
      String childName = getChildName(); 
      List<PSItemChildEntry> allEntries = new ArrayList<PSItemChildEntry>();
      for(SimpleImageMetaData sized : master.getSizedImages().values())
      {
         PSItemChildEntry entry = createChildEntry(itemGuid, session, user);
         writeMetaData(entry, sized, this.getChildFieldMap());
         allEntries.add(entry); 
      }
      if(allEntries.size() > 0)
      {       
        cws.saveChildEntries(itemGuid, childName, allEntries, session, user); 
      }
      if(StringUtils.isNotBlank(folderid))
      {
         IPSGuid folderGuid = gmgr.makeGuid(new PSLocator(folderid, "0"));
         cws.addFolderChildren(folderGuid, glist); 
      }
      if(checkin)
      {
         cws.checkinItems(glist, null, user); 
      }
      PSLocator loc = gmgr.makeLocator(itemGuid);
      return loc.getPart(PSLocator.KEY_ID);
   }
   /**
    * @see com.percussion.pso.imageedit.web.ImagePersistenceManager#OpenImage(java.lang.String, java.lang.String, java.lang.String)
    */
   public OpenImageResult OpenImage(String contentid, String session,
         String user) throws Exception
   {
	  log.debug("OpenImage: Starting to open image");
      
	  OpenImageResult result = new OpenImageResult();
      PSCoreItem item = openItem(contentid, session, user, result); 
      log.debug("OpenImage: successfully opened the PSCoreItem");
      
      MasterImageMetaData master = new MasterImageMetaData(); 
      readMetaData(item, master, this.getMasterFieldMap()); 
      log.debug("OpenImage: read the data into the master image: imageKey: " + master.getImageKey());
     
      for(PSItemChildEntry entry : getChildEntries(contentid, session, user))
      {
         SizedImageMetaData sized = new SizedImageMetaData(); 
         readMetaData(entry, sized, this.getChildFieldMap());
         master.addSizedImage(sized); 
         log.debug("OpenImage: read the data into the sized image [" + sized.getSizeDefinition().getCode() + "] and added to the master");
      }
      result.setMasterImage(master); 
      
      return result; 
   }
   /**
    * @see com.percussion.pso.imageedit.web.ImagePersistenceManager#UpdateImage(com.percussion.pso.imageedit.data.MasterImageMetaData, java.lang.String, com.percussion.services.content.data.PSItemStatus, java.lang.String, java.lang.String)
    */
   public void UpdateImage(MasterImageMetaData image, String contentid,
         PSItemStatus itemStatus, String session, String user) throws Exception
   {
      initServices();
      try
      {
         OpenImageResult result = new OpenImageResult();
         PSCoreItem item = openItem(contentid, session, user, result);
         writeMetaData(item, image, masterFieldMap);
         
         List<PSCoreItem> ilist = Collections.<PSCoreItem>singletonList(item);
         List<IPSGuid> glist = cws.saveItems(ilist, false, false, session, user);
         IPSGuid itemGuid = glist.get(0);
         
         List<PSItemChildEntry> entries = getChildEntries(itemGuid, session, user);
         List<IPSGuid> childrenToRemove = buildGuidList(entries); //start with a list of all entries
         List<PSItemChildEntry> childrenToSave = new ArrayList<PSItemChildEntry>();
         List<PSItemChildEntry> childrenToInsert = new ArrayList<PSItemChildEntry>(); 
         
         log.debug("UpdateImage: dealing with sized images - there are " + image.getSizedImages().size() + " image(s)");
         for(SizedImageMetaData sized : image.getSizedImages().values())
         {
            String sizeCode = sized.getSizeDefinition().getCode(); 
            log.debug("UpdateImage: in the for loop - trying to find child entry for sized: " + sizeCode);
            PSItemChildEntry entry =  findChildEntry(entries, sizeCode); 
            if(entry == null)
            { 
               log.debug("creating new entry for " + sizeCode); 
               entry = createChildEntry(itemGuid, session, user);
               childrenToInsert.add(entry); 
            }
            else               
            {
               childrenToSave.add(entry);
               //since we found it, we don't have to remove it.
               IPSGuid entryGuid = entry.getGUID();
               log.debug("UpdateImage: found an entry for " + sizeCode + " guid " + entryGuid);
               childrenToRemove.remove(entryGuid); 
            }
            writeMetaData(entry, sized, childFieldMap);
            
            log.debug("UpdateImage: entry is: " + entry);
         }
         String childName = getChildName();
         log.debug("UpdateImage: Dealing with child: " + childName);
         
         if(childrenToRemove.size() > 0 )
         {
            log.debug("removing " + childrenToRemove.size() + " unused child rows ");          
            cws.deleteChildEntries(itemGuid, childName, childrenToRemove, session, user);
         }
         if(childrenToInsert.size() > 0)
         {
            log.debug("inserting " + childrenToInsert.size() + " child entries"); 
            if(log.isDebugEnabled() && extralogging)
            {
               for(PSItemChildEntry entry : childrenToInsert)
               {
                  log.debug("child is " + entry);
                  Iterator<PSItemField> it = entry.getAllFields();
                  while(it.hasNext())
                  {
                     PSItemField fld = it.next(); 
                     log.debug("field is " + fld); 
                  }
               }
            }
            cws.saveChildEntries(itemGuid, childName, childrenToInsert, session, user);
         }
         if(childrenToSave.size() > 0 )
         {
            log.debug("saving " + childrenToSave.size() + " child entries"); 
            if(log.isDebugEnabled() && extralogging)
            {
               for(PSItemChildEntry entry : childrenToSave)
               {
                  log.debug("child is " + entry);
                  Iterator<PSItemField> it = entry.getAllFields();
                  while(it.hasNext())
                  {
                     PSItemField fld = it.next(); 
                     log.debug("field is " + fld); 
                  }
               }
            }
            cws.saveChildEntries(itemGuid, childName, childrenToSave, session, user);
         }
         
         
         if(itemStatus != null)
         {
            cws.releaseFromEdit(Collections.<PSItemStatus>singletonList(itemStatus), false); 
         }
         else
         {
            cws.checkinItems(Collections.<IPSGuid>singletonList(itemGuid), null, user);
         }
      } catch (PSErrorsException ee)
      {
          log.error("Server Errors exception " + ee, ee); 
          Map<IPSGuid, Object> errors = ee.getErrors();
          for(Map.Entry<IPSGuid, Object> entry : errors.entrySet())
          {
             log.error("Error for GUID " + entry.getKey() + 
                   " : " + entry.getValue()); 
          }
          throw ee; 
      } catch (Exception ex)
      {
          log.error("Unexpected Exception while updating item " + ex,ex);
          throw ex; 
      }
   }

  
 
   /**
    * @return the imageContentType
    */
   public String getImageContentType()
   {
      return imageContentType;
   }

   /**
    * @param imageContentType the imageContentType to set
    */
   public void setImageContentType(String imageContentType)
   {
      this.imageContentType = imageContentType;
   }

   public Map<String, String> getMasterFieldMap()
   {
      return masterFieldMap;
   }


   public void setMasterFieldMap(Map<String, String> masterFieldMap)
   {
      this.masterFieldMap = masterFieldMap;
   }


   public Map<String, String> getChildFieldMap()
   {
      return childFieldMap;
   }


   public void setChildFieldMap(Map<String, String> childFieldMap)
   {
      this.childFieldMap = childFieldMap;
   }


 
}
