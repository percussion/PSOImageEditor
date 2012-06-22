@echo off
@setlocal
set JAVA_HOME=..\..\JRE
set ANT_HOME=..\..\Patch\InstallToolkit
set CLASSPATH=
set RHYTHMYX_HOME=..\..\

%ANT_HOME%\bin\ant.bat -f deploy.xml
@endlocal