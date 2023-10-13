package com.edureka.service;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * This class is used to call Notification REST service
 */
@Service
public class NotificationService {

    @Value("${edureka.assignment.notification_service_url")
    String notificationServiceRootUrl;
    String notificationServiceRegisterUrl=notificationServiceRootUrl+"/api/v1/Notifications/register";

    @Autowired
    RestTemplate restTemplate;

    public void callNotificationServiceToCreateNotification(Long customerId,String notificationType,String message){

        try{
            JsonObject obj= new JsonObject();
            obj.addProperty("message",message);
            obj.addProperty("customerId",customerId);
            obj.addProperty("type",notificationType);
            HttpEntity<JsonObject> request= new HttpEntity<>(obj);


            restTemplate.exchange(notificationServiceRegisterUrl,
                    HttpMethod.POST,request, List.class);
            System.err.println("Successfully Invoked Notification service using REST template with url "+notificationServiceRegisterUrl);
        }catch (Exception e){
            System.err.println("Exception occurred while invoking REST API "+notificationServiceRegisterUrl+"\n due to "+e);
        }
    }
}
