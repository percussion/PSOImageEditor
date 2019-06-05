PSOImageEditor
==============

[Percussion Software](http://www.percussion.com "Percussion Software")

This is the PSOImageEditor Project for Percussion CMS. 

See the Wiki for an [overview](https://github.com/percussion/PSOImageEditor/wiki). 

The image editor allows for uploading, cropping, resizing and storing of multiple
    sizes of a single image. 

Use the following links to download the PSOImageEditor:

**Release Snapshot**

https://github.com/percussion/PSOImageEditor/releases

**Pre-Requisites**
The PSO Toolkit must be installed proper to installing the PSO Image Editor.

https://github.com/percussion/PSOToolkit/releases

**Installation**

Stop the Rhythmyx instance.

Unzip the distribution to your Rhythmyx/Patch folder.

Run install.bat or install.sh supplying the path to the Rhythmyx installation.

For example:

cd C:\Rhythmyx\Patch\psoimageeditor
install.bat c:\Rhythmyx

After installation, start the Rhythmyx service and use the Multi Server Manager tool to install the imedComponents.pda archive located in the msm folder.

Additional documentation can be found in the docs folder.

**Configuring MSM to avoid strict Version checking**

The MSM tool uses strict version checking when installing pda archives by default. 
This can cause problems as patch levels are increased.  To allow build version mismatches between the archive and the server, edit the RhythmyxMultiServerManager.lax

Update the Java options to look like the following:

lax.nl.java.option.additional=-Xmx256m -Dcom.percussion.deploy.allowBuildMismatch

Save the file and relaunch MSM.  You should now be able to install archives even if the archive does not exactly match your Rhythmyx server version.

**Developer Setup**

To run the build you need Apache Maven.

git clone <project Url>

cd PSOImageEditor

mvn clean install
    

