# README #

Manage everyThing with all the flexibility

### Garage management ###

DEV
  mvn -o -Pdev clean spring-boot:run
 
TEST
  mvn -Ptest clean package
  scp target/things-webapp-0.1-SNAPSHOT.war thegreendodo.com:.
