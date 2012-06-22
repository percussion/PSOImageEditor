/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * com.percussion.pso.imageedit.data ByteArrayDataSource.java
 *
 */
package com.percussion.pso.imageedit.data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataSource;

/**
 * A simple in-memory datasource. 
 *
 * @author DavidBenua
 *
 */
public class ByteArrayDataSource implements DataSource
{
   
   ByteArrayOutputStream store; 
   String name; 
   String contentType; 
   
   /**
    * 
    */
   public ByteArrayDataSource()
   {
      store = new ByteArrayOutputStream();
   }
   public ByteArrayDataSource(String name, String contentType)
   {
      this();
      this.name =  name;
      this.contentType = contentType;
   }
   
   public ByteArrayDataSource(String name, String contentType, int size)
   {
      this(name, contentType);
      store = new ByteArrayOutputStream(size);
   }
   /**
    * @see javax.activation.DataSource#getContentType()
    */
   public String getContentType()
   {
      return contentType;
   }
   /**
    * @see javax.activation.DataSource#getInputStream()
    */
   public InputStream getInputStream() throws IOException
   {
      ByteArrayInputStream bis = new ByteArrayInputStream(store.toByteArray()); 
      return bis; 
   }
   /**
    * @see javax.activation.DataSource#getName()
    */
   public String getName()
   {
      return name;
   }
   /**
    * @see javax.activation.DataSource#getOutputStream()
    */
   public OutputStream getOutputStream() throws IOException
   {
      return store;
   }
   
   /**
    * Gets the contents of the data as a byte array. 
    * @return the current contents. Never <code>null</code>. May be <code>empty</code>
    */
   public byte[] getBytes()
   {
      return store.toByteArray();
   }
}
