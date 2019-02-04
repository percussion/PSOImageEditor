PSOImageEditor
==============
[Percussion Software](http://www.percussion.com "Percussion Software")

This is the PSOImageEditor Project for Percussion CMS. 

See the Wiki for an [overview](https://github.com/percussion/PSOImageEditor/wiki). 

The image editor allows for uploading, cropping, resizing and storing of multiple
    sizes of a single image. 

Use the following links to download the PSOImageEditor:

Release

http://cdn.percussion.com/downloads/open/psoimageeditor/PSOImageEditor.zip

Nightly Developemnt

http://cdn.percussion.com/downloads/open/psoimageeditor/pso-image-editor-development.zip

Nightly Snapshot

http://cdn.percussion.com/downloads/open/psoimageeditor/pso-image-editor-SNAPSHOT.zip


To deploy the toolkit, unzip the distribution into an empty directory. 

You must have Java 1.5 and Apache Ant properly installed. 

The RHYTHMYX_HOME environment variable must point at your 
Rhythmyx 6.6 installation.  

Type the command: 

ant -f deploy.xml 


==Developer Setup==

To run the build you need Apache Maven.

mvn clean install

