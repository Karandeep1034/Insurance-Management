/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karandeep.el_seguro.dto;

/**
 *
 * @author 91701
 */
public class Plan {
       
    public String plan_Name;
    public int plan_No;
    public int minYrs ;
    public int maxYrs;
    public int minAge;
    public int maxAge;
    public int minAmount;
    public int minYearsToSurrender;
    public float lateFeePercent;
    public float maturityPercent;
    public float surrenderValueInterest;
    public float revivalCharges;
    public float comission;

    public String getPlan_Name() {
        return plan_Name;
    }

    public void setPlan_Name(String plan_Name) {
        this.plan_Name = plan_Name;
    }

    public int getPlan_No() {
        return plan_No;
    }

    public void setPlan_No(int plan_No) {
        this.plan_No = plan_No;
    }

    public int getMinYrs() {
        return minYrs;
    }

    public void setMinYrs(int minYrs) {
        this.minYrs = minYrs;
    }

    public int getMaxYrs() {
        return maxYrs;
    }

    public void setMaxYrs(int maxYrs) {
        this.maxYrs = maxYrs;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }

    public int getMinYearsToSurrender() {
        return minYearsToSurrender;
    }

    public void setMinYearsToSurrender(int minYearsToSurrender) {
        this.minYearsToSurrender = minYearsToSurrender;
    }

    public float getLateFeePercent() {
        return lateFeePercent;
    }

    public void setLateFeePercent(float lateFeePercent) {
        this.lateFeePercent = lateFeePercent;
    }

    public float getMaturityPercent() {
        return maturityPercent;
    }

    public void setMaturityPercent(float maturityPercent) {
        this.maturityPercent = maturityPercent;
    }

    public float getSurrenderValueInterest() {
        return surrenderValueInterest;
    }

    public void setSurrenderValueInterest(float surrenderValueInterest) {
        this.surrenderValueInterest = surrenderValueInterest;
    }

    public float getRevivalCharges() {
        return revivalCharges;
    }

    public void setRevivalCharges(float revivalCharges) {
        this.revivalCharges = revivalCharges;
    }

    public float getComission() {
        return comission;
    }

    public void setComission(float comission) {
        this.comission = comission;
    }
 
    
}
