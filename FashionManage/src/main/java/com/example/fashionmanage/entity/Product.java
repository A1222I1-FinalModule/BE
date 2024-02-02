
package com.example.fashionmanage.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "product", schema = "fashionShop")
public class Product {
    @Id
    @Size(max = 255)
    @Pattern(regexp = "^H[0-9]{3,20}$",message = "Không đúng định dạng")
    @Column(name = "product_code", nullable = false)
    private String productCode;

    @Size(min= 2 , max = 255,message = "Độ dài ký tự phải từ 2 đến 255")
    @NotBlank(message = "Thông tin không được để trống!")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity")
    @Min(value = 0,message = "Số lượng phải từ 0 trở lên")
    private Integer quantity;

    @NotBlank(message = "Thông tin không được để trống!")
    @Column(name= "image")
    private String image;

    @Min(value = 10000,message = "Gía phải từ 10.000 VND trở lên")
    @Column(name = "price")
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_category_id", nullable = false)
    private ProductCategory productCategory;


    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "size_id", nullable = false)
    private com.example.fashionmanage.entity.Size size;



//    @OneToMany(mappedBy = "productCode")
//    private Set<ProductSize> productSizes;


}

