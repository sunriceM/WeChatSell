package com.sunrise.controller;

import com.sunrise.VO.ProductInfoVO;
import com.sunrise.VO.ProductVO;
import com.sunrise.VO.ResultVO;
import com.sunrise.entity.ProductCategory;
import com.sunrise.entity.ProductInfo;
import com.sunrise.service.CategoryService;
import com.sunrise.service.ProductService;
import com.sunrise.utils.ResultVoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 *
 * @author Andy
 * @date 2020/8/23
 */

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {

        // 1.查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        // 2.查询类目（一次性查询）
        //   获取商品类目

        // 传统 循环
        // List<Integer> categoryTypeList = new ArrayList<>();
        // for (ProductInfo productInfo : productInfoList) {
        //     categoryTypeList.add(productInfo.getCategoryType());
        // }

        // java8 lambda
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 3.数据拼装
        ArrayList<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory: productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            ArrayList<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo: productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVoUtil.success(productVOList);
    }
}
