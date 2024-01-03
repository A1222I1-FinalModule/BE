package com.example.fashionmanage.service;

import com.example.fashionmanage.entity.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationService {

    /**
     *  This is the save() method, which is created for reuse by subclasses,Its purpose is to add data
     * @param notification
     * @author :TamHP
     * @Return : if this method success, data will insert in table notification , unless data isn't insert table and message error
     */
    void Save(Notification notification);

    /**
     * this is the findAll(), which is created for reuse by subclasses, Its purpose is to display the notification list
     * @param :N/A
     * @author : TamHP
     * @Return : display list notification
     */

    List<Notification> findAll();

    /**
     * this is the deleteById, which is created for reuse by subclasses,Its purpose is to delete data with equivalent IDs
     * @param id
     * @author : TamHP
     * @Return : display data with id selected
     */

    void deleteById(Integer id);


    /**
     * this is findById, which is created for reuse by subclasses, Its purpose is to return the object with the corresponding ID
     * @param id
     * @author: TamHP
     * @return : display object with id selected
     */

    Notification findById(int id);
}
