package com.yalcin.repository;

import com.yalcin.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
public interface StoreRepository  extends JpaRepository<Store, Integer> {
    List<Store> findAllByUser_IdAndEnabled(Integer userId,boolean enabled);
    Set<Store> findAllByUserIdAndEnabled(Integer userId,boolean enabled);
    Store findAllById(Integer storeId);
}
