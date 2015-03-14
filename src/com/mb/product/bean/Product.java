/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.product.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ldanh
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {
    private String productId;
    private int categoryId;
    private int trademarkId;
    private String productName;
    private String productColorDesc;
    private float productPrice;
    private float productPriceOrg;
    
    public Product(String productId, int categoryId, int trademarkId, String productName, String productColorDesc, float productPrice) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.trademarkId = trademarkId;
        this.productName = productName;
        this.productColorDesc = productColorDesc;
        this.productPrice = productPrice;
    }

    public Product() {
        this.productId = "";
        this.categoryId = 0;
        this.trademarkId = 0;
        this.productName = "Unknown";
        this.productColorDesc = "";
        this.productPrice = 0f;
    }
    
    @Id
    @Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Column(name = "category_id", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name = "trademark_id", nullable = false)
    public int getTrademarkId() {
        return trademarkId;
    }

    public void setTrademarkId(int trademarkId) {
        this.trademarkId = trademarkId;
    }

    @Column(name = "product_name", nullable = false)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(name = "product_color_desc", nullable = false)
    public String getProductColorDesc() {
        return productColorDesc;
    }

    public void setProductColorDesc(String productColorDesc) {
        this.productColorDesc = productColorDesc;
    }

    @Column(name = "product_price", nullable = false)
    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return productId + " , " + productName + " , " + productPrice;
    }

    @Column(name = "product_price_org")
    public float getProductPriceOrg() {
        return productPriceOrg;
    }

    public void setProductPriceOrg(float productPriceOrg) {
        this.productPriceOrg = productPriceOrg;
    }
}
