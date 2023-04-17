# Soap-Rest Backend APIs For Sakilla DataBase 

Welcome to the Sakila Database Backend APIs!

This project provides REST and SOAP APIs for accessing data in the Sakila Database. The Sakila Database is a sample database used by many developers to learn and practice working with databases. This project provides APIs for interacting with various tables in the Sakila Database such as Actor, Customer, Category, City, Film, Inventory, Language, Payment, Rental, Staff and Store.

****

## Technology Used
- JAX-WS
- JAX-RS (Jersey)
- JSON-B
- JAX-B
- Maven
- Lombok
- MapStruct
- Tomcat
- Jakarta persistance (Hibernate)
- MySql
- Postman

****

## Getting Started
To use this project. 
- you need to download the Sakila Database from this link:
```
    https://www.sqliz.com/sakila/installation/ 
```
for more details about it you can visit this link 
```
    https://downloads.mysql.com/docs/sakila-en.pdf
```
- clone the project 
```
https://github.com/MarowaAdel28/Soap-Rest-Sakila-Backend-APIs.git
```
- go to the project directory 
```
    cd Soap-Rest-Sakila-Backend-APIs
```
- Create db user and set the username and password values in the persistence.xml.
- Create db named sakila in your MySql Server.
- Run your tomcat apache server and then change the configuration of tomcat in pom.xml.
- Finally, deploy the application using the following maven command.

```
    mvn clean install tomcat7:deploy
```
After that, you can start using the APIs by sending HTTP requests to the endpoints specified below.

