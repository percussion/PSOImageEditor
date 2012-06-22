<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
     <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
    
     <xsl:template match="/">
       	<xsl:apply-templates select="@*|node()" mode="copy"/>
     </xsl:template>
     
    <xsl:template match="web-app" mode="copy">
        <xsl:copy>
        <xsl:apply-templates select="@*" mode="copy"/>
        <xsl:apply-templates select="context-param" mode="copy" />
        <xsl:apply-templates select="filter" mode="copy" /> 
        <xsl:apply-templates select="filter-mapping" mode="copy" /> 
        <xsl:apply-templates select="listener" mode="copy" />          
        <xsl:apply-templates select="servlet" mode="copy"/>
        <xsl:if test="not(//servlet/servlet-name='PSOImageEditor')">
			<servlet>
				<servlet-name>PSOImageEditor</servlet-name>
				<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
				<init-param>
					<param-name>contextConfigLocation</param-name>
					<param-value>/WEB-INF/addins/PSOImageEditor/*-servlet.xml</param-value>
				</init-param>
			</servlet>
        </xsl:if>
        <xsl:apply-templates select="servlet-mapping" mode="copy"/>
        <xsl:if test="not(//servlet-mapping/servlet-name='PSOImageEditor')">
		   <servlet-mapping>
				<servlet-name>PSOImageEditor</servlet-name>
				<url-pattern>/user/addins/psoimageeditor/*</url-pattern>
			</servlet-mapping>
        </xsl:if>        
        <xsl:apply-templates select="mime-mapping" mode="copy"/>
        <xsl:apply-templates select="welcome-file-list" mode="copy"/>
        </xsl:copy>
    </xsl:template>
    
    <xsl:template match="@*|node()" mode="copy">
       <xsl:copy>       
           <xsl:apply-templates select="@*" mode="copy"/>
           <xsl:apply-templates select="node()" mode="copy" />
       </xsl:copy>   
    </xsl:template>
     
</xsl:stylesheet>
