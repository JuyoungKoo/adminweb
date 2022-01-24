package com.example.stduy.repository;


import com.example.stduy.StduyApplicationTests;
import com.example.stduy.model.entity.AdminUser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdminUserRepositoryTest extends StduyApplicationTests{

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    public void create(){

        AdminUser adminuser = new AdminUser();
        adminuser.setAccount("AdminUser01");
        adminuser.setPassword("AdminUser01");
        adminuser.setStatus("REGISTERD");
        adminuser.setRole("PARTNER");
        /*adminuser.setCreatedAt(LocalDateTime.now());
        adminuser.setCreatedBy("AdminServer");*/


        AdminUser newAdminUser = adminUserRepository.save(adminuser);
        Assert.assertNotNull(newAdminUser);

        newAdminUser.setAccount("CHANGE");
        adminUserRepository.save(newAdminUser);
        

    }


    
}
