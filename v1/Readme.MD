Question:- https://github.com/akash-coded/spring-framework/discussions/149
i have implemented project discussion number 149 as from the above link


Note:
======================
1)Read me file is available For each and every application ,  pls read it u will get all urls 	 and some information about that application

2)All the sample payloads are available in readme file named  in the same directory 


3) For each  application we have 1 seperate H2 data base
4) For each  application we have 1 seperate swagger, alternatively i have attached the
   postman collection for each and every application in that folder itself, you can use it 
   some of data is auto inserted on application startup
5) 


Procedure to start application one by one
====================================================
1) first start notification service because it is called by other services like Customer service
ex:-  Because once we call http://localhost:8080/api/v1/customers/register it will internally call Notification service using 
 http://localhost:8081/api/v1/Notifications/register
 Hence first start Notification service first

2) then start customer service 



Inter communication flows
===========================
CS- means customer service 
NS- means Notification service
RS- means Reservation service
HMS- Hotel Management service
Ps- payment service


1) when customer registration is success, CS will interact with NS  -done
2) when hotel registration is success, RS will interact with NS
3) When customer cancel reservation, HMS will call RS to cancel,  RS will call PS to raise refund
once refund is success, RS will call NS to send notification
4) to book a room, HMS will call RS to make reservation, 
RS will call PS once payment is success, RS will call NS,





