/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * com.percussion.pso.imageedit.data MasterImageMetaData.java
 *
 */
package com.percussion.pso.imageedit.data;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang.builder.ToStringBuilder;

public class MasterImageMetaData extends AbstractImageMetaData 
{
   private String sysTitle;
   private String displayTitle;
   private String description;
   private String alt; 
   private Map<String,SizedImageMetaData> sizedImages;

   public MasterImageMetaData()
   {
      super();
      sizedImages = new LinkedHashMap<String, SizedImageMetaData>();
   }
   /**
    * @return the sysTitle
    */
   public String getSysTitle()
   {
      return sysTitle;
   }

   /**
    * @param sysTitle the sysTitle to set
    */
   public void setSysTitle(String sysTitle)
   {
      this.sysTitle = sysTitle;
   }

   /**
    * @return the displayTitle
    */
   public String getDisplayTitle()
   {
      return displayTitle;
   }

   /**
    * @param displayTitle the displayTitle to set
    */
   public void setDisplayTitle(String displayTitle)
   {
      this.displayTitle = displayTitle;
   }

   /**
    * @return the description
    */
   public String getDescription()
   {
      return description;
   }

   /**
    * @param description the description to set
    */
   public void setDescription(String description)
   {
      this.description = description;
   }

   /**
    * @return the alt
    */
   public String getAlt()
   {
      return alt;
   }

   /**
    * @param alt the alt to set
    */
   public void setAlt(String alt)
   {
      this.alt = alt;
   }

   /**
    * Gets the sized images. 
    * @return the sizedImages. Never <code>null</code> may be <code>empty</code>. 
    */
   public Map<String,SizedImageMetaData> getSizedImages() 
   {
      return sizedImages;
   }

   /**
    * @param sizedImages the sizedImages to set
    */
   public void setSizedImages(Map<String,SizedImageMetaData> sizedImages)
   {
      this.sizedImages = sizedImages;
   }
   
   /**
    * @param sizedImages the sizedImages to set
    */
   public void addSizedImage(SizedImageMetaData sizedImage)
   {
      String key = sizedImage.getSizeDefinition().getCode();
      this.sizedImages.put(key, sizedImage);
   }
   
   public void clearSizedImages()
   {
      this.sizedImages = new LinkedHashMap<String, SizedImageMetaData>(); 
     
   }
   public String toString() 
   {
      return ToStringBuilder.reflectionToString(this);
   }

   
   
}
