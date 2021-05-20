# README #

Manage everyThing with all the flexibility

### What is this repository for? ###

* Quick summary
* Version
* [Learn Markdown](https://bitbucket.org/tutorials/markdowndemo)

### Who do I talk to? ###

* Repo owner or admin
* Other community or team contact


### Garage management ###

export GOOGLE_APPLICATION_CREDENTIALS=/Users/hmora/workspace_personal/things/src/main/resources/midyear-freedom-298509-ce216e5095cd.json

DEV
  mvn -o -Pdev clean spring-boot:run
 
TEST
  mvn -Ptest clean package
  scp target/things-webapp-0.1-SNAPSHOT.war thegreendodo.com:.
