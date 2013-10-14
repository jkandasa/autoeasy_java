Documents: https://github.com/jkandasa/autoeasy/wiki
Download Binary Build: https://sourceforge.net/projects/autoeasy/files/

Create Eclipse Project:

  mvn eclipse:eclpise
  
To create application bundle:

  run it on parent location (autoeasy)
  mvn clean package assembly:assembly
  
  autoeasy*.zip file will be generated on "autoeasy/autoeasy/target"
