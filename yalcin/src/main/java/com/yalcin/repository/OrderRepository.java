package com.yalcin.repository;

import com.yalcin.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByUser_Id(Integer userId);
    Order findAllById(Integer orderId);
  @Query("select t from Order t join t.product u  where u.user.id = :userId")
  List<Order> findAllByUsername(Integer userId);
}
