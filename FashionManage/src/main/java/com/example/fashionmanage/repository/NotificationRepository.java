package com.example.fashionmanage.repository;


import com.example.fashionmanage.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Integer> {



    /**
     *  this method is findAll(), it is display all record in table notification
     * @author : TamHP
     * @Param : N/A
     * @Return : This method will display all the records in the Notifications table
     */
    @Query("from Notification n ")
    List<Notification> findAll();


    /**
     * this method is Save() , it is insert values in table notification
     * @param content
     * @param startDate
     * @param status
     * @param target
     * @author: TamHP
     * @Return : if this method success, data will insert in table notification , unless data isn't insert table and message error
     */
    @Query(value = "insert into notification (content,start_date,status,target) values (:content,:start_date,:status,:target)",nativeQuery = true)
    void Save(@Param("content")String content, @Param("start_date")Date startDate,@Param("status")Boolean status,@Param("target")Integer target);

    /**
     * this method is deletebyId, it is delete record in table with id selected,if id not exsist message not found
     * @param id
     * @author :TamHP
     * @Return : data table notification  with id deleted
     */
    @Query(value = "delete from Notification n where n.id = :id ",nativeQuery = true)
    void deletebyId(@Param("id")int id);


    /**
     * this method is findById, It will return data equivalent to the id that exists, otherwise it will show that no id was found
     * @param id
     * @author: TamHP
     * @return : data notification witd id selected
     */
    @Query(value = "select content,start_date from Notification n where n.id =: id",nativeQuery = true)
    Notification findById(@Param("id")int id);


}
