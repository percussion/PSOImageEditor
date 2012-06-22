/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * test.percussion.pso.imageedit.data ImageDataTest.java
 *
 */
package test.percussion.pso.imageedit.data;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import com.percussion.pso.imageedit.data.ImageData;
import com.percussion.pso.imageedit.data.ImageMetaData;

public class ImageDataTest
{
   private static Log log = LogFactory.getLog(ImageDataTest.class);
   
   ImageData cut;
   @Before
   public void setUp() throws Exception
   {
      cut = new ImageData();
   }
   
   
   @Test
   public void testIsSerializable()
      {
         String sentence = "The quick brown fox jumped over the lazy dog"; 

         cut.setFilename("xyzzy.jpg");
         cut.setHeight(42);
         cut.setWidth(100);
         cut.setExt(".gif");
         cut.setMimeType("text/plain");
         cut.setSize(sentence.length()); 
         cut.setBinary(sentence.getBytes());
 
          try
         {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(out);
             oos.writeObject(cut);
             oos.close();
             assertTrue(out.toByteArray().length > 0);
             
             ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray()) ; 
             ObjectInputStream ois = new ObjectInputStream(in);
             Object o = ois.readObject();
             
             ImageMetaData c2 = (ImageMetaData) o; 
             
             assertEquals(cut.getFilename(), c2.getFilename()); 
             assertEquals(cut.getHeight(), c2.getHeight());
             assertEquals(cut.getSize(), c2.getSize()); 
             assertEquals(cut.getWidth(), c2.getWidth()); 
             assertEquals(cut.getMimeType(), c2.getMimeType()); 
         } catch (Exception ex)
         {
               log.error("Unexpected Exception " + ex,ex);
               fail("exception");
         }
         
   }
}
