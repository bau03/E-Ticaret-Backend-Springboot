package com.yalcin.controller;

import com.yalcin.dto.request.EditSellerForm;
import com.yalcin.dto.response.SuccessResponse;
import com.yalcin.service.ProductService;
import com.yalcin.service.SellerBeginService;
import com.yalcin.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@PreAuthorize("hasRole ('ROLE_ADMIN')")
@RequestMapping("ecommerce/admin")
public class AdminController {
    @Autowired
    SellerBeginService sellerBeginService;

    @Autowired
    ProductService productService;

    @Autowired
    UserServiceImpl userServiceImpl;


    @GetMapping("/detail")
    public ResponseEntity<?> getAllSeller() {
        return ResponseEntity.ok().body(sellerBeginService.getSeller());
    }

    @GetMapping("/product")
    public ResponseEntity<?> getAllProduct() {
        return ResponseEntity.ok().body(productService.getProduct());
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editUserRole(@Valid @RequestBody EditSellerForm editSellerForm) {
        sellerBeginService.editUserRole(editSellerForm);
        SuccessResponse response = new SuccessResponse(HttpStatus.OK,
                "Kullanıcı rolü güncellendi");
        return new ResponseEntity<>(response, new HttpHeaders(), response.getStatus());
    }

    @GetMapping("/productView/{productId}")
    public ResponseEntity<?> getContent(@PathVariable String productId){
        return ResponseEntity.ok().body(productService.getProduct(productId));
    }

    @PutMapping("/edit/product/{productId}")
    public ResponseEntity<?> editProduct(@PathVariable String productId){
        productService.productEdit(productId);
        SuccessResponse response = new SuccessResponse(HttpStatus.OK,
                "Ürün Yayınlandı");
        return new ResponseEntity<>(response, new HttpHeaders(), response.getStatus());
    }

}
