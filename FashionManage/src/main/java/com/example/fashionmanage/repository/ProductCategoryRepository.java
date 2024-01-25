package com.example.fashionmanage.repository;

import com.example.fashionmanage.entity.Product;
import com.example.fashionmanage.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    /**
     * The function help display all data of list productCategory
     * @author TuyenDV
     * @return list data of productCateogry
     */
    @Query(value = " select * from product_category ",nativeQuery = true)
    List<ProductCategory> findListCategory();

}
