package com.example.fashionmanage.repository;

import com.example.fashionmanage.entity.ProductCategory;
import com.example.fashionmanage.entity.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSizeRepository extends JpaRepository<ProductSize,Integer> {
    /**
     * The function help display all data of list productSize
     * @author TuyenDV
     * @return list data of productSize
     */
    @Query(value = " select * from product_size ",nativeQuery = true)
    List<ProductSize> findListProductSize();


    /**
     * this method is findListProductSize(int id), It will return data equivalent to the id that exists, otherwise it will show that no id was found
     * @param id
     * @author: TuyenDV
     * @return : data notification witd id selected
     */
    @Query(value = "select * from product_size  where product_size.id = :id",nativeQuery = true)
    ProductSize findByIdListProductSize(@Param("id") Integer id);
}
