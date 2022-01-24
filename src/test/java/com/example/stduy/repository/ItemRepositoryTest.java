package com.example.stduy.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import com.example.stduy.StduyApplicationTests;
import com.example.stduy.model.entity.Item;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ItemRepositoryTest extends StduyApplicationTests{

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        
        Item item = new Item();

        item.setStatus("UNRESISTERED");
        item.setName("삼성노트북");
        item.setTitle("삼성 노트북 A100");
        item.setContent("2019년형 노트북 입니다");
        item.setPrice(900000);
        item.setBrandName("삼성");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("Partner01");
       // item.setPartnerId(1L);

        Item newItem = itemRepository.save(item);
        Assert.assertNotNull(newItem);



    }

    @Test
    public void read(){
        Long id = 1L;

       Optional<Item> item = itemRepository.findById(id);
       Assert.assertTrue(item.isPresent());
        
    }


    
}
