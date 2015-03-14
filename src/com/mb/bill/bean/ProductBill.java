/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.bill.bean;

import com.mb.product.bean.Product;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author ldanh
 */
public class ProductBill {
    private Product product;
    private Map<String,Integer> mapQuantity;

    public ProductBill() {
        mapQuantity = new LinkedHashMap<String,Integer>();
    }
    
    public ProductBill(Product product, Map<String, Integer> mapQuantity) {
        this.product = product;
        this.mapQuantity = mapQuantity;
    }
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Map<String, Integer> getMapQuantity() {
        return mapQuantity;
    }

    public void setMapQuantity(Map<String, Integer> mapQuantity) {
        this.mapQuantity = mapQuantity;
    }
    
    public int getTotalQuantity() {
        int total = 0;
        for (String size : mapQuantity.keySet()) {
            total = total + mapQuantity.get(size);
        }
        return total;
    }
    
    public String getQuantityString() {
        String quantity = "";
        for (String size : mapQuantity.keySet()) {
            if (!quantity.isEmpty()) 
                quantity += " - ";
            quantity += size + "(" + mapQuantity.get(size) + ")";
        }
        return quantity;
    }
}
