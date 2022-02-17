/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karandeep.el_seguro.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 91701
 */
public class DataConnection {
    
    private static Connection con = null;
    
    private DataConnection(){
        
    }
    
    public static Connection getConnection()
    {
        try
        {
            if(con == null)
            {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/el_seguro","root","root");
            }
            return con;
        }catch(Exception ex)
        {
            System.out.println(ex);
            return null;
        }
    }
    
    public static void closeConnection()
    {
        try{
            if(con!=null){
                con.close();
            }
            con = null;
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
}
