/*******************************************************************************
 * Copyright (c) 1999-2011 Percussion Software.
 * 
 * Permission is hereby granted, free of charge, to use, copy and create derivative works of this software and associated documentation files (the "Software") for internal use only and only in connection with products from Percussion Software. 
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *  
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL PERCUSSION SOFTWARE BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package test.percussion.pso.imageedit.web;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import com.percussion.pso.imageedit.web.impl.ImageUrlBuilderImpl;

public class ImageUrlBuilderImplTest
{
   private static Log log = LogFactory.getLog(ImageUrlBuilderImplTest.class);
   ImageUrlBuilderImpl cut; 
   @Before
   public void setUp() throws Exception
   {
     cut = new ImageUrlBuilderImpl(); 
     cut.setBaseUrl("/xyzzy"); 
   }
   @Test
   public final void testBuildUrl()
   {
       String url = cut.buildUrl("12345"); 
       assertNotNull(url); 
       assertTrue(url.contains("xyzzy/img12345.jpg")); 
   }
   @Test
   public final void testExtractKey()
   {
       String key = cut.extractKey("/xyzzy/img12345.jpg"); 
       assertNotNull(key);
       assertEquals("12345",key);
   }
   
   @Test
   public final void testExtractKeyNull()
   {
      try
      {
         String key = cut.extractKey(null);
      } catch (IllegalArgumentException ex)
      {
         log.info("Expected Exception " + ex + " caught");
         assertTrue(true);
      }
   }
   
}
