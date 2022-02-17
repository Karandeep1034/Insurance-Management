/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karandeep.el_seguro.utils;

import java.util.Date;
import javax.swing.JComboBox;

/**
 *
 * @author 91701
 */
public class Utility {
    
    public static boolean isEmpty(String a){
        if( a==null || a.length()==0){
            return true;
        }
        return false;
    }
    
    public static void populateYear(JComboBox jcb){
        Date date = new Date();
        int year = date.getYear()+1900;
        //System.out.println(year);
        jcb.removeAllItems();
        for(int y = year ; y>=year-65;y--){
            jcb.addItem(y);
        }
    }
    
    public static void populateMonth(JComboBox jcb){
        Date date = new Date();
        jcb.removeAllItems();
        for(int y = 1 ; y<=12;y++){
            jcb.addItem(y);
        }
    }
    
    public static void populateDays(JComboBox jcb){
        Date date = new Date();
        jcb.removeAllItems();
        for(int y = 1 ; y<=31;y++){
            jcb.addItem(y);
        }
    }
}
