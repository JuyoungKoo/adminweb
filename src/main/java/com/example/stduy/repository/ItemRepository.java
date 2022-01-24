package com.example.stduy.repository;

import com.example.stduy.model.entity.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository <Item,Long>{

    
}
