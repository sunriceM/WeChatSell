package com.sunrise.dao;

import com.sunrise.entity.ProductCategory;
import com.sunrise.entity.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("2345");
        productInfo.setProductName("aaa");
        productInfo.setProductPrice(new BigDecimal(12.3));
        productInfo.setProductStock(30);
        productInfo.setProductDescription("asdasd");
        productInfo.setProductIcon("http://dffff.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        ProductInfo result = repository.save(productInfo);
        assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfos = repository.findByProductStatus(0);
        assertNotEquals(0, productInfos.size());
    }
}