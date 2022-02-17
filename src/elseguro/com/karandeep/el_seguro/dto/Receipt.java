/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karandeep.el_seguro.dto;

import java.sql.Date;

/**
 *
 * @author 91701
 */
public class Receipt {

    public int policyNo;
    public long receiptNo;
    public Date depositDate;
    public int amount;
    public Date dueDate;
    
    public int getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(int policyNo) {
        this.policyNo = policyNo;
    }

    public long getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(long receiptNo) {
        this.receiptNo = receiptNo;
    }

    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }
    
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
