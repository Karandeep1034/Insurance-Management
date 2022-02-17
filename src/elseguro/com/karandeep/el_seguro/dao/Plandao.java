/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karandeep.el_seguro.dao;

import com.karandeep.el_seguro.dto.Plan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 91701
 */
public class Plandao {
    
    private String errorMessage;
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public boolean insertPlan(Plan plan){
        String query = "insert into plan(Plan_Name,Plan_No,Min_Yrs,Max_Yrs,Min_Age,Max_Age,Min_Amount,Min_Years_To_Surrender,Late_Fee_Percent,Maturity_Percent,Surrender_Value_Intrest,Revival_Charges,Comission) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt;
            stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, plan.getPlan_Name());
            stmt.setInt(2, plan.getPlan_No());
            stmt.setInt(3, plan.getMinYrs());
            stmt.setInt(4,plan.getMaxYrs());
            stmt.setInt(5,plan.getMinAge());
            stmt.setInt(6, plan.getMaxAge());
            stmt.setInt(7,plan.getMinAmount());
            stmt.setInt(8, plan.getMinYearsToSurrender());
            stmt.setFloat(9, plan.getLateFeePercent());
            stmt.setFloat(10, plan.getMaturityPercent());
            stmt.setFloat(11, plan.getSurrenderValueInterest());
            stmt.setFloat(12, plan.getRevivalCharges());
            stmt.setFloat(13, plan.getComission());
            boolean res = stmt.executeUpdate()>0;
            stmt.close();
            return res;
            
        }catch(Exception ex){
            errorMessage = ex.getMessage();
            return false;
        }
        
    }
    
    public boolean updatePlan(Plan plan){
        String query = "update plan set Plan_Name=? ,Min_Yrs=?,Max_Yrs=?,Min_Age=?,Max_Age=?,Min_Amount=?,Min_Years_To_Surrender=?,Late_Fee_Percent=?,Maturity_Percent=?,Surrender_Value_Intrest=?,Revival_Charges=?,Comission=? where Plan_No=? ";
        try{
            PreparedStatement stmt;
            stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, plan.getPlan_Name());
            stmt.setInt(13, plan.getPlan_No());
            stmt.setInt(2, plan.getMinYrs());
            stmt.setInt(3,plan.getMaxYrs());
            stmt.setInt(4,plan.getMinAge());
            stmt.setInt(5, plan.getMaxAge());
            stmt.setInt(6,plan.getMinAmount());
            stmt.setInt(7, plan.getMinYearsToSurrender());
            stmt.setFloat(8, plan.getLateFeePercent());
            stmt.setFloat(9, plan.getMaturityPercent());
            stmt.setFloat(10, plan.getSurrenderValueInterest());
            stmt.setFloat(11, plan.getRevivalCharges());
            stmt.setFloat(12, plan.getComission());
            boolean res = stmt.executeUpdate()>0;
            stmt.close();
            return res;
            
        }catch(Exception ex){
            errorMessage = ex.getMessage();
            ex.printStackTrace();
            return false;
        }
        
    }
    
    public boolean deletePlan(int planNo){
        String query = "delete from plan where Plan_No=?";
        try{
            PreparedStatement stmt;
            stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, planNo);
            boolean res = stmt.executeUpdate()>0;
            stmt.close();
            return res;
            
        }catch(Exception ex){
            errorMessage = ex.getMessage();
            ex.printStackTrace();
            return false;
        }
        
    }
    
    public Plan getPlan(int Plan_No){
        
        String query = "select Plan_Name,Plan_No ,Min_Yrs,Max_Yrs,Min_Age,Max_Age,Min_Amount,Min_Years_To_Surrender,Late_Fee_Percent,Maturity_Percent,Surrender_Value_Intrest,Revival_Charges,Comission from plan where Plan_No=?";
        try
        {
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, Plan_No);
            ResultSet rSet = stmt.executeQuery();
            if(rSet.next()){
                Plan plan = new Plan();
                plan.setPlan_Name(rSet.getString("Plan_Name"));
                plan.setPlan_No(rSet.getInt("Plan_No"));
                plan.setMinYrs(rSet.getInt("Min_Yrs"));
                plan.setMaxYrs(rSet.getInt("Max_Yrs"));
                plan.setMinAge(rSet.getInt("Min_Age"));
                plan.setMaxAge(rSet.getInt("Max_Age"));
                plan.setMinAmount(rSet.getInt("Min_Amount"));
                plan.setMinYearsToSurrender(rSet.getInt("Min_Years_TO_Surrender"));
                plan.setLateFeePercent(rSet.getFloat("Late_Fee_Percent"));
                plan.setMaturityPercent(rSet.getFloat("Maturity_Percent"));
                plan.setSurrenderValueInterest(rSet.getFloat("Surrender_Value_Intrest"));
                plan.setRevivalCharges(rSet.getFloat("Revival_Charges"));
                plan.setComission(rSet.getFloat("Comission"));
                return plan;
            }
        }catch(Exception ex){
            errorMessage=ex.getMessage();
            ex.printStackTrace();
            return null;
        }
        return null;
    }
}
