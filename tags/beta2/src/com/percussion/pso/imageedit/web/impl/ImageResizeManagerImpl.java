/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * com.percussion.pso.imageedit.services.impl ImageResizeManagerImpl.java
 *
 */
package com.percussion.pso.imageedit.web.impl;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.percussion.pso.imageedit.data.ImageData;
import com.percussion.pso.imageedit.web.ImageResizeManager;

/**
 * 
 *
 * @author DavidBenua
 *
 */
public class ImageResizeManagerImpl implements ImageResizeManager
{
   private static Log log = LogFactory.getLog(ImageResizeManagerImpl.class);
   
   private String imageFormat = "jpeg";
   private String extension = "jpg"; 
   private String contentType = "image/jpeg"; 
   
   /**
    * @see com.percussion.pso.imageedit.web.ImageResizeManager#generateImage(java.io.InputStream, java.awt.Rectangle, java.awt.Dimension)
    */
   public ImageData generateImage(InputStream input, Rectangle cropBox,
         Dimension size) throws Exception
   {
      ImageData result = new ImageData(); 
      result.setExt(this.getExtension());
      result.setMimeType(this.getContentType()); 
      
      log.debug("generating Image");       
     
      //compute the desired size. 
      
      Dimension outsize; 
      BufferedImage inImage = ImageIO.read(input);
      if(size != null)
      {
         outsize = new Dimension(size);
      }
      else if(cropBox != null)
      {
         outsize = new Dimension(cropBox.width, cropBox.height); 
      }
      else
      {
         outsize = new Dimension(inImage.getWidth(), inImage.getHeight());    
      }      
      log.debug("Output size is " + outsize); 
      Rectangle sourceBox; 
      if(cropBox != null)
      {
           sourceBox = new Rectangle(cropBox);
      }
      else
      {
           sourceBox = new Rectangle(0, 0, inImage.getWidth(), inImage.getHeight() ); 
      }
      
      log.debug("Source Box is " + sourceBox);
      
   // Create an image buffer in which to paint on.
      BufferedImage outImage = new BufferedImage(outsize.width, outsize.height,
                                                 BufferedImage.TYPE_INT_RGB);
      Graphics2D g2d = outImage.createGraphics();
      g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BICUBIC);
      
      boolean done = g2d.drawImage(inImage, 0, 0, outsize.width, outsize.height, 
            sourceBox.x, sourceBox.y, (sourceBox.x + sourceBox.width), (sourceBox.y + sourceBox.height), null);      
      if(!done)
      {
         log.info("Image not done"); 
         //what to do here? 
      }
      
      ByteArrayOutputStream outStream = new ByteArrayOutputStream();
      
      ImageIO.write(outImage, this.getImageFormat(), outStream);
      outStream.flush();
      result.setWidth(outsize.width);
      result.setHeight(outsize.height);
      result.setSize(outStream.size());
      log.debug("output size is " + result.getSize());
      result.setBinary(outStream.toByteArray()); 
      return result;
   }

   /**
    * @return the imageFormat
    */
   public String getImageFormat()
   {
      return imageFormat;
   }

   /**
    * @param imageFormat the imageFormat to set
    */
   public void setImageFormat(String imageFormat)
   {
      this.imageFormat = imageFormat;
   }

   /**
    * @return the extension
    */
   public String getExtension()
   {
      return extension;
   }

   /**
    * @param extension the extension to set
    */
   public void setExtension(String extension)
   {
      this.extension = extension;
   }

   /**
    * @return the contentType
    */
   public String getContentType()
   {
      return contentType;
   }

   /**
    * @param contentType the contentType to set
    */
   public void setContentType(String contentType)
   {
      this.contentType = contentType;
   }
   
   
   
}
