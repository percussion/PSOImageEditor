PSOImageEditor
==============
[Percussion Software](http://www.percussion.com "Percussion Software")

This is the PSOImageEditor Project for Percussion CMS. 

See the Wiki for an [overview](https://github.com/percussion/PSOImageEditor/wiki). 

The image editor allows for uploading, cropping, resizing and storing of multiple
    sizes of a single image. 

Use the following links to download the PSOImageEditor:

Release Snapshot

http://cdn.percussion.com/downloads/open/psoimageeditor/pso-image-editor-7.3.2-SNAPSHOT-distribution.zip 

Stop the Rhythmyx instance.

Unzip the distribution to your Rhythmyx/Patch folder.

Run install.bat or install.sh supplying the path to the Rhythmyx installation.

For example:

cd C:\Rhythmyx\Patch\psoimageeditor
install.bat c:\Rhythmyx

After installation, start the Rhythmyx service and use the Multi Server Manager tool to install the imedComponents.pda archive located in the msm folder.

Additional documentation can be found in the docs folder.
==Developer Setup==

To run the build you need Apache Maven.

git clone <project Url>

cd PSOImageEditor

mvn clean install
    

