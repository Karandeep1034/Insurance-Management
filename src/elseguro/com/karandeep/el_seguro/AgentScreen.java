/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karandeep.el_seguro;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 91701
 */
public class AgentScreen extends javax.swing.JFrame {
    
    String employeeId;

    /**
     * Creates new form AgentScreen
     */
    public AgentScreen(String employeeId) {
        initComponents();
        setTitle("Agent Screen");
        setSize(900,600);
        setLocationRelativeTo(null);
        this.employeeId = employeeId;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        myProfileMenu = new javax.swing.JMenu();
        dueListMenu = new javax.swing.JMenu();
        comissionMenu = new javax.swing.JMenu();
        policyStatusMenu = new javax.swing.JMenu();
        surrenderValueMenu = new javax.swing.JMenu();
        revivalMenu = new javax.swing.JMenu();

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );

        myProfileMenu.setText("My Profile");
        myProfileMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myProfileMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(myProfileMenu);

        dueListMenu.setText("Due List");
        dueListMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dueListMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(dueListMenu);

        comissionMenu.setText("Comission");
        comissionMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comissionMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(comissionMenu);

        policyStatusMenu.setText("Policy Status");
        policyStatusMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                policyStatusMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(policyStatusMenu);

        surrenderValueMenu.setText("Surrender Value");
        surrenderValueMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                surrenderValueMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(surrenderValueMenu);

        revivalMenu.setText("Revival Value");
        revivalMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                revivalMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(revivalMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myProfileMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myProfileMenuMouseClicked
        // TODO add your handling code here:
               ViewEmployeeDetailScreen viewDetail = new ViewEmployeeDetailScreen(employeeId);
        viewDetail.setVisible(true);
        jDesktopPane1.add(viewDetail);
        try {
            viewDetail.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AgentScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_myProfileMenuMouseClicked

    private void dueListMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dueListMenuMouseClicked
        // TODO add your handling code here:
        ViewEmployeeComission viewComission = new ViewEmployeeComission("View DueList");
        viewComission.setVisible(true);
        jDesktopPane1.add(viewComission);
        try {
            viewComission.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AgentScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_dueListMenuMouseClicked

    private void comissionMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comissionMenuMouseClicked
        // TODO add your handling code here:
        ViewEmployeeComission viewComission = new ViewEmployeeComission("View Commision");
        viewComission.setVisible(true);
        jDesktopPane1.add(viewComission);
        try {
            viewComission.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AgentScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comissionMenuMouseClicked

    private void policyStatusMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_policyStatusMenuMouseClicked
        // TODO add your handling code here:
        PolicyInputScreen status = new PolicyInputScreen("Status",jDesktopPane1);
        status.setVisible(true);
        jDesktopPane1.add(status);
        try {
            status.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AgentScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_policyStatusMenuMouseClicked

    private void surrenderValueMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_surrenderValueMenuMouseClicked
        // TODO add your handling code here:
        PolicyInputScreen status = new PolicyInputScreen("Surrender",jDesktopPane1);
        status.setVisible(true);
        jDesktopPane1.add(status);
        try {
            status.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AgentScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_surrenderValueMenuMouseClicked

    private void revivalMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_revivalMenuMouseClicked
        // TODO add your handling code here:
        PolicyInputScreen status = new PolicyInputScreen("Revival",jDesktopPane1);
        status.setVisible(true);
        jDesktopPane1.add(status);
        try {
            status.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AgentScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_revivalMenuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu comissionMenu;
    private javax.swing.JMenu dueListMenu;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu myProfileMenu;
    private javax.swing.JMenu policyStatusMenu;
    private javax.swing.JMenu revivalMenu;
    private javax.swing.JMenu surrenderValueMenu;
    // End of variables declaration//GEN-END:variables
}