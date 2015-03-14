/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.bill.bean;

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
@Table (name = "bill_detail")
public class BillDetail implements Serializable{
    private int billId;
    private String productId;
    private int sizeId;
    private int quantity;

    public BillDetail(int billId, String productId, int sizeId, int quantity) {
        this.billId = billId;
        this.productId = productId;
        this.sizeId = sizeId;
        this.quantity = quantity;
    }

    @Id
    @Column (name = "bill_id")
    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
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
    
    
}
