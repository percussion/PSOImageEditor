/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * com.percussion.pso.imageedit.services.cache.impl ImageCacheManager.java
 *
 */
package com.percussion.pso.imageedit.services.cache;
import com.percussion.pso.imageedit.data.ImageData;
import com.percussion.pso.imageedit.data.ImageMetaData;
public interface ImageCacheManager
{
   /**
    * Adds an image to the cache.
    * @param data the image data
    * @return the image key.  Use this key to retrieve the image or its metadata. 
    */
   public String addImage(ImageData data);
   
   /**
    * Gets an image from the cache.  The image includes the binary data. 
    * @param imageKey the image key
    * @return the image data, will be <code>null</code> if the image is not in the cache. 
    */
   public ImageData getImage(String imageKey);
   
   /**
    * Gets an image metadata from the cache.  The metadata does not include the binary data. 
    * @param imageKey the image key
    * @return the image metadata, will be <code>null</code> if the image is not in the cache. 
    */
   public ImageMetaData getImageMetaData(String imageKey); 
   
   /**
    * Removes an image from the cache. Images should be removed when the application has finished with them. 
    * The cache configuration controls whether unused images get flushed over time. 
    * 
    * @param imageKey the image key.
    */
   public void removeImage(String imageKey);
   
   /**
    * Tests if an image is in the cache. 
    * @param imageKey the image key
    * @return <code>true</code> if the image is in the cache. 
    */
   public boolean hasImage(String imageKey); 
}