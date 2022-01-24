package com.example.stduy.repository;

import com.example.stduy.model.entity.OrderDetail;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long>{
    
}
