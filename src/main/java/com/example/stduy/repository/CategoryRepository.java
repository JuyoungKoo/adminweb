package com.example.stduy.repository;

import java.util.Optional;

import com.example.stduy.model.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

    Optional<Category> findByType(String type);
    
}
