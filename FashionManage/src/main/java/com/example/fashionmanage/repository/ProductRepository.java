package com.example.fashionmanage.repository;
import com.example.fashionmanage.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,String> {

    /**
     * The function help display all data of list product
     * @author TuyenDV
     * @return list data of product
     */
    @Query(value = " select * from product ",nativeQuery = true)
    List<Product> findListInfoProduct();


    /**
     * The function help create new product
     * @param product
     * author TuyenDV
     */

    @Modifying
    @Query(value = "INSERT INTO product(product_code,name,quantity,image,price,product_category_id,size_id) VALUES" +
            " (:#{#product.productCode}, :#{#product.name},:#{#product.quantity}, :#{#product.image}, :#{#product.price}, :#{#product.productCategory.id},:#{#product.size.id})", nativeQuery = true)
    @Transactional
    void createInfoProduct(@Param("product") Product product);

    /**
     * The function help find name product
     * @param name
     * author TuyenDV
     */

    @Query(value = "select * from product where name LIKE %:name%", nativeQuery = true)
    List<Product> findByNameProduct(String name);

}


