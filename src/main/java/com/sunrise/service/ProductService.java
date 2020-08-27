package com.sunrise.service;

import com.sunrise.dto.CartDTO;
import com.sunrise.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * interface
 *
 * @author Andy
 * @date 2020/8/22
 */

public interface ProductService {

    ProductInfo findById(String productId);

    /**
     * 查询所有在架商品列表
     *     面向买家
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 分页查询所有商品
     *     面向卖家
     * @param pageable 分页
     * @return
     */
    Page<ProductInfo> findAllWithPageable(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /**
     * 加库存
     * @param cartDTOList
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 减库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);


}
