package com.example.fashionmanage.controller;

import com.example.fashionmanage.entity.Discount;
import com.example.fashionmanage.service.DiscountService;
import com.example.fashionmanage.dto.DiscountDto;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin")
public class DiscountController {
    @Autowired
    private DiscountService discountService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * The function help display all data of list discount
     *
     * @return list data of discount
     * @author QuanNV
     */
    @GetMapping("/listDiscount")
    public ResponseEntity<List<Discount>> findAllDiscount() {
        List<Discount> discounts = discountService.findAllDiscount();
        if (discounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(discounts, HttpStatus.OK);
    }

    /**
     * The function help display all data of discount find by id
     *
     * @param id is code of discount
     * @return data of discount find by id
     * @author QuanNV
     */
    @GetMapping("/findByIdDiscount")
    public ResponseEntity<Discount> findByIdDiscount(@RequestParam("id") String id) {
        Discount discount = discountService.findByIdDiscount(id);
        if (discount == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(discount, HttpStatus.OK);
    }

    /**
     * The function help delete all data of discount find by id
     *
     * @param id is code of discount
     * @return
     * @author QuanNV
     */
    @GetMapping("/deleteByIdDiscount")
    public ResponseEntity<Discount> deleteByIdDiscount(@RequestParam("id") String id) {
        Discount discount = discountService.findByIdDiscount(id);
        if (discount == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        discountService.deleteByIdDiscount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * The function help create new discount
     *
     * @param discountDto
     * @return author QuanNV
     */
    @PostMapping("/createDiscount")
    public ResponseEntity<Void> saveDiscount(@Valid @RequestBody DiscountDto discountDto) {
        try {
            boolean check=discountService.checkIdDiscount(discountDto.getDiscountCode());
            if(check){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else{
            discountService.createDiscount(discountDto);
            return new ResponseEntity<>(HttpStatus.OK);}
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateDiscount/{id}")
    public ResponseEntity<Void>updateDiscount(@Valid @PathVariable("id") String id, @RequestBody DiscountDto discountDto){
        try {
            Discount discount= discountService.findByIdDiscount(id);
            if(discount==null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            discountService.updateDiscount(id,discountDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * The function help display all data of discount find by name
     *
     * @param name is code of discount
     * @return data of discount find by dicount
     * @author QuanNV
     */
    @GetMapping("/findByNameDiscount")
    public ResponseEntity<List<Discount>> findByNameDiscount(@RequestParam("name") String name) {
        List<Discount>discounts = discountService.findByNameDiscount(name);
        if (discounts == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(discounts, HttpStatus.OK);
    }

    /**
     * The function help display all data of list discountCode
     *
     * @return list data of discountCode
     * @author QuanNV
     */
    @GetMapping("/listDiscountCode")
    public ResponseEntity<List<String>> findAllDiscountCode() {
        List<String> discounts = discountService.listDiscountCode();
        if (discounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(discounts, HttpStatus.OK);
    }
}
