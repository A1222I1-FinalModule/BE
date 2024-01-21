package com.example.fashionmanage.repository.discount;

import com.example.fashionmanage.entity.Discount;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, String> {

    /**
     * The function help display all data of list discount
     *
     * @return list data of discount
     * @author QuanNV
     */
    @Query(value = "select discount_code , name , reward_point,`condition`,sale,begin_date,end_date,is_Delete,customer_type_id " +
            "from discount ", nativeQuery = true)
    List<Discount> finAllDiscount();

    /**
     * The function help display all data of discount find by id
     *
     * @param id is code of discount
     * @return data of discount find by id
     * @author QuanNV
     */
    @Query(value = "select discount_code , name , reward_point,`condition`,sale,begin_date,end_date,is_Delete,customer_type_id from discount  where discount_code=:id",nativeQuery = true)
    Discount findByIdDiscount(String id);

    /**
     * The function help create new discount
     * @param discount
     * author QuanNV
     */
    @Modifying
    @Query(value = "INSERT INTO fashionShop.discount (discount_code, name, reward_point, `condition`, sale,begin_date,end_date,is_delete,customer_type_id) VALUES (:#{#discount.discountCode}, :#{#discount.name}, :#{#discount.rewardPoint}, :#{#discount.condition},:#{#discount.sale} ,:#{#discount.beginDate},:#{#discount.endDate},:#{#discount.isDelete},:#{#discount.customerType.id})",
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
    @Query(value = "update discount set name=:#{#discount.name},reward_point=:#{#discount.rewardPoint},`condition`=:#{#discount.condition},sale=:#{#discount.sale},begin_date=:#{#discount.beginDate},end_date=:#{#discount.endDate},customer_type_id=:#{#discount.customerType.id} " +
            " where discount_code=:id", nativeQuery = true)
    int updateDiscount(@Param("id") String id,@Param("discount") Discount discount);

    /**
     * The function help display all data of discount find by name
     *
     * @param name of discount
     * @return data of discount find by id
     * @author QuanNV
     */
    @Query(value = "select discount_code , name , reward_point,sale,`condition`,begin_date,end_date,is_delete,customer_type_id from discount  where name LIKE %:name%", nativeQuery = true)
    List<Discount> findByNameDiscount(String name);

    /**
     * The function help allows to know if the id already exists
     * @param discountCode
     * @author QuanNV
     */
    @Query(value = "SELECT COUNT(*) FROM discount WHERE discount_code = :discountCode", nativeQuery = true)
    Long countByDiscountCode(@Param("discountCode") String discountCode);

    /**
     * The function help display all data discountCode
     *
     * @return list data of discountCode
     * @author QuanNV
     */
    @Query(value = "select discount_code from discount ", nativeQuery = true)
    List<String> listDiscountCode();

    /**
     *The function help delete all data of discount find by id
     * @param id
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "update discount set is_delete=false  " +
            " where discount_code=:id", nativeQuery = true)
    int isDelete(@Param("id") String id);
}
