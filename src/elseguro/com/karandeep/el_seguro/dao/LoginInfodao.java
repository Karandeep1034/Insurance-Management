/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karandeep.el_seguro.dao;

import com.karandeep.el_seguro.dto.LoginInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 91701
 */
public class LoginInfodao {
    
    private String errorMessage;
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public boolean insertLoginInfo(LoginInfo login_info){
        String query = "insert into login_info(Employee_Id,Password) values(?,?)";
        try{
            PreparedStatement stmt;
            stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, login_info.getEmployeeId());
            stmt.setString(2, login_info.getPassword());
            boolean res = stmt.executeUpdate()>0;
            stmt.close();
            return res;
            
        }catch(Exception ex){
            errorMessage=ex.getMessage();
            return false;
        }
        
    }
    
    public boolean updateLoginInfo(LoginInfo login_info){
        String query = "update login_info set Password=? where login_Id=?";
        try{
            PreparedStatement stmt;
            stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, login_info.getEmployeeId());
            stmt.setString(2, login_info.getPassword());
            boolean res = stmt.executeUpdate()>0;
            stmt.close();
            return res;
            
        }catch(Exception ex){
            errorMessage=ex.getMessage();
            return false;
        }
        
    }
    
    public boolean deleteLoginInfo(LoginInfo login_info){
        String query = "delete from log_info where Employee_Id=?";
        try{
            PreparedStatement stmt;
            stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, login_info.getEmployeeId());
            boolean res = stmt.executeUpdate()>0;
            stmt.close();
            return res;
            
        }catch(Exception ex){
            errorMessage=ex.getMessage();
            return false;
        }
        
    }
    
    public LoginInfo getLoginInfo(String Employee_Id){
        String query = "select Employee_Id,Password from login_info where Employee_Id=?";
        try
        {
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, Employee_Id);
            ResultSet rSet = stmt.executeQuery();
            if(rSet.next()){
                LoginInfo login_info = new LoginInfo();
                login_info.setEmployeeId(rSet.getString("Employee_Id"));
                login_info.setPassword(rSet.getString("Password"));
                return login_info;
            }
        }catch(Exception ex){
            errorMessage=ex.getMessage();
            return null;
        }
        return null;
    }
}
