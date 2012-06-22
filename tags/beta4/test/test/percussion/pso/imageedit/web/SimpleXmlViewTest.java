/*
 * test.percussion.pso.preview SimpleXmlViewTest.java
 *  
 * @author DavidBenua
 *
 */
package test.percussion.pso.imageedit.web;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.percussion.pso.imageedit.web.SimpleXmlView;
import com.percussion.xml.PSXmlDocumentBuilder;

public class SimpleXmlViewTest
{
   Log log = LogFactory.getLog(SimpleXmlViewTest.class);
   SimpleXmlView cut; 
   Map<String, Object> model; 
   @Before
   public void setUp() throws Exception
   {
      cut = new SimpleXmlView();
      model = new HashMap<String, Object>(); 
      cut.setEncoding("UTF-8"); 
   }
   @Test
   public final void testRenderMergedOutputModelMapHttpServletRequestHttpServletResponse()
   {
      Document doc = PSXmlDocumentBuilder.createXmlDocument();
      Element root = PSXmlDocumentBuilder.createRoot(doc, "root");
      
      MockHttpServletRequest request = new MockHttpServletRequest(); 
      MockHttpServletResponse response = new MockHttpServletResponse(); 
      cut.setResultKey("foo"); 
      model.put("foo",doc); 
      
      try
      {
         cut.render(model, request, response);
         byte[] output = response.getContentAsByteArray(); 
         String oString = new String(output,"UTF-8"); 
         assertNotNull(oString); 
         assertTrue(oString.contains("root")); 
         log.info("output is " + oString); 
      } catch (Exception ex)
      {
         log.error("Unexpected Exception " + ex,ex);
         fail("Exception"); 
      } 
      
   }
   
   @Test
   public final void testRenderMergedOutputWrongType()
   {
      Document doc = PSXmlDocumentBuilder.createXmlDocument();
      Element root = PSXmlDocumentBuilder.createRoot(doc, "root");
      
      MockHttpServletRequest request = new MockHttpServletRequest(); 
      MockHttpServletResponse response = new MockHttpServletResponse(); 
      cut.setResultKey("foo"); 
      model.put("foo","doc"); 
      
      try
      {
         cut.render(model, request, response);
         fail("Should throw exception"); 
      } catch (Exception ex)
      {
         assertTrue("ExpectedException",true); 
      } 
      
   }
   @Test
   public final void testRenderMergedOutputWrongName()
   {
      Document doc = PSXmlDocumentBuilder.createXmlDocument();
      Element root = PSXmlDocumentBuilder.createRoot(doc, "root");
      
      MockHttpServletRequest request = new MockHttpServletRequest(); 
      MockHttpServletResponse response = new MockHttpServletResponse(); 
      cut.setResultKey("faz"); 
      model.put("foo","doc"); 
      
      try
      {
         cut.render(model, request, response);
         fail("Should throw exception"); 
      } catch (Exception ex)
      {
         assertTrue("ExpectedException",true); 
      } 
      
   }

}
