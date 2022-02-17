/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karandeep.el_seguro.dto;

import java.sql.Blob;
import java.sql.Date;

/**
 *
 * @author 91701
 */
public class Policy {

    
    private long policyNo;
    private String name;
    private Date policyStartDate;
    private int years;
    private int planNo;
    private int amount;
    private String mode;
    private int payment;
    private String employeeID;
    private String nominee;
    private Blob idProof;
    public long getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(long policyNo) {
        this.policyNo = policyNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPolicyStartDate() {
        return policyStartDate;
    }

    public void setPolicyStartDate(Date policyStartDate) {
        this.policyStartDate = policyStartDate;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getPlanNo() {
        return planNo;
    }

    public void setPlanNo(int planNo) {
        this.planNo = planNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public Blob getIdProof() {
        return idProof;
    }

    public void setIdProof(Blob idProof) {
        this.idProof = idProof;
    }
    
}
