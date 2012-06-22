/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * com.percussion.pso.imageedit.services ImageSizeDefinitionManagerLocator.java
 *
 */
package com.percussion.pso.imageedit.services;

import com.percussion.services.PSBaseServiceLocator;

/**
 * 
 *
 * @author DavidBenua
 *
 */
public class ImageSizeDefinitionManagerLocator extends PSBaseServiceLocator
{
   /**
    * Static methods only 
    */
   private ImageSizeDefinitionManagerLocator()
   {
   }
   
   public static ImageSizeDefinitionManager getImageSizeDefinitionManager()
   {
      return (ImageSizeDefinitionManager)getBean(IMAGE_SIZE_DEFINITION_MANAGER_BEAN);
   }
   
   private static final String IMAGE_SIZE_DEFINITION_MANAGER_BEAN = "imedImageSizeDefinitionManager";
}
