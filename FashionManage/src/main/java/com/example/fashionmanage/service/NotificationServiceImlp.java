package com.example.fashionmanage.service;


import com.example.fashionmanage.entity.Notification;
import com.example.fashionmanage.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImlp implements  NotificationService{

    @Autowired
    private NotificationRepository notificationRepository;


    /**
     * this is method overrride by interface NotificationService,It is used to add a notification object
     * @param notification
     * @author: TamHP
     * @Return : if success , object will insert not messager error
     */
    @Override
    @Transactional
    public void Save(Notification notification) {
        notificationRepository.Save(notification.getContent(),notification.getStartDate(),notification.getStatus(),notification.getTarget());
    }

    /**
     * this is method override by interface NotificationService,is is used display all record in table notification
     * @param :N/A
     * @author: TamHP
     * @return : if success , display all record in table notification messager error
     */
    @Override
    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }


    /**
     * this is method override by interface NotificationService, it is used delete record with id selected
     * @param id
     * @author :TamHP
     * @return : if it was id found record with id selected is deleted not  message error id not found
     */
    @Override
    public void deleteById(Integer id) {
        notificationRepository.deletebyId(id);
    }

    /**
     * this is method override by interface NotificationService, it is used display record with id selected
     * @param id
     * @author :TamHP
     * @return : if it was id found record with selected is display not message error id not found
     */

    @Override
    public Notification findById(int id) {
        return  notificationRepository.findById(id);
    }
}
