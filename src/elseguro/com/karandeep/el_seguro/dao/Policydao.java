/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karandeep.el_seguro.dao;

import com.karandeep.el_seguro.dto.Plan;
import com.karandeep.el_seguro.dto.Policy;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 91701
 */
public class Policydao {
    
    private String errorMessage;
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public boolean insertPolicy(Policy policy){
        String query = "insert into policy(Policy_no,Name,Policy_Start_Date,Years,Plan_No,Amount,Mode,Payment,Employee_Id,Nominee,Id_Proof) values(?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt;
            stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setLong(1, policy.getPolicyNo());
            stmt.setString(2, policy.getName());
            stmt.setDate(3, policy.getPolicyStartDate());
            stmt.setInt(4,policy.getYears());
            stmt.setInt(5,policy.getPlanNo());
            stmt.setInt(6, policy.getAmount());
            stmt.setString(7,policy.getMode());
            stmt.setInt(8, policy.getPayment());
            stmt.setString(9, policy.getEmployeeID());
            stmt.setString(10, policy.getNominee());
            stmt.setBlob(11, policy.getIdProof());
            boolean res = stmt.executeUpdate()>0;
            stmt.close();
            return res;
            
        }catch(Exception ex){
            errorMessage = ex.getMessage();
            ex.printStackTrace();
            return false;
        }
        
    }
    
    public boolean updatePolicy(Policy policy){
        String query = "update policy set Name=?,Policy_Start_Date=?,Years=?,Plan_No=?,Amount=?,Mode=?,Payment=?,Employee_Id=?,Nominee=?,Id_Proof=? where Policy_no=? ";
        try{
            PreparedStatement stmt;
            stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setLong(11, policy.getPolicyNo());
            stmt.setString(1, policy.getName());
            stmt.setDate(2, policy.getPolicyStartDate());
            stmt.setInt(3,policy.getYears());
            stmt.setInt(4,policy.getPlanNo());
            stmt.setInt(5, policy.getAmount());
            stmt.setString(6,policy.getMode());
            stmt.setInt(7, policy.getPayment());
            stmt.setString(8, policy.getEmployeeID());
            stmt.setString(9, policy.getNominee());
            stmt.setBlob(10, policy.getIdProof());
            boolean res = stmt.executeUpdate()>0;
            stmt.close();
            return res;
            
        }catch(Exception ex){
            errorMessage = ex.getMessage();
            ex.printStackTrace();
            return false;
        }
        
    }
    
    public boolean deletePolicy(long PolicyNo){
        String query = "delete from policy where Policy_No=?";
        try{
            PreparedStatement stmt;
            stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setLong(1, PolicyNo);
            boolean res = stmt.executeUpdate()>0;
            stmt.close();
            return res;
            
        }catch(Exception ex){
            errorMessage = ex.getMessage();
            ex.printStackTrace();
            return false;
        }
        
    }
    
    
    public Policy getPolicy(long Policy_No){
        
        String query = "select Policy_No,Name,Policy_Start_Date,Years,Plan_No,Amount,Mode,Payment,Employee_Id,Nominee,Id_Proof from policy where Policy_No=?";
        try
        {
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setLong(1, Policy_No);
            ResultSet rSet = stmt.executeQuery();
            if(rSet.next()){
                Policy policy = new Policy();
                policy.setPolicyNo(rSet.getLong("Policy_No"));
                policy.setName(rSet.getString("Name"));
                policy.setPolicyStartDate(rSet.getDate("Policy_Start_Date"));
                policy.setYears(rSet.getInt("Years"));
                policy.setPlanNo(rSet.getInt("Plan_No"));
                policy.setNominee(rSet.getString("Nominee"));
                policy.setIdProof(rSet.getBlob("Id_Proof"));
                policy.setEmployeeID(rSet.getString("Employee_Id"));
                policy.setMode(rSet.getString("Mode"));
                policy.setPayment(rSet.getInt("Payment"));
                policy.setAmount(rSet.getInt("Amount"));
                return policy;
            }
        }catch(Exception ex){
            errorMessage=ex.getMessage();
            ex.printStackTrace();
            return null;
        }
        return null;
    }
}
