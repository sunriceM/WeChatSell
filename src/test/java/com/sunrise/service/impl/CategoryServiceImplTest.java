package com.sunrise.service.impl;

import com.sunrise.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findById() {
        ProductCategory category = categoryService.findById(1);
        assertEquals(new Integer(1), category.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> categoryList = categoryService.findAll();
        assertNotEquals(0, categoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2, 3));
        assertNotEquals(0, categoryList.size());
    }

    @Test
    public void saveCategory() {
        ProductCategory productCategory= new ProductCategory("aaa", 10);
        ProductCategory result = categoryService.saveCategory(productCategory);
        assertNotNull(result);
    }
}