package com.sunrise.dao;

import com.sunrise.entity.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        Optional<ProductCategory> productCategory = repository.findById(1);
        System.out.println(productCategory);
    }

    @Test
    @Transactional
    public void saveTest() {
        ProductCategory productCategory = this.repository.findById(1).orElse(null);
//        productCategory
//        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(1);
//        productCategory.setCategoryName("www");
        this.repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> types = Arrays.asList(1, 3);

        List<ProductCategory> result = repository.findByCategoryTypeIn(types);
        Assert.assertNotEquals(0, result.size());
    }
}