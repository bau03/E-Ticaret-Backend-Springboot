package com.yalcin.repository;

import com.yalcin.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdressRepository extends JpaRepository<Adress,Integer> {
    List<Adress> findAllByUser_Id(Integer userId);
    Adress findAllById(Integer id);
}
