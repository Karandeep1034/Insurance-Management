/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karandeep.el_seguro.dao;

import com.karandeep.el_seguro.dto.Branch;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 91701
 */
public class Branchdao {

    
    private String errorMessage;
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public boolean insertBranchInfo(Branch branch){
        String query = "insert into branch(Location,Branch_Id,Branch_Manager) values(?,?,?)";
        try{
            PreparedStatement stmt;
            stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, branch.getLocation());
            stmt.setString(2, branch.getBranchID());
            stmt.setString(3,branch.getBranchManager());
            boolean res = stmt.executeUpdate()>0;
            stmt.close();
            return res;
            
        }catch(Exception ex){
            errorMessage=ex.getMessage();
            System.out.println(errorMessage);
            return false;
        }
        
    }
    
    public boolean updateBranchInfo(Branch branch){
        String query = "update branch set Location=? , Branch_Manager = ? where Branch_Id=?";
        try{
            PreparedStatement stmt;
            stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, branch.getLocation());
            stmt.setString(2,branch.getBranchManager());
            stmt.setString(3, branch.getBranchID());
            boolean res = stmt.executeUpdate()>0;
            stmt.close();
            return res;
            
        }catch(Exception ex){
            errorMessage=ex.getMessage();
            System.out.println(errorMessage);
            return false;
        }
        
    }
    public boolean deleteBranchInfo(String branchId){
        String query = "delete from branch where Branch_Id=?";
        try{
            PreparedStatement stmt;
            stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, branchId);
            boolean res = stmt.executeUpdate()>0;
            stmt.close();
            return res;
            
        }catch(Exception ex){
            errorMessage=ex.getMessage();
            System.out.println(errorMessage);
            return false;
        }
        
    }
    public Branch getBranch(String Branch_Id){
        String query = "select Branch_Id,Branch_Manager,Location from branch where Branch_Id=? ";
        try
        {
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, Branch_Id);
            ResultSet rSet = stmt.executeQuery();
            if(rSet.next()){
                Branch branch = new Branch();
                branch.setBranchID(rSet.getString("Branch_Id"));
                branch.setBranchManager(rSet.getString("Branch_Manager"));
                branch.setLocation(rSet.getString("Location"));
                return branch;
                
            }
        }catch(Exception ex){
            errorMessage=ex.getMessage();
            System.out.println(errorMessage);
            return null;
        }
        return null;
    }

    public List<Branch> getAllBranches() {
        String query = "select Branch_Id,Branch_Manager,Location from branch";
        List<Branch> list = new ArrayList<>();
        try
        {
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            
            ResultSet rSet = stmt.executeQuery();
            if(rSet.next()){
                do{
                    Branch branch = new Branch();
                    branch.setBranchID(rSet.getString("Branch_Id"));
                    branch.setBranchManager(rSet.getString("Branch_Manager"));
                    branch.setLocation(rSet.getString("Location"));
                    list.add(branch);
                }while(rSet.next());
            }
        }catch(Exception ex){
            errorMessage=ex.getMessage();
            System.out.println(errorMessage);
           
        }
        return list;
    }
    
}
