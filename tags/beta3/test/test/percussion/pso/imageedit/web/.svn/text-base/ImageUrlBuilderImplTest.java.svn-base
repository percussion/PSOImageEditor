/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * test.percussion.pso.imageedit.web ImageUrlBuilderImplTest.java
 *
 */
package test.percussion.pso.imageedit.web;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import com.percussion.pso.imageedit.web.impl.ImageUrlBuilderImpl;

public class ImageUrlBuilderImplTest
{
   private static Log log = LogFactory.getLog(ImageUrlBuilderImplTest.class);
   ImageUrlBuilderImpl cut; 
   @Before
   public void setUp() throws Exception
   {
     cut = new ImageUrlBuilderImpl(); 
     cut.setBaseUrl("/xyzzy"); 
   }
   @Test
   public final void testBuildUrl()
   {
       String url = cut.buildUrl("12345"); 
       assertNotNull(url); 
       assertTrue(url.contains("xyzzy/img12345.jpg")); 
   }
   @Test
   public final void testExtractKey()
   {
       String key = cut.extractKey("/xyzzy/img12345.jpg"); 
       assertNotNull(key);
       assertEquals("12345",key);
   }
   
   @Test
   public final void testExtractKeyNull()
   {
      try
      {
         String key = cut.extractKey(null);
      } catch (IllegalArgumentException ex)
      {
         log.info("Expected Exception " + ex + " caught");
         assertTrue(true);
      }
   }
   
}
