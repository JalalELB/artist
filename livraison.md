# MariaDB Installation :
* Install MariaDB from the website https://mariadb.org/download
* Create a new schema database with the following name : "chinook"
* 2 ways to establish a BDD connexion :
  * Create a new connexion and set "root" as a login and "exercice2023"
  * Use your connexion and change the username and password in src/main/resources/application.properties
* Dezip and import the BDD chinook.sql in your BDD server from the file : bdd/chinook.zip
  * Import the BDD.
  * Or execute the sql script.

# Project Dockerization :
* If necessary and if need to execute the project in a container you car personalize the Dockerfile in the main directory of the project.
* And adapt the user an password informations in docker-compose.yml

# Project Execution
* After starting project you can use postman to test with the following link localhost:8080/ws after setting method on GET

# Swagger Documentation :
* 