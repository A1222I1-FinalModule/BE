package com.example.fashionmanage.controller;


import com.example.fashionmanage.entity.Notification;
import com.example.fashionmanage.service.NotificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;


    /**
     * this is method getAllBySale(),It will display all notifications belonging to the Saler role, if the list is empty,
     * then no will return HTTP status code 204 (No_Content) otherwise no will display a list with status code 200 (Ok)
     * @Param : N/A
     * @Author : TamHP
     * @return : display list notification
     */
    @GetMapping("/saler/listnotification")
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


    /**
     *  this is method getAllByWareHouse(),It will display all notifications belonging to the Saler role, if the list is empty,
     *  then no will return HTTP status code 204 (No_Content) otherwise no will display a list with status code 200 (Ok)
     * @Param : N/A
     * @author : TamHP
     * @return : display list notification
     */
    @GetMapping("/warehouse/listnotification")
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

    /**
     * this is method findById , it will return data with the corresponding id,
     * if the id does not exist it will return http status code Not Found (404),
     * and if it does it will return with data with http status code OK (200),
     * if the exception error will fall on http status code 500 (INTERNAL_SERVEL_ERROR)
     * @param id
     * @author : TamHP
     * @return : get data with id selected
     */

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


    /**
     * this is method findById , it will return data with the corresponding id,
     * if the id does not exist it will return http status code Not Found (404),
     * and if it does it will return with data with http status code No_CONTENT(204),
     * if the exception error will fall on http status code 500 (INTERNAL_SERVEL_ERROR)
     * @param id
     * @return : data with id selected will delete
     */

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


    /**
     * this is method sendNotification, This method is used to add data to the database,
     * if the data is not added,
     * the 400 error (Bad Request) and the data added successfully will be 201 (Created)
     * @param notification
     * @param bindingResult
     * @return : insert database successfullly;
     */
    @PostMapping("/admin/savenotification")
    public  ResponseEntity<Notification> sendNotification(@RequestBody Notification notification, BindingResult bindingResult){
        Date date = new Date();
        notification.setStartDate(date);
        notification.setStatus(false);
        if(bindingResult.hasErrors()){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        notificationService.Save(notification);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }


    /**
     * this is method getNotReadSaler(),
     * This method is used to display the list of unread messages of the Saler, if the data is empty
     * it will send with an HTTP code 204 (NO_CONTENT) and the data will send back the list of unread messages with HTTP code 200 (OK)
     * @Param : N/A
     * @author : TamHP
     * @return : list notification not read
     */
    @GetMapping("/saler/notread")
    public  ResponseEntity<List<Notification>> getNotReadSaler(){
        List<Notification> notifications = notificationService.findAll();
        List<Notification> notificationList = new ArrayList<>();

        if(notifications.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Notification notification: notifications) {
            if((notification.getTarget() == 1 || notification.getTarget() == 3) && !notification.getStatus()){
                notificationList.add(notification);
            }
        }
        return  new ResponseEntity<>(notificationList, HttpStatus.OK);
    }

    /**
     * this is method getNotReadWareHouse(),
     * This method is used to display the list of unread messages of the Saler, if the data is empty
     * it will send with an HTTP code 204 (NO_CONTENT) and the data will send back the list of unread messages with HTTP code 200 (OK)
     * @Param : N/A
     * @author : TamHP
     * @return : list notification not read
     */
    @GetMapping("/warehouse/notread")
    public  ResponseEntity<List<Notification>> getNotReadWareHouse(){
        List<Notification> notifications = notificationService.findAll();
        List<Notification> notificationList = new ArrayList<>();

        if(notifications.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Notification notification: notifications) {
            if((notification.getTarget() == 2 || notification.getTarget() == 3) && !notification.getStatus()){
                notificationList.add(notification);
            }
        }
        return  new ResponseEntity<>(notificationList, HttpStatus.OK);
    }

}
