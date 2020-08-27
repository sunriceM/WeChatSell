package com.sunrise.service.impl;

import com.sunrise.entity.ProductInfo;
import com.sunrise.enums.ProductStatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    ProductServiceImpl productService;

    @Test
    public void findById() {
        ProductInfo productInfo = productService.findById("2345");
        assertEquals("2345", productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfos = productService.findUpAll();
        assertNotEquals(0, productInfos.size());
    }

    @Test
    public void findAllWithPageable() {
        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<ProductInfo> productInfos = productService.findAllWithPageable(pageRequest);
        System.out.println(productInfos.getTotalElements());

    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("2345");
        productInfo.setProductName("aaa");
        productInfo.setProductPrice(new BigDecimal(12.3));
        productInfo.setProductStock(30);
        productInfo.setProductDescription("asdasd");
        productInfo.setProductIcon("http://dffff.jpg");
        productInfo.setProductStatus(ProductStatusEnum.Down.getCode());
        productInfo.setCategoryType(2);
        ProductInfo result = productService.save(productInfo);

        assertNotNull(result);

    }
}