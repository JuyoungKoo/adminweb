package com.example.stduy.repository;

import com.example.stduy.model.entity.AdminUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long>{
    
}
