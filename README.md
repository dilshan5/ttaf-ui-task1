# Tronium Test Automation Framework  - Web
This is a Cucumber-Java Project. Followed BDD approach,

# Getting Started
 First you need to clone the 'master' branch of this project into your local machine. After that you can open configuration.properties file and set your desired browser for testing.
 
 # Prerequisites

Supported Browsers : Chrome, Firefox, Internet Explorer(IE), Microsoft Edge (EdgeHTML), Safari

Make sure you have already installed the browser you want to execute in your local machine. Also, change the test plan parameters as needed.

Notes : 
 - "Enhanced Protected Mode" must be disabled for IE 10 and higher.
 - Check your Chrome/Firefox browser version and chrome driver compatibility (refer 'src/test/resources/driver' folder). If it is not compatible download Chrome/Firefox driver and replace it.
 
# Running the Test Suite via XML file

Goto SmokeTes.xml and configure your browser details and start Run.

# Running the Test Suite via CLI
  
 Make sure you successfully import all the maven dependencies. After that run the following command to start the execution,

  mvn clean install -P<suite_name>
  
  To run scenarios in parallel,
  
    mvn clean install -PSmokeTest
   
