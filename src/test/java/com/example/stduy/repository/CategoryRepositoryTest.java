package com.example.stduy.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import com.example.stduy.StduyApplicationTests;
import com.example.stduy.model.entity.Category;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryRepositoryTest extends StduyApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create(){

        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);

        Assert.assertNotNull(newCategory);
        Assert.assertEquals(newCategory.getType(), type);
        Assert.assertEquals(newCategory.getTitle(), title);


    }

    @Test
    public void read(){

        String type = "COMPUTER";

        Optional<Category> optionalCategory = categoryRepository.findByType("COMPUTER");

        optionalCategory.ifPresent(c -> {

            Assert.assertEquals(c.getType(), type);
            System.out.println(c.getId());
            System.out.println(c.getType());
            System.out.println(c.getTitle());

        });




    }
    
}
