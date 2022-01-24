package com.example.stduy.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.stduy.StduyApplicationTests;
import com.example.stduy.model.entity.OrderGroup;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class OrderGroupRepositoryTest extends StduyApplicationTests{

    @Autowired

    private OrderGroupRepository orderGroupRepository;

    @Test
    public void create (){

        OrderGroup orderGroup = new OrderGroup();
        orderGroup.setStatus("COMPLETE");
        orderGroup.setOrderType("ALL");
        orderGroup.setRevAddress("서울시강남구");
        orderGroup.setRevName("홍길동");
        orderGroup.setPaymentType("CARD");
        orderGroup.setTotalPrice(BigDecimal.valueOf(900000));
        orderGroup.setTotalQuantity(1);
        orderGroup.setOrderAt(LocalDateTime.now().minusDays(2));
        orderGroup.setArrivalDate(LocalDateTime.now());
        orderGroup.setCreatedAt(LocalDateTime.now());
        orderGroup.setCreatedBy("AdminServer");
        //orderGroup.setUserId(1L);

        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
        Assert.assertNotNull(newOrderGroup);


        

    }

    
}
