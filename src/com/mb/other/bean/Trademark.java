/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.other.bean;

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
@Table (name = "trademark")
public class Trademark implements Serializable {
    private int trademarkId;
    private String trademarkName;
    private String trademarkCountry;

    public Trademark() {
    }

    public Trademark(int trademarkId, String trademarkName, String trademarkCountry) {
        this.trademarkId = trademarkId;
        this.trademarkName = trademarkName;
        this.trademarkCountry = trademarkCountry;
    }
    
    @Id
    @Column (name = "trademark_id")
    public int getTrademarkId() {
        return trademarkId;
    }

    public void setTrademarkId(int trademarkId) {
        this.trademarkId = trademarkId;
    }

    @Column (name = "trademark_name")
    public String getTrademarkName() {
        return trademarkName;
    }

    public void setTrademarkName(String trademarkName) {
        this.trademarkName = trademarkName;
    }
    
    @Column (name = "trademark_country")
    public String getTrademarkCountry() {
        return trademarkCountry;
    }

    public void setTrademarkCountry(String trademarkCountry) {
        this.trademarkCountry = trademarkCountry;
    }

    @Override
    public String toString() {
        return trademarkName;
    }
}
