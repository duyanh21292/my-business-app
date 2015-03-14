/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.product.bean;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DUYANH
 */
public class ProductJoinDetail {
    private Product product;
    private Map<String,Integer> productDetail; 

    public ProductJoinDetail(Product product) {
        this.product = product;
        this.productDetail = new HashMap<String,Integer>();
    }

    public Map<String, Integer> getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(Map<String, Integer> productDetail) {
        this.productDetail = productDetail;
    }
    
}
