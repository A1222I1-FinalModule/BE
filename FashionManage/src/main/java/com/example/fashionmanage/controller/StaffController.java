package com.example.fashionmanage.controller;

import com.example.fashionmanage.entity.*;
import com.example.fashionmanage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private BIllService bIllService;
    @Autowired
    private BillDetailService billDetailService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DiscountService discountService;

    @PostMapping("/customer/{searchStr}")
    public ResponseEntity<List<Customer>> findAllByNameOrPhoneContainingOrId(@PathVariable(name = "searchStr") String searchStr) {
        List<Customer> searchList = customerService.findAllByNameOrPhoneOrContainingId(searchStr);
        if (searchList == null || searchList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(searchList, HttpStatus.OK);
    }

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
            String billCode = "";
            while (true) {
                billCode = "HD" + generateRandomCode9Nums();
                if (!bIllService.findById(billCode).isPresent()) {
                    break;
                }
            }
            //add bill
            Bill newBill = new Bill();
            newBill.setId(billCode);
            newBill.setReleaseDate(Instant.now());
            newBill.setCustomer(customerOptional.get());
            newBill.setEmployee(employeeOptional.get());
            newBill.setDiscount(discountOptional.get());

            //thieu total vi khong biet add giam gia

            bIllService.save(newBill);
            //add bill detail
            for (ProductBill productBill : billDto.getProductBills()) {
                String productId = productBill.getProductId();
                int requestQuantity = productBill.getQuantity();
                Product product = productService.findById(productId).orElseThrow();

                BillDetail billDetail = new BillDetail();
                String id = "";
                while (true) {
                    id = generateRandomCode9Nums();
                    if (!bIllService.findById(billCode).isPresent()) {
                        break;
                    }
                }
                billDetail.setId(id);
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

    public static String generateRandomCode9Nums() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            int num = (int) (Math.random() * 10);
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }
}