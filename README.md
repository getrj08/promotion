# Promotion Engine
Project comprises of a simple promotion engine for the checkout process. 

## Pre-Requisite
java 1.8

# How to run and test the application
	1- Clone the project from the link:
	 https://github.com/getrj08/promotion.git
 
	2- Once downloaded use the following commands to run the application

                 gradlew.bat clean build


	To Run the application traverse to the location <project path>/build/libs and run using this command:

                 java -jar promotion-0.0.1-SNAPSHOT.jar
                 
 # Postman/ARC
POST - http://localhost:8080/promotion/calculate

Headers:
```Content-Type : application/json``` 


Request Body:
```
{
 "A": 1,
 "B": 1,
 "C": 1,
 "D": 1
}
```
