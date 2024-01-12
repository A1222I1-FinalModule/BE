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
public interface DiscountRepository extends JpaRepository<Discount, String> {

    /**
     * The function help display all data of list discount
     *
     * @return list data of discount
     * @author QuanNV
     */
    @Query(value = "select discount_code , name , reward_point,`condition`,begin_date,end_date,customer_type_id " +
            "from discount ", nativeQuery = true)
    List<Discount> finAllDiscount();

    /**
     * The function help display all data of discount find by id
     *
     * @param id is code of discount
     * @return data of discount find by id
     * @author QuanNV
     */
    @Query(value = "select discount_code , name , reward_point,`condition`,begin_date,end_date,customer_type_id from discount  where discount_code=:id",nativeQuery = true)
    Discount findByIdDiscount(String id);

    /**
     * The function help delete all data of discount find by id
     *
     * @param id is code of discount
     * @return
     * @author QuanNV
     */
    @Modifying
    @Transactional
    @Query(value = "delete from discount  where discount_code=:id", nativeQuery = true)
    void deleteByIdDiscount(@Param("id") String id);

    /**
     * The function help create new discount
     * @param discount
     * author QuanNV
     */
    @Modifying
    @Query(value = "INSERT INTO fashionShop.discount (discount_code, name, reward_point, `condition`, begin_date,end_date,customer_type_id) VALUES (:#{#discount.discountCode}, :#{#discount.name}, :#{#discount.rewardPoint}, :#{#discount.condition}, :#{#discount.beginDate},:#{#discount.endDate},:#{#discount.customerType.id})",
            nativeQuery = true)
    @Transactional
    void createDiscount(@Param("discount") Discount discount);


    /**
     *the function help update discount by id
     * @param id
     * @param discount
     * @return
     */
    @Modifying
    @Query(value = "update discount set name=:#{#discount.name},reward_point=:#{#discount.rewardPoint},`condition`=:#{#discount.condition},begin_date=:#{#discount.beginDate},end_date=:#{#discount.endDate},customer_type_id=:#{#discount.customerType.id} " +
            " where discount_code=:id", nativeQuery = true)
    int updateDiscount(@Param("id") String id,@Param("discount") Discount discount);

    /**
     * The function help display all data of discount find by name
     *
     * @param name of discount
     * @return data of discount find by id
     * @author QuanNV
     */
    @Query(value = "select * from discount  where name=:name", nativeQuery = true)
    Discount findByNameDiscount(String name);

    /**
     * The function help allows to know if the id already exists
     * @param discountCode
     * @author QuanNV
     */
    @Query(value = "SELECT COUNT(*) FROM discount WHERE discount_code = :discountCode", nativeQuery = true)
    Long countByDiscountCode(@Param("discountCode") String discountCode);

}
