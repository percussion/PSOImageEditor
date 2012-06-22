/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * test.percussion.pso.imageedit.data ByteArrayDataSourceTest.java
 *
 */
package test.percussion.pso.imageedit.data;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import com.percussion.pso.imageedit.data.ByteArrayDataSource;

public class ByteArrayDataSourceTest
{
   private static Log log = LogFactory.getLog(ByteArrayDataSourceTest.class);
   
   ByteArrayDataSource cut; 
   @Before
   public void setUp() throws Exception
   {
     
   }
   @Test
   public final void testByteArrayDataSourceStringStringInt()
   {
      log.debug("testing new bytearraydatasource"); 
      cut = new ByteArrayDataSource("xname", "text/plain", 42);
      assertEquals("xname", cut.getName());
      assertEquals("text/plain", cut.getContentType()); 
      assertEquals(0, cut.getBytes().length); 
   }
}
