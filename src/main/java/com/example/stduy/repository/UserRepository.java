package com.example.stduy.repository;


import com.example.stduy.model.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {

    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);

    
}
