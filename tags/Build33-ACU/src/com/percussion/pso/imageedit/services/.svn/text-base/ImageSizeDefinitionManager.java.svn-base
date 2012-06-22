/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * com.percussion.pso.imageedit.services ImageSizeDefinitionManager.java
 *
 */
package com.percussion.pso.imageedit.services;


import java.util.List;

import com.percussion.pso.imageedit.data.ImageSizeDefinition;

/**
 * Service for retrieving defined image sizes. 
 *
 * @author DavidBenua
 *
 */
public interface ImageSizeDefinitionManager
{
   /**
    * Get a specific image size by code. 
    * Will return <code>null</code> if the image size is not defined.
    * @param code the image size code. 
    * @return the image size definition, or <code>null</code> if the 
    * requested size is not defined. 
    */
   public ImageSizeDefinition getImageSize(String code);
   
   /**
    * Gets all defined image sizes. 
    * 
    * @return the list of defined image sizes. The order depends on 
    * the order of definitions in the beans XML.   
    */
   public List<ImageSizeDefinition> getAllImageSizes();  
   
   /**
    * Gets the Node name where the sized images are stored.
    * @return the sizedImageNodeName
    */
   public String getSizedImageNodeName();
   
   /**
    * Gets the property name of the image size code in the 
    * sized image child node. 
    * 
    * @return the sizedImagePropertyName
    */
   public String getSizedImagePropertyName();
   
   /**
    * Gets the image path to be used when there 
    * is no image. 
    * @return the failureImagePath
    */
   public String getFailureImagePath();
   
   
}
