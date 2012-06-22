/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * com.percussion.pso.imageedit.web.impl ImageEditorTestPageController.java
 *
 */
package com.percussion.pso.imageedit.web.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

import com.percussion.pso.imageedit.data.MasterImageMetaData;
import com.percussion.pso.imageedit.data.OpenImageResult;
import com.percussion.pso.imageedit.web.ImagePersistenceManager;
import com.percussion.pso.imageedit.web.ImageUrlBuilder;
import com.percussion.pso.utils.RxRequestUtils;
import com.percussion.util.IPSHtmlParameters;

/**
 * 
 *
 * @author DavidBenua
 *
 */
public class ImageEditorTestPageController extends ParameterizableViewController
      implements
         Controller
{
   private static Log log = LogFactory.getLog(ImageEditorTestPageController.class); 
   
   private ImagePersistenceManager imagePersistenceManager;
   
   private ImageUrlBuilder urlBuilder; 
   /**
    * Default constructor
    */
   public ImageEditorTestPageController()
   {
    
   }
   /**
    * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
    */
   @Override
   protected ModelAndView handleRequestInternal(HttpServletRequest request,
         HttpServletResponse response) throws Exception
   {
      //get the view name
      ModelAndView mav = super.handleRequestInternal(request, response); 
      String user = RxRequestUtils.getUserName(request);
      log.debug("user is " + user);
      String session = RxRequestUtils.getSessionId(request); 
      log.debug("session is " + session); 
      String contentid = request.getParameter(IPSHtmlParameters.SYS_CONTENTID); 
      if(StringUtils.isNotBlank(contentid))
      {
         OpenImageResult oir = imagePersistenceManager.OpenImage(contentid, session, user);
         log.debug("ItemStatus is  " + oir.getItemStatus());

         MasterImageMetaData masterImage  = oir.getMasterImage();
         log.info("masterimage " + masterImage); 
         mav.addObject("masterImage", masterImage);
         mav.addObject("urlBuilder", urlBuilder);
      }
      
      return mav; 
   }
   /**
    * @return the imagePersistenceManager
    */
   public ImagePersistenceManager getImagePersistenceManager()
   {
      return imagePersistenceManager;
   }
   /**
    * @param imagePersistenceManager the imagePersistenceManager to set
    */
   public void setImagePersistenceManager(
         ImagePersistenceManager imagePersistenceManager)
   {
      this.imagePersistenceManager = imagePersistenceManager;
   }
   /**
    * @return the urlBuilder
    */
   public ImageUrlBuilder getUrlBuilder()
   {
      return urlBuilder;
   }
   /**
    * @param urlBuilder the urlBuilder to set
    */
   public void setUrlBuilder(ImageUrlBuilder urlBuilder)
   {
      this.urlBuilder = urlBuilder;
   }
}
