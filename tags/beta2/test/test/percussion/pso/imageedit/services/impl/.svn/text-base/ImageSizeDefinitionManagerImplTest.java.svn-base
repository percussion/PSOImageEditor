/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * test.percussion.pso.imageedit.services.impl ImageSizeDefinitionManagerImplTest.java
 *
 */
package test.percussion.pso.imageedit.services.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.percussion.pso.imageedit.data.ImageSizeDefinition;
import com.percussion.pso.imageedit.services.impl.ImageSizeDefinitionManagerImpl;

/**
 * 
 *
 * @author DavidBenua
 *
 */
public class ImageSizeDefinitionManagerImplTest
{
   
   List<ImageSizeDefinition> sizes;
   
   ImageSizeDefinitionManagerImpl cut; 
   /**
    * @throws java.lang.Exception
    */
   @Before
   public void setUp() throws Exception
   {
      cut = new ImageSizeDefinitionManagerImpl(); 
      sizes = new ArrayList<ImageSizeDefinition>(3);
      sizes.add(new ImageSizeDefinition(){{setCode("a");setLabel("Label A");}});
      sizes.add(new ImageSizeDefinition(){{setCode("b");setLabel("Label B");}});
      sizes.add(new ImageSizeDefinition(){{setCode("c");setLabel("Label C");}});
      cut.setSizes(sizes); 
   }
   /**
    * Test method for {@link com.percussion.pso.imageedit.services.impl.ImageSizeDefinitionManagerImpl#getImageSize(java.lang.String)}.
    */
   @Test
   public final void testGetImageSize()
   {
      ImageSizeDefinition r = cut.getImageSize("a"); 
      assertNotNull(r);
      assertEquals("Label A", r.getLabel()); 
      
      r = cut.getImageSize("q");
      assertNull(r); 
      
      
   }
}
