# TeamCity E2E Test Automation

Languages: ``Java``\
Test Framework: ``JUnit5``\
Libraries: ``Allure``, ``Webdrivermanager``


## Pre-Installation

- Install Java (*11*) 
- Install Maven (*3.6.3 or higher*)
- Install Allure (*for test report generation*)
- Install Lombok and Annotation Enable Processing

## Test Suite Run
1) optional step: if there are changes in Test Suite, please remove allure-results folder from root if exists
2) Run command (change values of env variables and put real data)
```bash
mvn -DskipTests clean verify
mvn test -Dtc.password=<user_password> -Dvcs.password=<vcs.password>
```

## Project Structure
```
project
│   README.md
│   pom.xml   
└───main
│   └───java
│       │   config (include classes for getting environemtnal variables and WebDriver Setup)
│       │   constants (includes enums for contant values)
│       │   utils (helper classes or wrappers)
│       │   pages (includes page object model classes)
```

## Tips

> For changing browser or URL of execution server type change values inside config.properties

> DON'T KEEP vulnerable information inside project (like passwords or access tokens), pass them as environmental variables
