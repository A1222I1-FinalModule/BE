package com.example.fashionmanage.controller;

import com.example.fashionmanage.dto.BillDto;
import com.example.fashionmanage.dto.ProductBill;
import com.example.fashionmanage.entity.*;
import com.example.fashionmanage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private BillService bIllService;
    @Autowired
    private BillDetailService billDetailService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DiscountService discountService;

    /**
     * The function help search customer based on a string
     *
     * @param searchStr is search string
     * @return list data of customer
     * @author BaoDV
     */
    @PostMapping("/customer/{searchStr}")
    public ResponseEntity<List<Customer>> findAllByNameOrPhoneContainingOrId(@PathVariable(name = "searchStr") String searchStr) {
        List<Customer> searchList = customerService.findAllByNameOrPhoneOrContainingId(searchStr);
        if (searchList == null || searchList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(searchList, HttpStatus.OK);
    }

    /**
     * The function help add bill
     *
     * @param billDto
     * @author BaoDV
     */
    @PostMapping("/bill/add")
    public ResponseEntity<?> addBill(@RequestBody BillDto billDto) {
        Optional<Customer> customerOptional = customerService.findById(billDto.getCustomerCode());
        if (customerOptional.isPresent()) {
            //check is product available
            for (ProductBill productBill : billDto.getProductBills()) {
                String productId = productBill.getProductId();
                int requestQuantity = productBill.getQuantity();

                Optional<Product> productOptional = productService.findById(productId);
                if (productOptional.isPresent()) {
                    Product product = productOptional.get();
                    int availableQuantity = product.getQuantity();
                    if (availableQuantity < requestQuantity) {
                        return new ResponseEntity<>("Insufficient stock for product with ID: " + productId, HttpStatus.BAD_REQUEST);
                    }
                } else {
                    return new ResponseEntity<>("Product not found with ID: " + productId, HttpStatus.NOT_FOUND);
                }
            }
            //check is employee available
            Optional<Employee> employeeOptional = employeeService.findById(billDto.getEmployeeCode());
            if (!employeeOptional.isPresent()) {
                return new ResponseEntity<>("Employee not found with ID: " + employeeOptional.get().getId(), HttpStatus.NOT_FOUND);
            }
            //check is discount available
            Optional<Discount> discountOptional = discountService.findById(billDto.getDiscountCode());
            if (!discountOptional.isPresent()) {
                return new ResponseEntity<>("Discount not found with ID: " + discountOptional.get().getDiscountCode(), HttpStatus.NOT_FOUND);
            }
            //auto generate bill code
            String billCode = billDto.getBillCode();
            while (true) {
                if (!bIllService.findById(billCode).isPresent()) {
                    break;
                }
                billCode = "HD" + generateRandomCode9Nums();
            }
            //add bill
            Bill newBill = new Bill();
            newBill.setId(billCode);
            newBill.setReleaseDate(Instant.now());
            newBill.setCustomer(customerOptional.get());
            newBill.setEmployee(employeeOptional.get());
            newBill.setDiscount(discountOptional.get());
            newBill.setTotal(billDto.getTotal());

            bIllService.save(newBill);
            //add bill detail
            for (ProductBill productBill : billDto.getProductBills()) {
                String productId = productBill.getProductId();
                int requestQuantity = productBill.getQuantity();
                Product product = productService.findById(productId).orElseThrow();

                BillDetail billDetail = new BillDetail();
                billDetail.setQuantity(requestQuantity);
                billDetail.setProduct(product);
                billDetail.setBill(newBill);
                billDetailService.save(billDetail);

                // Update quantity product
                product.setQuantity(product.getQuantity() - requestQuantity);
                productService.save(product);
            }
            //update customer point
            Customer customer = customerOptional.get();
            customer.setPoint(customer.getPoint() + discountOptional.get().getRewardPoint());
            customerService.save(customer);
            return new ResponseEntity<>("Payment Successfully ", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Customer not found with ID: " + billDto.getCustomerCode(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * The function help get bill code
     *
     * @return bill code
     * @author BaoDV
     */
    @GetMapping("/bill/code")
    public ResponseEntity<String> getBillCode() {
        return new ResponseEntity<>("HD" + generateRandomCode9Nums(), HttpStatus.OK);
    }

    /**
     * The function help get list discount for customer
     *
     * @param cusId
     * @param total
     * @return list discount
     * @author BaoDV
     */
    @GetMapping("/discount/search/{cusId}")
    public ResponseEntity<List<Discount>> findDiscount(@PathVariable String cusId, @RequestParam("total") Integer total) {
        Optional<Customer> customerOptional = customerService.findById(cusId);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Integer cusTypeId = customerOptional.get().getType().getId();
        List<Discount> discountList = new ArrayList<>();
        discountList = discountService.findDiscount(cusTypeId, total, new Date());
        if (discountList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(discountList, HttpStatus.OK);
    }

    /**
     * The function help get 9 random number
     *
     * @return a string have 9 number random
     * @author BaoDV
     */
    public static String generateRandomCode9Nums() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            int num = (int) (Math.random() * 10);
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }
}