/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * com.percussion.pso.imageedit.data AbstractImageMetaData.java
 *
 */
package com.percussion.pso.imageedit.data;
public class AbstractImageMetaData
{
   private String imageKey;
   private ImageMetaData metaData;

   public AbstractImageMetaData()
   {
      super();
   }

   /**
    * @return the imageKey
    */
   public String getImageKey()
   {
      return imageKey;
   }

   /**
    * @param imageKey the imageKey to set
    */
   public void setImageKey(String imageKey)
   {
      this.imageKey = imageKey;
   }

   /**
    * @return the metaData
    */
   public ImageMetaData getMetaData()
   {
      return metaData;
   }

   /**
    * @param metaData the metaData to set
    */
   public void setMetaData(ImageMetaData metaData)
   {
      this.metaData = metaData;
   }
}