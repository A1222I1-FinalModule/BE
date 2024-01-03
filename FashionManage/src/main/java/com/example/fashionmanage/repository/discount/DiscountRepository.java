package com.example.fashionmanage.repository.discount;

import com.example.fashionmanage.entity.Discount;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Date;
import java.util.List;
@Repository
public interface DiscountRepository extends JpaRepository<Discount,String> {

    /**
     * The function help display all data of list discount
     * @author QuanNV
     * @return list data of discount
     */
    @Query(value = "select * from discount ",nativeQuery = true)
    List<Discount> finAllDiscount();

    /**
     * The function help display all data of discount find by id
     * @param id is code of discount
     * @return data of discount find by id
     * @author QuanNV
     */
    @Query(value = "select * from discount  where discount_code=:id",nativeQuery = true)
    Discount findByIdDiscount(String id);

    /**
     * The function help delete all data of discount find by id
     * @param id is code of discount
     * @return
     * @author QuanNV
     */
    @Modifying
    @Transactional
    @Query(value = "delete from discount  where discount_code=:id",nativeQuery = true)
    void deleteByIdDiscount(@Param("id")String id);

    /**
     * The function help create new discount
     * @param discountCode
     * @param name
     * @param rewardPoint
     * @param condition
     * @param beginDate
     * @param endDate
     * @param customerTypeId
     * author QuanNV
     */
    @Modifying
    @Query(value = "insert into discount(discount_code, name, reward_point, `condition`, begin_date, end_date, customer_type_id) " +
            "values (:discountCode, :name, :rewardPoint, :condition, :beginDate, :endDate, :customerTypeId)", nativeQuery = true)
    void saveDiscount(@Param("discountCode") String discountCode,
                      @Param("name") String name,
                      @Param("rewardPoint") Integer rewardPoint,
                      @Param("condition") Integer condition,
                      @Param("beginDate") Date beginDate,
                      @Param("endDate") Date endDate,
                      @Param("customerTypeId") Integer customerTypeId);

    /**
     * the function help update discount by id
     * @param id
     * @param discount1
     * @return
     * author QuanNV
     */
    @Modifying
    @Query(value = "update discount set name=:discount1.name,rewardPoint=:discount1.rewardPoint,condition=:discount1.condition,beginDate=:discount1.beginDate,endDate=:discount1.endDate,customerType=:discount1.customerType" +
            "where discountCode=:id",nativeQuery = true)
    Discount updateDiscount(String id, Discount discount1);
}
