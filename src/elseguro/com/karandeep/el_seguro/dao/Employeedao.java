/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karandeep.el_seguro.dao;

import com.karandeep.el_seguro.dto.Employee;
import com.karandeep.el_seguro.enums.Role;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 91701
 */
public class Employeedao {
    
    private String errorMessage;
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public boolean insertEmployeeInfo(Employee employee){
        String query = "insert into employee(Name,Employee_ID,DOB,Address,Phone_No,Email_Id,Employee_Role,Branch_Id) values(?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt;
            stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getEmployeeID());
            stmt.setDate(3, employee.getDob());
            stmt.setString(4,employee.getAddress());
            stmt.setString(5,employee.getPhoneNo());
            stmt.setString(6, employee.getEmailID());
            stmt.setString(7,employee.getEmployeeRole().toString());
            stmt.setString(8,employee.getBranch_Id());
            boolean res = stmt.executeUpdate()>0;
            stmt.close();
            return res;
            
        }catch(Exception ex){
            errorMessage = ex.getMessage();
            ex.printStackTrace();
            return false;
        }
        
    }
    public boolean updateEmployeeInfo(Employee employee){
        String query = "update employee set Name=? , DOB=? , Address=? , Phone_No=? , Email_Id=? , Employee_Role=? , Branch_Id=? where Employee_Id=? ";
        try{
            PreparedStatement stmt;
            stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, employee.getName());
            stmt.setString(8, employee.getEmployeeID());
            stmt.setDate(2, employee.getDob());
            stmt.setString(3,employee.getAddress());
            stmt.setString(4,employee.getPhoneNo());
            stmt.setString(5, employee.getEmailID());
            stmt.setString(6,employee.getEmployeeRole().toString());
            stmt.setString(7, employee.getBranch_Id());
            boolean res = stmt.executeUpdate()>0;
            stmt.close();
            return res;
            
        }catch(Exception ex){
            errorMessage = ex.getMessage();
            ex.printStackTrace();
            return false;
        }
        
    }
    
    public boolean deleteEmployeeInfo(String Employee_Id){
        String query = "delete from employee where Employee_Id=?";
        try{
            PreparedStatement stmt;
            stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, Employee_Id);
            boolean res = stmt.executeUpdate()>0;
            stmt.close();
            return res;
            
        }catch(Exception ex){
            errorMessage = ex.getMessage();
            ex.printStackTrace();
            return false;
        }
        
    }
    
    public Employee getEmployee(String Employee_Id){
        
        String query = "select Name,Employee_Id,DOB,Address,Phone_No,Email_Id,Employee_Role,Branch_Id from employee where Employee_Id=?";
        try
        {
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, Employee_Id);
            ResultSet rSet = stmt.executeQuery();
            if(rSet.next()){
                Employee employee = new Employee();
            employee.setName(rSet.getString("Name"));
            employee.setEmployeeID(rSet.getString("Employee_Id"));
            employee.setDob(rSet.getDate("DOB"));
            employee.setAddress(rSet.getString("Address"));
            employee.setPhoneNo(rSet.getString("Phone_No"));
            employee.setEmailID(rSet.getString("Email_Id"));
            employee.setEmployeeRole(Role.valueOf(rSet.getString("Employee_Role").toUpperCase()));
            employee.setBranch_Id(rSet.getString("Branch_Id"));
            return employee;
            }
        }catch(Exception ex){
            errorMessage=ex.getMessage();
            ex.printStackTrace();
            return null;
        }
        return null;
    }
    
    public List<Employee> retrieveManagers(){
        
        String query = "select Name,Employee_Id,DOB,Address,Phone_No,Email_Id,Employee_Role from employee where Employee_Role = 'Manager'";
        List<Employee> managers = new ArrayList<>();
        try
        {
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            //stmt.setString(1, Employee_Id);
            ResultSet rSet = stmt.executeQuery();
            if(rSet.next()){
                do{
                    Employee employee = new Employee();
                    employee.setName(rSet.getString("Name"));
                    employee.setEmployeeID(rSet.getString("Employee_Id"));
                    employee.setDob(rSet.getDate("DOB"));
                    employee.setAddress(rSet.getString("Address"));
                    employee.setPhoneNo(rSet.getString("Phone_No"));
                    employee.setEmailID(rSet.getString("Email_Id"));
                    employee.setEmployeeRole(Role.valueOf(rSet.getString("Employee_Role").toUpperCase()));
                    managers.add(employee);
                }while(rSet.next());
          }
        }catch(Exception ex){
            errorMessage=ex.getMessage();
            System.out.println(ex.getMessage());
        }
        return managers;
    }
    
    
}
