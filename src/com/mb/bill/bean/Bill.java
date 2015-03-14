/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mb.bill.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ldanh
 */
@Entity
@Table (name = "bill")
public class Bill implements Serializable{
    private int billId;
    private Date billDate;
    private String billCustomerName;
    private String billCustomerAddress;
    private String billCustomerPhone;
    private Date billDeliveryDate;

    public Bill(int billId, Date billDate, String billCustomerName, String billCustomerAddress, String billCustomerPhone, Date billDeliveryDate) {
        this.billId = billId;
        this.billDate = billDate;
        this.billCustomerName = billCustomerName;
        this.billCustomerAddress = billCustomerAddress;
        this.billCustomerPhone = billCustomerPhone;
        this.billDeliveryDate = billDeliveryDate;
    }

    public Bill() {
        this.billDate = Calendar.getInstance().getTime();
        this.billCustomerName = "";
        this.billCustomerAddress = "";
        this.billCustomerPhone = "";
    }
    
    @Id
    @Column (name="bill_id")
    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }
    
    @Temporal (TemporalType.DATE)
    @Column (name="bill_date")
    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }
    
    @Column (name="bill_customer_name")
    public String getBillCustomerName() {
        return billCustomerName;
    }

    public void setBillCustomerName(String billCustomerName) {
        this.billCustomerName = billCustomerName;
    }

    @Column (name="bill_customer_address")
    public String getBillCustomerAddress() {
        return billCustomerAddress;
    }

    public void setBillCustomerAddress(String billCustomerAddress) {
        this.billCustomerAddress = billCustomerAddress;
    }

    @Column (name="bill_customer_phone")
    public String getBillCustomerPhone() {
        return billCustomerPhone;
    }

    public void setBillCustomerPhone(String billCustomerPhone) {
        this.billCustomerPhone = billCustomerPhone;
    }
    
    @Temporal (TemporalType.DATE)
    @Column (name="bill_delivery_date")
    public Date getBillDeliveryDate() {
        return billDeliveryDate;
    }

    public void setBillDeliveryDate(Date billDeliveryDate) {
        this.billDeliveryDate = billDeliveryDate;
    }
    
    
}
