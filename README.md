PSOImageEditor
==============
[Percussion Software](http://www.percussion.com "Percussion Software")

This is the PSOImageEditor Project for Rhythmyx 6.6  

The image editor allows for uploading, cropping, resizing and storing of multiple
    sizes of a single image. 

THIS VERSION REQUIRES RHYTHMYX 6.6 OR LATER 


To deploy the toolkit, unzip the distribution into an empty directory. 

You must have Java 1.5 and Apache Ant properly installed. 

The RHYTHMYX_HOME environment variable must point at your 
Rhythmyx 6.6 installation.  

Type the command: 

ant -f deploy.xml 


Note: for deployment on Rhythmyx 6.6, you need to replace the version of Ehcache 
and it's dependencies on the server.  The server ships with Ehcache 1.2.3 and 
Spring 2.5.5, and Spring 2.5.5 requires Ehcache 1.4.1 or later.

To install you must do the following: 
1) remove ehcache-1.2.3.jar from both AppServer/server/rx/lib and rxapp.ear/rxapp.war/WEB-INF/lib

2) add AppServer/server/rx/lib:
	ehcache-1.4.1
	jsr107cache.jar
	backport-util-concurrent.jar 
	
3 add ehcache-1.4.1.jar into rxapp.ear/rxapp.war/WEB-INF/lib

In our current JBoss (4.0.3), we still need to put most of the jar files into 
both rx/lib and rxapp.war/WEB-INF/lib when they are needed during server start.

All of these JAR files can be found lib folder in the zip file. 

