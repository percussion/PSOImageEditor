/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * com.percussion.pso.imageedit.data ImageEditorException.java
 *
 */
package com.percussion.pso.imageedit.data;

/**
 * Exception for image editor classes. This is an unchecked exception. 
 *
 * @author DavidBenua
 *
 */
public class ImageEditorException extends RuntimeException
{
   /**
    * 
    */
   public ImageEditorException()
   {
      // TODO Auto-generated constructor stub
   }
   /**
    * @param message
    */
   public ImageEditorException(String message)
   {
      super(message);
      
   }
   /**
    * @param cause
    */
   public ImageEditorException(Throwable cause)
   {
      super(cause);
      
   }
   /**
    * @param message
    * @param cause
    */
   public ImageEditorException(String message, Throwable cause)
   {
      super(message, cause);
   }
}
