##spring-web-mvc-bootstrap


Use to Bootstrap a New Spring MVC Application with Spring Security

##Live Demo


http://web-bootstrap-trial.herokuapp.com

##Running Locally




##Deploying to Heroku

Deploying to Heroku should be fairly straightforward. Most of the required configuration is in place.

1. Create a new Heroku Application
2. Add the ClearDB Database plugin
3. Add the SendGrid Email plugin
4. Add a new git remote: **git remote add {remote_alias} git@heroku.com:{my_heroku_app_name}.git**
5. Add a new environment variable to the Heroku app named 'spring.profiles.active' with a value of 'trial'. Non-sensitive properties will be read from this file.
6. For sensitive properties which cannot be checked in to a public repository, add the following environment variables the relevant values. These can also be read from Spring properties file if security is not an issue)
  * database.server
  * database.name
  * database.user
  * database.password
  * smtp.user
  * smtp.password
7. Update the config to run on JDK 7: https://devcenter.heroku.com/articles/add-java-version-to-an-existing-maven-app
8. Deploy to Heroku using the remote alias created in step [4]: **git push {alias} master**

##Non-Repository Dependencies

This project depends on the Respository and Service modules. If we have not published these to a public Maven Repository then we can still make these
available to Heroku by specifying a file repository in the POM and copying the compiles JARs and their associated POMs to this location.

