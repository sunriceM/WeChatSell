package com.sunrise.service;

import com.sunrise.entity.ProductCategory;

import java.util.List;

/**
 * class
 *
 * @author Andy
 * @date 2020/8/21
 */

public interface CategoryService {

    ProductCategory findById(Integer id);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes);

    ProductCategory saveCategory(ProductCategory productCategory);

}
