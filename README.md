PSOImageEditor
==============
[Percussion Software](http://www.percussion.com "Percussion Software")

This is the PSOImageEditor Project for Rhythmyx 6.6 or greater. 

See the Wiki for an [overview](https://github.com/percussion/PSOImageEditor/wiki). 

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

--------------------------------------------------
Setting up a Development Environment with Eclipse
--------------------------------------------------
- Download and install the Sun/Oracle Java 1.6 JDK - point a JAVA_HOME environment variable at this location, make JAVA_HOME/bin the first java in the system path.
- In your Eclipse Preferences - Java -> Installed JREs, add a JRE for the 1.6 JDK you installed if it is not there already
- Make that JRE the Workspace default. 
- Download, extract, and install Apache Ant
- Add ANT_HOME environment variable pointed at your ant directory
- Append ANT_HOME\bin to your PATH 
- Download  & extract Apache IVY (with dependencies)
- In your HOME directory create a .ant/lib folder. e.g. CD %HOME%;mkdir -p .ant\lib
- Add IVY_HOME environment variable pointed to where Ivy was extracted.
- Copy IVY_HOME/*.jar and IVY_HOME/lib/*.jar to your HOME/.ant/lib directory
- Import the project from GitHub using the Eclipse Import..Git->Projects from Git Command
- Select the trunk project if prompted with multiple versions of the same project. (these were migrated from subversion)
- Once imported copy ivy-local.sample.properties to ivy-local.properties
- Right click on build.xml and Select Run As-> Ant Build ...
- Select the ivy:retrieve option followed by the dist option. 
- Verify that the task order is the correct (ivy first) and click ok. 
- This should download all the required dependencies and run the build.
- Refresh your Eclipse project when the build completes.

Follow the deployment instructions above. 
