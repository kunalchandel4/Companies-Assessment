# Companies-Assessment
# DMart Stock Management System
The DMart Stock Management System is a backend solution developed to address the inefficiencies and lack of real-time tracking in the stock management processes of DMart, a leading retailer with stores across the country. The system provides a robust and efficient way to manage stock levels, track stock movements, and ensure real-time visibility into stock availability at various store locations.

# Overview
The current stock management system at DMart lacks efficiency, reliability, and real-time tracking. This project aims to develop an automated, scalable, and efficient backend system to manage stock levels accurately and provide real-time visibility into stock movements and availability. The system is developed using Java and the Spring Boot framework, with SQL for database management

# Technical Requirements
* Java: JDK 8 or higher
* Spring Boot: 2.5.4 or higher
* SQL database (e.g., MySQL, PostgreSQL)

# Features
* Add new stock items to the system.
* Update the quantity of existing stock items.
* Delete stock items from the system.
* Track the movement of stock items between different store locations.
* Provide real-time visibility into stock quantities at each store location.
* Ensure data consistency and integrity.
* Handle high volumes of transactions.
* Implement system security and access control.

# Getting Started
To get started with the DMart Stock Management System, follow these steps:

* Clone the repository: git clone https://github.com/kunalchandel4/Companies-Assessment.git
* Install the required dependencies mentioned in the Technical Requirements section.
* Configure the database connection in the application.properties file.
* Build the project using your preferred build tool (e.g., Maven, Gradle).
* Run the application using the generated executable JAR file.
* Access the endpoints through the provided API documentation or test them using a tool like Postman.

# API Endpoint Authorization

  | Endpoint | Required Role(s) |
  |:---------|:----------------|
  |POST /stock/customers|All Users|
  |GET /stock/customers|ADMIN|
  |DELETE /stock/delete/**|ADMIN|
  |PUT /stock/update/**|ADMIN|
  |POST /stock/add|ADMIN|
  |POST /stock/move/**|ADMIN|
  |GET /stock/customers/**|ADMIN, USER|
  |GET /stock/view/**|ADMIN, USER|

* API Endpoint(port) :- http://localhost:9000
  
# To test the API, you can use the following dummy data:
 [Dummy Data](https://github.com/kunalchandel4/DummyData)
