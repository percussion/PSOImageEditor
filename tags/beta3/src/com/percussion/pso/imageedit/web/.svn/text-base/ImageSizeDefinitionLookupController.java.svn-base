/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * com.percussion.pso.imageedit.web ImageSizeDefinitionLookupController.java
 *
 */
package com.percussion.pso.imageedit.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.percussion.pso.imageedit.data.ImageSizeDefinition;
import com.percussion.pso.imageedit.services.ImageSizeDefinitionManager;
import com.percussion.pso.imageedit.services.ImageSizeDefinitionManagerLocator;
import com.percussion.xml.PSXmlDocumentBuilder;

/**
 * 
 *
 * @author DavidBenua
 *
 */
public class ImageSizeDefinitionLookupController
      extends
         ParameterizableViewController implements Controller
{
   
   private static Log log = LogFactory.getLog(ImageSizeDefinitionLookupController.class);
   
   /**
    * Key for result passed to view.  Defaults to "result" 
    */
   private String resultKey = "result"; 
   
   
   private ImageSizeDefinitionManager defmgr = null; 
   
   
   /**
    * 
    */
   public ImageSizeDefinitionLookupController()
   {
      
   }

   private void initServices()
   {
      if(defmgr == null)
      {
         defmgr = ImageSizeDefinitionManagerLocator.getImageSizeDefinitionManager(); 
      }
   }
  
   /**
    * @see org.springframework.web.servlet.mvc.ParameterizableViewController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
    */
   @Override
   protected ModelAndView handleRequestInternal(HttpServletRequest request,
         HttpServletResponse response) throws Exception
   {      
      initServices();
      ModelAndView mav = super.handleRequestInternal(request, response);
      
      Document resultDoc = PSXmlDocumentBuilder.createXmlDocument(); 
      Element root = PSXmlDocumentBuilder.createRoot(resultDoc, "sys_Lookup");
      
      List<ImageSizeDefinition> defs = defmgr.getAllImageSizes(); 
      for(ImageSizeDefinition size : defs)
      {
         log.debug("Adding size " + size.getCode()); 
         Element entry = PSXmlDocumentBuilder.addEmptyElement(resultDoc, root, "PSXEntry");
         PSXmlDocumentBuilder.addElement(resultDoc, entry, "PSXDisplayText", size.getLabel());
         PSXmlDocumentBuilder.addElement(resultDoc, entry, "Value", size.getCode());         
      }
      
      mav.addObject(resultKey, resultDoc);
      return mav; 
   }


   /**
    * Gets the result key. 
    * @return the resultKey
    */
   public String getResultKey()
   {
      return resultKey;
   }


   /**
    * Sets the result key.
    * @param resultKey the resultKey to set
    */
   public void setResultKey(String resultKey)
   {
      this.resultKey = resultKey;
   }

   /**
    * Sets the ImageSizeDefinitionManager for unit test. 
    * @param defmgr the defmgr to set
    */
   public void setDefmgr(ImageSizeDefinitionManager defmgr)
   {
      this.defmgr = defmgr;
   }
}
