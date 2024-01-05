package com.example.fashionmanage.controller;

import com.example.fashionmanage.entity.Discount;
import com.example.fashionmanage.service.discount.inter.DiscountServiceInter;
import com.example.fashionmanage.service.discount.service.DiscountService;
import com.example.fashionmanage.validation.DiscountDto;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/admin")
public class RestControllerDiscount {
    @Autowired
    private DiscountServiceInter discountServiceInter;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * The function help display all data of list discount
     * @author QuanNV
     * @return list data of discount
     */
    @GetMapping("/list")
    public ResponseEntity<?> findAllDiscount(){

            System.out.println(1);
            List<Discount> discounts=discountServiceInter.findAllDiscount();
            System.out.println(2);
            if(discounts.isEmpty()){
                System.out.println(3);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }


            return  ResponseEntity.ok(discounts);

    }

    /**
     * The function help display all data of discount find by id
     * @param id is code of discount
     * @return data of discount find by id
     * @author QuanNV
     */
    @GetMapping("/findById")
    public ResponseEntity<?>findByIdDiscount(@RequestParam("id") String id){
        Discount discount= discountServiceInter.findByIdDiscount(id);
        if(discount==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(discount,HttpStatus.OK);
    }

    /**
     * The function help delete all data of discount find by id
     * @param id is code of discount
     * @return
     * @author QuanNV
     */
    @DeleteMapping("/deleteById")
    public ResponseEntity<?>deleteByIdDiscount(@RequestParam("id")String id){
        Discount discount= discountServiceInter.findByIdDiscount(id);
        if(discount==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            discountServiceInter.deleteByIdDiscount(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * The function help create new discount
     * @param discountDto
     * @return
     * author QuanNV
     */
    @PostMapping("/create")
    public ResponseEntity<?>saveDiscount(@Valid @RequestBody DiscountDto discountDto){
        try {
            discountServiceInter.saveDiscount(discountDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * the function help update discount by id
     * @param id
     * @param discount1
     * @return
     * author QuanNV
     */

}
