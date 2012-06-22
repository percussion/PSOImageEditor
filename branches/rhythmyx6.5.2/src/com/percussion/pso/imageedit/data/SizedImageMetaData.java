/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * com.percussion.pso.imageedit.data SizedImageMetaData.java
 *
 */
package com.percussion.pso.imageedit.data;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * A Sized Image. 
 *
 * @author DavidBenua
 *
 */
public class SizedImageMetaData extends SimpleImageMetaData
{
    private ImageSizeDefinition sizeDefinition;

	private int x = 0;
	private int y = 0;
	private Boolean constraint = true;

   public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

/**
    * @return the sizeDefinition
    */
   public ImageSizeDefinition getSizeDefinition()
   {
      return sizeDefinition;
   }

   /**
    * @param sizeDefinition the sizeDefinition to set
    */
   public void setSizeDefinition(ImageSizeDefinition sizeDefinition)
   {
      this.sizeDefinition = sizeDefinition;
   }
    
   public String toString() 
   {
      return ToStringBuilder.reflectionToString(this);
   }

public Boolean isConstraint()
{
	return constraint;
}

public void setConstraint(Boolean constraint)
{
	this.constraint = constraint;
}

   
}
