/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karandeep.el_seguro.dao;

import com.karandeep.el_seguro.dto.Receipt;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 91701
 */
public class Receiptdao {
    
    private String errorMessage;
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public boolean insertReceipt(Receipt receipt){
        String query = "insert into receipt(Policy_No,Receipt_No,Deposit_Date,Amount,Due_Date) values(?,?,?,?,?)";
        try{
            PreparedStatement stmt;
            stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, receipt.getPolicyNo());
            stmt.setLong(2, receipt.getReceiptNo());
            stmt.setDate(3, receipt.getDepositDate());
            stmt.setInt(4, receipt.getAmount());
            stmt.setDate(5,receipt.getDueDate());
            boolean res = stmt.executeUpdate()>0;
            stmt.close();
            return res;
            
        }catch(Exception ex){
            errorMessage=ex.getMessage();
            ex.printStackTrace();
            return false;
        }
        
    }
    
    public boolean updateReceipt(Receipt receipt){
        String query = "update reciept set Policy_No=?,Deposit_Date=?,Amount=?,Due_Date=? where Reciept_No=?";
        try{
            PreparedStatement stmt;
            stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, receipt.getPolicyNo());
            stmt.setLong(2, receipt.getReceiptNo());
            stmt.setDate(3, receipt.getDepositDate());
            stmt.setInt(5, receipt.getAmount());
            stmt.setDate(4, receipt.getDueDate());
            boolean res = stmt.executeUpdate()>0;
            stmt.close();
            return res;
            
        }catch(Exception ex){
            errorMessage=ex.getMessage();
            ex.printStackTrace();
            return false;
        }
        
    }
    
    public boolean updateDueDate(long policyNo, Date date){
        String query = "update reciept set Due_Date=? where Policy_No=?";
        try{
            PreparedStatement stmt;
            stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setDate(1, date);
            stmt.setLong(2, policyNo);
            boolean res = stmt.executeUpdate()>0;
            stmt.close();
            return res;
            
        }catch(Exception ex){
            errorMessage=ex.getMessage();
            ex.printStackTrace();
            return false;
        }
        
    }
    
    public boolean deleteReceipt(long policyNo){
        String query = "delete from reciept where Policy_No=?";
        try{
            PreparedStatement stmt;
            stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setLong(1, policyNo);
            boolean res = stmt.executeUpdate()>0;
            stmt.close();
            return res;
            
        }catch(Exception ex){
            errorMessage=ex.getMessage();
            ex.printStackTrace();
            return false;
        }
        
    }
    
    public Receipt getReceipt(long Receipt_No){
        String query = "select Policy_No,Reciept_No,Deposit_Date,Amount,Due_Date from reciept where Reciept_No=?";
        try
        {
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setLong(1, Receipt_No);
            ResultSet rSet = stmt.executeQuery();
            if(rSet.next()){
                Receipt receipt = new Receipt();
                receipt.setPolicyNo(rSet.getInt("Policy_No"));
                receipt.setReceiptNo(rSet.getLong("Receipt_No"));
                receipt.setDepositDate(rSet.getDate("Deposit_Date"));
                receipt.setAmount(rSet.getInt("Amount"));
                receipt.setDueDate(rSet.getDate("Due_Date"));
                return receipt;
            }
        }catch(Exception ex){
            errorMessage=ex.getMessage();
            ex.printStackTrace();
            return null;
        }
        return null;
    }

    public Date getLastPaidDueDate(long policyNo) {
        String query = "select Due_Date from reciept where Policy_No=? order by Due_Date desc limit 1";
        try
        {
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setLong(1, policyNo);
            ResultSet rSet = stmt.executeQuery();
            if(rSet.next()){
               return rSet.getDate("Due_Date");
            }
        }catch(Exception ex){
            errorMessage=ex.getMessage();
            ex.printStackTrace();
            return null;
        }
        return null;
    }
}
