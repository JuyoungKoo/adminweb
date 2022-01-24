package com.example.stduy.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.stduy.StduyApplicationTests;

import com.example.stduy.model.entity.User;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest extends StduyApplicationTests {


    // Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){

        String account = "Test03";
        String password = "Test03";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-3333";
        LocalDateTime registeredAt = LocalDateTime.now();
        /*LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";*/

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        /*ser.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);*/

        User u = User.builder()
                    .account(account)
                    .password(password)
                    .status(status)
                    .email(email)
                    .build();
                        

        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);



    }

    @Test
    @Transactional
    public void read(){

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        

        user.getOrderGroupList().stream().forEach(orderGroup -> {

            System.out.println("----------------주문묶음------------------");
            System.out.println("수령인 : " + orderGroup.getRevName());
            System.out.println("수령지 : " + orderGroup.getRevAddress());
            System.out.println("총금액 : " + orderGroup.getTotalPrice());
            System.out.println("총수량 : " + orderGroup.getTotalQuantity());

            System.out.println("----------------주문상세------------------");

            orderGroup.getOrderDetailList().stream().forEach(orderDetail ->{
                System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
                System.out.println("파트너사 카테고리 : " + orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("주문의 상품 : " + orderDetail.getItem().getName());
                System.out.println("고객센터 번호 : " + orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("주문의 상태 : " + orderDetail.getStatus());
                System.out.println("도착예정일자 : " + orderDetail.getArrivalDate());        
        
            });


        });
    
        Assert.assertNotNull(user);
    
    }


    @Test
    public void update(){

        Optional<User> user = userRepository.findById(3L);

        user.ifPresent(selectUser ->{
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
      });

    }

  
    @Test
    @Transactional
    public void delete(){

        Optional<User> user = userRepository.findById(4L);

        Assert.assertTrue(user.isPresent()); // true

        user.ifPresent(selectuser->{
            userRepository.delete(selectuser);
        });

        Optional<User> deleteUser = userRepository.findById(4L);

        Assert.assertFalse(deleteUser.isPresent()); //false

       

    }

    
    
}
