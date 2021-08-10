package com.yalcin.repository;

import com.yalcin.entity.TokenBlacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenBlacklistRepository extends JpaRepository<TokenBlacklist,String >{
    Boolean existsByToken(String token);
}
