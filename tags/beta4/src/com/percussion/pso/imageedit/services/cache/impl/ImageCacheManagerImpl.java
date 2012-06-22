/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * com.percussion.pso.imageedit.services.cache.impl ImageCacheManagerImpl.java
 *
 */
package com.percussion.pso.imageedit.services.cache.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.ehcache.Cache;

import net.sf.ehcache.Element;

import com.percussion.pso.imageedit.data.ImageData;
import com.percussion.pso.imageedit.data.ImageMetaData;
import com.percussion.pso.imageedit.services.cache.ImageCacheManager;

public class ImageCacheManagerImpl implements ImageCacheManager
{
    private Log log = LogFactory.getLog(ImageCacheManagerImpl.class);
    private long counter; 
  
    private Cache cache; 
    
    public ImageCacheManagerImpl()
    {    
       counter = 1; 
       
    }
    
    /**
    * @see com.percussion.pso.imageedit.services.cache.ImageCacheManager#addImage(com.percussion.pso.imageedit.data.ImageMetaData)
    */
   public String addImage(ImageData data)    
    {
       String imageKey = generateKey(data);
       log.debug("new image key is "  + imageKey); 
       Element element = new Element(imageKey, data); 
       cache.put(element);
       
       return imageKey; 
    }
    
    /**
    * @see com.percussion.pso.imageedit.services.cache.ImageCacheManager#getImage(java.lang.String)
    */
   public ImageData getImage(String imageKey)
    {
       Element elem = cache.get(imageKey);
       if(elem == null)
       {
          return null; 
       }
       return (ImageData) elem.getValue();
    }
    
   public ImageMetaData getImageMetaData(String imageKey)
   {
      ImageData data = getImage(imageKey);
      if(data != null)
      {
         return new ImageMetaData(data);
      }
      return null;
   }
   public boolean hasImage(String imageKey)
   {
      return cache.isKeyInCache(imageKey);
   }
   
    /**
    * @see com.percussion.pso.imageedit.services.cache.ImageCacheManager#removeImage(java.lang.String)
    */
   public void removeImage(String imageKey)
    {
       cache.remove(imageKey);   
    }
    
    protected String generateKey(ImageMetaData data)
    {
       long value = data.getSize()+data.getHeight()*2; 
       String fname = data.getFilename();
       if(StringUtils.isNotBlank(fname))
       {
          value -= fname.hashCode();           
       }
       else
       {
          value -= "abc.xyz".hashCode();          
       }
       value = (value << 12) + counter++;     
       return Long.toHexString(value);
    }
    
   /**
    * @return the cache
    */
   public Cache getCache()
   {
      return cache;
   }

   /**
    * @param cache the cache to set
    */
   public void setCache(Cache cache)
   {
      this.cache = cache;
   }

  
    
    
}
