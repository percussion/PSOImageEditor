/*
 * COPYRIGHT (c) 1999 - 2008 by Percussion Software, Inc., Woburn, MA USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Percussion.
 *
 * test.percussion.pso.imageedit.services.jexl ImageEditorToolsTest.java
 *
 */
package test.percussion.pso.imageedit.services.jexl;

import static org.junit.Assert.*;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Property;
import javax.jcr.RepositoryException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.Sequence;
import org.junit.Before;
import org.junit.Test;

import com.percussion.pso.imageedit.services.ImageSizeDefinitionManager;
import com.percussion.pso.imageedit.services.jexl.ImageEditorTools;

public class ImageEditorToolsTest
{
   private static Log log = LogFactory.getLog(ImageEditorToolsTest.class);
   
   Mockery context;
   ImageEditorTools cut;
   ImageSizeDefinitionManager isdm; 
   Node parent; 
   NodeIterator nodes;
   Node nodea;
   Node nodeb;
   Property propa;
   Property propb; 
   Sequence nodeSeq; 
   
   @Before
   public void setUp() throws Exception
   {
      context = new Mockery(); 
      cut = new ImageEditorTools(); 
      isdm = context.mock(ImageSizeDefinitionManager.class);
      cut.setIsdm(isdm);
      context.checking(new Expectations(){{
         one(isdm).getSizedImageNodeName();
         will(returnValue("child1"));
         one(isdm).getSizedImagePropertyName();
         will(returnValue("foo")); 
      }});
      parent = context.mock(Node.class);
      nodes = context.mock(NodeIterator.class);
      nodeSeq = context.sequence("nodes");
      nodea = context.mock(Node.class);
      nodeb = context.mock(Node.class);
      propa = context.mock(Property.class);
      propb = context.mock(Property.class); 
   }
   
   @Test
   public final void testGetSizedNodeA()
   {
      try
      {
         setNodeExpectations();
         context.checking(new Expectations(){{
            one(parent).getNodes("child1");
            will(returnValue(nodes));
            one(nodes).hasNext(); inSequence(nodeSeq); 
            will(returnValue(true));
            one(nodes).nextNode(); inSequence(nodeSeq);
            will(returnValue(nodea));            
         }});   
         Node result = (Node) cut.getSizedNode(parent, "a"); 
         assertEquals(nodea, result); 
         context.assertIsSatisfied();
         
      } catch (RepositoryException ex)
      {
         log.error("Unexpected Exception " + ex,ex);
         fail("exception"); 
      }
      
   }
   
   @Test
   public final void testGetSizedNodeB()
   {
      try
      {
         setNodeExpectations();
         context.checking(new Expectations(){{
            one(parent).getNodes("child1");
            will(returnValue(nodes));
            one(nodes).hasNext(); inSequence(nodeSeq); 
            will(returnValue(true));
            one(nodes).nextNode(); inSequence(nodeSeq);
            will(returnValue(nodea));
            one(nodes).hasNext();inSequence(nodeSeq);
            will(returnValue(true));
            one(nodes).nextNode();inSequence(nodeSeq);
            will(returnValue(nodeb));            
         }});   
         Node result = (Node) cut.getSizedNode(parent, "b"); 
         assertEquals(nodeb, result); 
         context.assertIsSatisfied();
         
      } catch (RepositoryException ex)
      {
         log.error("Unexpected Exception " + ex,ex);
         fail("exception"); 
      }
      
   }
   
   @Test
   public final void testHasSizedNodeC()
   {
      try
      {
         setNodeExpectations();
         context.checking(new Expectations(){{
            one(parent).getNodes("child1");
            will(returnValue(nodes));
            one(nodes).hasNext(); inSequence(nodeSeq); 
            will(returnValue(true));
            one(nodes).nextNode(); inSequence(nodeSeq);
            will(returnValue(nodea));
            one(nodes).hasNext();inSequence(nodeSeq);
            will(returnValue(true));
            one(nodes).nextNode();inSequence(nodeSeq);
            will(returnValue(nodeb));
            one(nodes).hasNext(); inSequence(nodeSeq);
            will(returnValue(false));
         }});   
         boolean result = cut.hasSizedNode(parent, "c"); 
         assertFalse(result);
         context.assertIsSatisfied();
         
      } catch (RepositoryException ex)
      {
         log.error("Unexpected Exception " + ex,ex);
         fail("exception"); 
      }
      
   }
   private void setNodeExpectations() throws RepositoryException
   {
      context.checking(new Expectations(){{
        allowing(nodea).getProperty("foo");
        will(returnValue(propa));
        allowing(nodeb).getProperty("foo");
        will(returnValue(propb));
        allowing(propa).getString();
        will(returnValue("a"));
        allowing(propb).getString();
        will(returnValue("b")); 
      }});
   }
   
}
