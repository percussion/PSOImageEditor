/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * test.percussion.pso.imageedit.services.cache.impl ImageCacheManagerImplTest.java
 *
 */
package test.percussion.pso.imageedit.services.cache.impl;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import com.percussion.pso.imageedit.data.ImageMetaData;
import com.percussion.pso.imageedit.services.cache.impl.ImageCacheManagerImpl;

public class ImageCacheManagerImplTest
{
   private static Log log = LogFactory.getLog(ImageCacheManagerImplTest.class);
 
   TestableImageCacheManagerImpl cut; 
   @Before
   public void setUp() throws Exception
   {
      cut = new TestableImageCacheManagerImpl();
   }
   @Test
   public final void testGenerateKey()
   {
       ImageMetaData data = new ImageMetaData();
       data.setSize(1234L); 
       data.setHeight(458);
       data.setFilename("xyz.jpg"); 
       
       String key = cut.generateKey(data);
       assertNotNull(key); 
       log.info("key is " + key); 
       
       String key2 = cut.generateKey(data);
       assertNotNull(key2);
       log.info("key2 is " + key2); 
       assertFalse(key.equals(key2));
       
   }
   
   @Test
   public final void testGenerateKeyNull()
   {
       ImageMetaData data = new ImageMetaData();
       
       String key = cut.generateKey(data);
       assertNotNull(key); 
       log.info("key is " + key); 
       
   }
   private class TestableImageCacheManagerImpl extends 
      ImageCacheManagerImpl
      {

      /**
       * @see com.percussion.pso.imageedit.services.cache.impl.ImageCacheManagerImpl#generateKey(com.percussion.pso.imageedit.data.ImageMetaData)
       */
      @Override
      public String generateKey(ImageMetaData data)
      {
         return super.generateKey(data);
      }
         
      }
}
