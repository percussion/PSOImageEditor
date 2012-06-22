/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * com.percussion.pso.imageedit.web ImageUrlBuilderImpl.java
 *
 */
package com.percussion.pso.imageedit.web.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.percussion.pso.imageedit.web.ImageUrlBuilder;

public class ImageUrlBuilderImpl implements ImageUrlBuilder
{
   private static Log log = LogFactory.getLog(ImageUrlBuilderImpl.class);
   
   private String baseUrl; 
   private String suffix = "jpg"; 
   
   /**
    * @see com.percussion.pso.imageedit.web.ImageUrlBuilder#buildUrl(java.lang.String)
    */
   public String buildUrl(String imageKey)
   {
      StringBuilder sb = new StringBuilder(); 
      sb.append(baseUrl);
      if(!baseUrl.endsWith("/"))
      {
         sb.append("/");
      }
      sb.append("img");
      sb.append(imageKey);
      sb.append(".");
      sb.append(suffix); 
      return sb.toString(); 
   }
   
   
   /**
    * @see com.percussion.pso.imageedit.web.ImageUrlBuilder#extractKey(java.lang.String)
    */
   public String extractKey(String url)
   {
      String emsg; 
      if(StringUtils.isBlank(url))
      {
         emsg = "image URL must not be blank"; 
         log.error(emsg);
         throw new IllegalArgumentException(emsg);
      }
      String lastPart = StringUtils.substringAfterLast(url, "/"); 
      lastPart = StringUtils.substringBefore(lastPart, "."); 
      String key = StringUtils.substringAfter(lastPart,"img"); 
      
      return key; 
   }


   /**
    * @return the baseUrl
    */
   public String getBaseUrl()
   {
      return baseUrl;
   }


   /**
    * @param baseUrl the baseUrl to set
    */
   public void setBaseUrl(String baseUrl)
   {
      this.baseUrl = baseUrl;
   }


   /**
    * @return the suffix
    */
   public String getSuffix()
   {
      return suffix;
   }


   /**
    * @param suffix the suffix to set
    */
   public void setSuffix(String suffix)
   {
      this.suffix = suffix;
   }
}
