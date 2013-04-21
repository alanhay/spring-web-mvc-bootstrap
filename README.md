spring-web-mvc-bootstrap
========================

Use to Bootstrap a New Spring MVC Application with Spring Security

Live Demo
=========

http://web-bootstrap-trial.herokuapp.com

Running Locally
===============



Deploying to Heroku
===================

[1] Create a new Heroku Application
[2] Add the ClearDB Database plugin
[3] Add the SendGrid Email plugin
[4] Add a new git remote: git remote add {remote_alias} git@heroku.com:{my_heroku_app_name}.git
[5] Add a new environment variable to the Heroku app named 'spring.profiles.active' with a value of 'trial'
[6] Create a copy of the file src\main\resources\trial.profile.properties.template named trial.profile.properties in the same directory
[7] Populate the database and SMTP settings in trial.profile.properties with your ClearDB and SendGrid details.
[8] Deploy to Heroku using the remote alias created in step [4]. 

Non-Repository Dependencies
===========================

This project depends on the Respository and Service modules. If we have not published these to a public Maven Repository then we can still make these
available to Heroku by specifying a file repository in the POM and copying the compiles JARs and their associated POMs to this location.

