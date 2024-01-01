package com.example.fashionmanage.controller;


import com.example.fashionmanage.entity.Notification;
import com.example.fashionmanage.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;


    @GetMapping("/sale")
    public ResponseEntity<List<Notification>> getAllBySale(){
        List<Notification> notifications = notificationService.findAll();
        List<Notification> notificationList = new ArrayList<>();

        if(notifications.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Notification notification: notifications) {
            if(notification.getTarget() == 1 || notification.getTarget() == 3){
                   notificationList.add(notification);
            }
        }
        return  new ResponseEntity<>(notificationList, HttpStatus.OK);
    }

    @GetMapping("/warehouse")
    public ResponseEntity<List<Notification>> getAllByWareHouse(){
        List<Notification> notifications = notificationService.findAll();
        List<Notification> notificationList = new ArrayList<>();

        if(notifications.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Notification notification: notifications) {
            if(notification.getTarget() == 2 || notification.getTarget() == 3){
                notificationList.add(notification);
            }
        }
        return  new ResponseEntity<>(notificationList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> findById(@PathVariable("id") String id){
        try {
            Integer parseId = Integer.parseInt(id);

            if(parseId == null){
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else {
                Notification notification = notificationService.findById(parseId);
                return new ResponseEntity<>(notification,HttpStatus.OK);
            }

        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Notification> deleteById(@PathVariable("id") String id){
        try {
            Integer parseId= Integer.parseInt(id);
            if(parseId == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }else {
                notificationService.deleteById(parseId);
                return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
