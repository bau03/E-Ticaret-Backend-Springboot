package com.yalcin.repository;

import com.yalcin.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {
    //List<Product> findAllById(Integer productId);
    Product findAllById(Integer productId);
    List<Product> findAllByUser_Id(Integer userId);
   // Product findAllByUserId(Integer userId);
    List<Product> findAllByEnabled(boolean enabled);
}
