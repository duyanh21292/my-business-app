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
 * @author DUYANH
 */
@Entity
@Table(name = "product_detail")
public class ProductDetail implements Serializable {
    
    private String productId;
    private int sizeId;
    private int quantity;

    public ProductDetail(String productId, int sizeId, int quantity) {
        this.productId = productId;
        this.sizeId = sizeId;
        this.quantity = quantity;
    }

    public ProductDetail() {
        this.quantity = 0;
    }
    
    @Id
    @Column (name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Id
    @Column (name = "size_id")
    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    @Column (name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return productId + " , " + sizeId + " , " + quantity;
    }
    
}
