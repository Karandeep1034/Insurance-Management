/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karandeep.el_seguro.dto;
import com.karandeep.el_seguro.enums.Role;
import java.sql.Date;

/**
 *
 * @author 91701
 */
public class Employee {
    
    private String name;
    
    private String employeeID;
    
    private Date dob;
    
    private String address;
    
    private String phoneNo;
    
    private String emailID;
    
    private Role employeeRole;
    
    private String branch_Id;
  

    public String getBranch_Id() {
        return branch_Id;
    }

    public void setBranch_Id(String branch_Id) {
        this.branch_Id = branch_Id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public Role getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(Role employeeRole) {
        this.employeeRole = employeeRole;
    }
    
    
 

    
}
