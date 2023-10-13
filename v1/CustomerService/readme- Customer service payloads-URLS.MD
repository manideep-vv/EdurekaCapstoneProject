Note- about this application
================
1) Before starting this application start Notification Service which is another project
2) Because once we call http://localhost:8080/api/v1/customers/register it will internally call Notification service using 
 http://localhost:8081/api/v1/Notifications/register

H2 Url's
-----------------
http://localhost:8080/h2-console/login.jsp

jdbc url:jdbc:h2:mem:testdb
user name: sa
password: 1234
 
Queries
==============
select * from customer

swagger ui urls
===============
you can get swagger ui url from console also when app ran
http://localhost:8080/swagger-ui.html
 

Customer service urls and payloads
=================================
1) GET request to fetch all customer 
http://localhost:8080/api/v1/customers/getAllCustomers

2) POST - to create an customer

http://localhost:8080/api/v1/customers/register
{
    "name": "sai santhoshi",
    "email": "saisylu1@gmail.com",
    "password": "MANItcs@123"
}
