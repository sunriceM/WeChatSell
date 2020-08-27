package com.sunrise.service.impl;

import com.sunrise.dao.ProductCategoryRepository;
import com.sunrise.entity.ProductCategory;
import com.sunrise.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * class
 *
 * @author Andy
 * @date 2020/8/21
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;
//    @Autowired
//    public CategoryServiceImpl(ProductCategoryRepository repository) {
//        this.repository = repository;
//    }

    @Override
    public ProductCategory findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes) {
        return repository.findByCategoryTypeIn(categoryTypes);
    }

    @Override
    public ProductCategory saveCategory(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
