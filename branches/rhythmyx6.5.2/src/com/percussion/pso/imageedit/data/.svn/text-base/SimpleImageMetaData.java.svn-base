/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * com.percussion.pso.imageedit.data SimpleImageMetaData.java
 *
 */
package com.percussion.pso.imageedit.data;

/**
 * A Simple image with height and width.
 *
 * @author DavidBenua
 *
 */
public class SimpleImageMetaData extends AbstractImageMetaData
{

   /**
    * width in pixels.
    */
   private int width = 0;
   /**
    * height in pixels.
    */
   private int height = 0;

   /**
    * Default constructor.
    */
   public SimpleImageMetaData()
   {
      
   }
   
   /**
    * Copy constructor.
    * @param data metadata to copy from. 
    */
   public SimpleImageMetaData(AbstractImageMetaData data)
   {
      this.setImageKey(data.getImageKey());
      this.setMetaData(data.getMetaData());
      this.height = data.getMetaData().getHeight();
      this.width = data.getMetaData().getWidth(); 
   }
   /**
    * Gets the width.
    * @return the width.
    */
   public int getWidth()
   {
    	return width;
    }

   /**
    * Sets the width.
    * @param width the width to set. 
    */
   public void setWidth(int width)
   {
    	this.width = width;
    }

   /**
    * Gets the height.
    * @return the height.
    */
   public int getHeight()
   {
    	return height;
    }

   /**
    * Sets the height. 
    * @param height the height to set.  
    */
   public void setHeight(int height)
   {
    	this.height = height;
    }
   
   
}
