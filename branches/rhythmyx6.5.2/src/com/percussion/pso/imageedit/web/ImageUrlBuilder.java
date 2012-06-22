/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * com.percussion.pso.imageedit.web ImageUrlBuilder.java
 *
 */
package com.percussion.pso.imageedit.web;
public interface ImageUrlBuilder
{
   public String buildUrl(String imageKey);
   public String extractKey(String url);
}