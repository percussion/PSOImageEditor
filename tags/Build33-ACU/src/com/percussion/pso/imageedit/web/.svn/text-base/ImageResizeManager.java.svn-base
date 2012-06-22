/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * com.percussion.pso.imageedit.services ImageResizeManager.java
 *
 */
package com.percussion.pso.imageedit.web;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.InputStream;

import com.percussion.pso.imageedit.data.ImageData;

/**
 * Image resize manager resizes images based on dimensions input by the user.  
 * 
 * @author DavidBenua
 *
 */
public interface ImageResizeManager
{
  
   /**
    * Generates a resized and cropped image. The input image must be JPEG or other type supported by the 
    * java.imagio package.    The crop box and image size parameters are optional. 
    * @param input the input image. Never <code>null</code>. 
    * @param cropBox the crop box determines how the image is cropped.  If this parameter is 
    * <code>null</code>, the image is not cropped. 
    * @param size the desired image size. If <code>null</code> the image size will be the size of the crop
    * box (or the original image size if the crop box is also <code>null</code>
    * @return the resulting image metadata. 
    * @throws Exception
    */
   public ImageData generateImage(InputStream input, Rectangle cropBox, Dimension size) throws Exception;
   
}
