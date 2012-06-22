/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * test.percussion.pso.imageedit.services.impl ImageResizeManagerImplTest.java
 *
 */
package test.percussion.pso.imageedit.web;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import com.percussion.pso.imageedit.data.ImageMetaData;
import com.percussion.pso.imageedit.web.impl.ImageResizeManagerImpl;

public class ImageResizeManagerImplTest
{
   Log log = LogFactory.getLog(ImageResizeManagerImplTest.class);
   
   ImageResizeManagerImpl cut; 
   @Before
   public void setUp() throws Exception
   {
      cut = new ImageResizeManagerImpl();
   }
   
   @Test
   public final void testGenerateImageSimple()
   {
      try
      {
         InputStream imgStream = getClass().getClassLoader().getResourceAsStream("test/percussion/pso/imageedit/services/impl/Sample.jpg"); 
         
         ImageMetaData result = cut.generateImage(imgStream, null, null);
         
         assertNotNull(result);
         assertEquals(283, result.getWidth()); 
         assertEquals(212, result.getHeight());
         
      } catch (Exception ex)
      {
         log.error("Unexpected Exception " + ex,ex);
         fail("Exception"); 
      }
   
   }
   
   @Test
   public final void testGenerateImageScaled()
   {
      try
      {
         InputStream imgStream = getClass().getClassLoader().getResourceAsStream("test/percussion/pso/imageedit/services/impl/Sample.jpg"); 
    
         Dimension imgSize = new Dimension(102,111);
         ImageMetaData result = cut.generateImage(imgStream, null, imgSize);
         
         assertNotNull(result);
         assertEquals(102, result.getWidth()); 
         assertEquals(111, result.getHeight());
         
      } catch (Exception ex)
      {
         log.error("Unexpected Exception " + ex,ex);
         fail("Exception"); 
      }
   
   }
   
   @Test
   public final void testGenerateImageCropped()
   {
      try
      {
         InputStream imgStream = getClass().getClassLoader().getResourceAsStream("test/percussion/pso/imageedit/services/impl/Sample.jpg"); 
    
         Rectangle crop = new Rectangle(10, 20, 102, 111); 
         ImageMetaData result = cut.generateImage(imgStream, crop, null);
         
         assertNotNull(result);
         assertEquals(102, result.getWidth()); 
         assertEquals(111, result.getHeight());
         
      } catch (Exception ex)
      {
         log.error("Unexpected Exception " + ex,ex);
         fail("Exception"); 
      }
   
   }
   
   @Test
   public final void testGenerateImageBoth()
   {
      try
      {
         InputStream imgStream = getClass().getClassLoader().getResourceAsStream("test/percussion/pso/imageedit/services/impl/Sample.jpg"); 
    
         Rectangle crop = new Rectangle(10, 20, 102, 111); 
         Dimension size = new Dimension(55, 75);
         ImageMetaData result = cut.generateImage(imgStream, crop, size);
         
         assertNotNull(result);
         assertEquals(55, result.getWidth()); 
         assertEquals(75, result.getHeight());
         
      } catch (Exception ex)
      {
         log.error("Unexpected Exception " + ex,ex);
         fail("Exception"); 
      }
   
   }
   
   @Test
   public final void testComputeWidthFromAspect()
   {
      Rectangle box = new Rectangle(100, 200);
      Dimension size = new Dimension(300, 0); 
      
      Dimension result = cut.computeSizeFromAspectRatio(box, size); 
      assertEquals(600, result.height);
   }
   
   @Test
   public final void testComputeHeightFromAspect()
   {
      Rectangle box = new Rectangle(100, 200);
      Dimension size = new Dimension(0, 300); 
      
      Dimension result = cut.computeSizeFromAspectRatio(box, size); 
      assertEquals(150, result.width);
   }
}
