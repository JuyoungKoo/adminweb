package com.example.stduy.repository;



import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.stduy.StduyApplicationTests;
import com.example.stduy.model.entity.OrderDetail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class OrderDetailRepositoryTest extends StduyApplicationTests{

   @Autowired
   private OrderDetailRepository orderDetailRepository;


   @Test
   public void create(){


      OrderDetail orderDetail = new OrderDetail();

      orderDetail.setStatus("WAITING");
      orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
      orderDetail.setQuantity(1);
      orderDetail.setTotalPrice(BigDecimal.valueOf(900000));
      //orderDetail.setOrderGroupId(1L);
      //orderDetail.setItemId(1L);
      orderDetail.setCreatedAt(LocalDateTime.now());
      orderDetail.setCreatedBy("AdminServer");

      OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
      Assert.assertNotNull(newOrderDetail);

    

   

   }


    
}
