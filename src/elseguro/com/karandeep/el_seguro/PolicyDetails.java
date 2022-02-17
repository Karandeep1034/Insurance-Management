/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karandeep.el_seguro;

import com.karandeep.el_seguro.dao.Plandao;
import com.karandeep.el_seguro.dao.Policydao;
import com.karandeep.el_seguro.dao.Receiptdao;
import com.karandeep.el_seguro.dto.Plan;
import com.karandeep.el_seguro.dto.Policy;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.JOptionPane;

/**
 *
 * @author 91701
 */
public class PolicyDetails extends javax.swing.JInternalFrame {

    /**
     * Creates new form PolicyDetails
     */
    String action;
    long policyNo;
    public PolicyDetails() {
        initComponents();
    }

    public PolicyDetails(String s, Policy policy) {
        this();
        this.action = s;
        this.policyNo=policy.getPolicyNo();
        if (action.equals("Status")) {
            jLabel1.setVisible(true);
            jLabel2.setVisible(true);
            jLabel3.setVisible(true);
            jLabel4.setVisible(true);
            jLabel5.setVisible(true);
            jLabel6.setVisible(true);
            jLabel7.setVisible(true);
            jLabel8.setVisible(true);
            jLabel9.setVisible(true);
            jLabel10.setVisible(true);
            jLabel11.setVisible(true);
            jLabel12.setVisible(true);
            jLabel13.setVisible(true);
            jLabel14.setVisible(true);
            jLabel15.setVisible(true);
            jLabel16.setVisible(true);
            jLabel17.setVisible(true);
            jLabel18.setVisible(true);
            jButton1.setVisible(false);
            jLabel1.setText("Name");
            jLabel3.setText("Policy_Date");
            jLabel5.setText("Years");
            jLabel7.setText("Plan_No");
            jLabel9.setText("Amount");
            jLabel11.setText("Mode");
            jLabel13.setText("Payment");
            jLabel15.setText("Employee_Id");
            jLabel16.setText("Nominee");

            jLabel2.setText(policy.getName());
            jLabel4.setText(String.valueOf(policy.getPolicyStartDate()));
            jLabel6.setText(String.valueOf(policy.getYears()));
            jLabel8.setText(String.valueOf(policy.getPlanNo()));
            jLabel10.setText(String.valueOf(policy.getAmount()));
            jLabel12.setText(policy.getMode());
            jLabel14.setText(String.valueOf(policy.getPayment()));
            jLabel17.setText(policy.getEmployeeID());
            jLabel18.setText(policy.getNominee());
        } else if (action.equals("Surrender")) {
            jLabel1.setVisible(true);
            jLabel2.setVisible(true);
            jLabel3.setVisible(true);
            jLabel4.setVisible(true);
            jLabel5.setVisible(true);
            jLabel6.setVisible(true);
            jLabel7.setVisible(true);
            jLabel8.setVisible(true);
            jLabel9.setVisible(true);
            jLabel10.setVisible(true);

            jLabel13.setVisible(false);
            jLabel14.setVisible(false);
            jLabel15.setVisible(false);
            jLabel16.setVisible(false);
            jLabel17.setVisible(false);
            jLabel18.setVisible(false);
            jButton1.setVisible(false);

            jLabel1.setText("Name");
            jLabel3.setText("Policy_Date");
            jLabel5.setText("Mode");
            jLabel7.setText("Plan_No");
            jLabel9.setText("Amount");
            jLabel11.setText("Surrender Value");

            jLabel2.setText(policy.getName());
            jLabel4.setText(String.valueOf(policy.getPolicyStartDate()));
            jLabel6.setText(String.valueOf(policy.getMode()));
            jLabel8.setText(String.valueOf(policy.getPlanNo()));
            jLabel10.setText(String.valueOf(policy.getAmount()));
            jLabel12.setText(String.valueOf(calculateSurrenderValue(policy)));
        } else if (action.equals("Revival")) {
            jLabel1.setVisible(true);
            jLabel2.setVisible(true);
            jLabel3.setVisible(true);
            jLabel4.setVisible(true);
            jLabel5.setVisible(true);
            jLabel6.setVisible(true);
            jLabel7.setVisible(true);
            jLabel8.setVisible(true);
            jLabel9.setVisible(true);
            jLabel10.setVisible(true);

            jLabel13.setVisible(false);
            jLabel14.setVisible(false);
            jLabel15.setVisible(false);
            jLabel16.setVisible(false);
            jLabel17.setVisible(false);
            jLabel18.setVisible(false);
            jButton1.setVisible(false);

            jLabel1.setText("Name");
            jLabel3.setText("Policy_Date");
            jLabel5.setText("Mode");
            jLabel7.setText("Plan_No");
            jLabel9.setText("Amount");
            jLabel11.setText("Revival Value");

            jLabel2.setText(policy.getName());
            jLabel4.setText(String.valueOf(policy.getPolicyStartDate()));
            jLabel6.setText(String.valueOf(policy.getMode()));
            jLabel8.setText(String.valueOf(policy.getPlanNo()));
            jLabel10.setText(String.valueOf(policy.getAmount()));
            jLabel12.setText(String.valueOf(calculateRevivalValue(policy)));
        }
        else if(action.equals("CashierSurrender")){
            jLabel1.setVisible(true);
            jLabel2.setVisible(true);
            jLabel3.setVisible(true);
            jLabel4.setVisible(true);
            jLabel5.setVisible(true);
            jLabel6.setVisible(true);
            jLabel7.setVisible(true);
            jLabel8.setVisible(true);
            jLabel9.setVisible(true);
            jLabel10.setVisible(true);

            jLabel13.setVisible(false);
            jLabel14.setVisible(false);
            jLabel15.setVisible(false);
            jLabel16.setVisible(false);
            jLabel17.setVisible(false);
            jLabel18.setVisible(false);
            jButton1.setVisible(true);

            jLabel1.setText("Name");
            jLabel3.setText("Policy_Date");
            jLabel5.setText("Mode");
            jLabel7.setText("Plan_No");
            jLabel9.setText("Amount");
            jLabel11.setText("Surrender Value");
            jButton1.setText("Surrender");

            jLabel2.setText(policy.getName());
            jLabel4.setText(String.valueOf(policy.getPolicyStartDate()));
            jLabel6.setText(String.valueOf(policy.getMode()));
            jLabel8.setText(String.valueOf(policy.getPlanNo()));
            jLabel10.setText(String.valueOf(policy.getAmount()));
            jLabel12.setText(String.valueOf(calculateSurrenderValue(policy)));
        }
         else if (action.equals("CashierRevival")) {
            jLabel1.setVisible(true);
            jLabel2.setVisible(true);
            jLabel3.setVisible(true);
            jLabel4.setVisible(true);
            jLabel5.setVisible(true);
            jLabel6.setVisible(true);
            jLabel7.setVisible(true);
            jLabel8.setVisible(true);
            jLabel9.setVisible(true);
            jLabel10.setVisible(true);

            jLabel13.setVisible(false);
            jLabel14.setVisible(false);
            jLabel15.setVisible(false);
            jLabel16.setVisible(false);
            jLabel17.setVisible(false);
            jLabel18.setVisible(false);
            jButton1.setVisible(true);

            jLabel1.setText("Name");
            jLabel3.setText("Policy_Date");
            jLabel5.setText("Mode");
            jLabel7.setText("Plan_No");
            jLabel9.setText("Amount");
            jLabel11.setText("Revival Value");
            jButton1.setText("Revive");

            jLabel2.setText(policy.getName());
            jLabel4.setText(String.valueOf(policy.getPolicyStartDate()));
            jLabel6.setText(String.valueOf(policy.getMode()));
            jLabel8.setText(String.valueOf(policy.getPlanNo()));
            jLabel10.setText(String.valueOf(policy.getAmount()));
            jLabel12.setText(String.valueOf(calculateRevivalValue(policy)));

    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        jLabel11.setText("jLabel11");

        jLabel12.setText("jLabel12");

        jLabel13.setText("jLabel13");

        jLabel14.setText("jLabel14");

        jLabel15.setText("jLabel15");

        jLabel16.setText("jLabel16");

        jLabel17.setText("jLabel17");

        jLabel18.setText("jLabel18");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel7)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1))
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jButton1)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(action.equals("CashierSurrender")){
            Receiptdao r = new Receiptdao();
            Policydao pol = new Policydao();
            r.deleteReceipt(policyNo);
            pol.deletePolicy(policyNo);
            JOptionPane.showMessageDialog(this,"Done");
        }
        if(action.equals("CashierRevival")){
             Receiptdao r = new Receiptdao();
             Date date = new Date(System.currentTimeMillis());
             r.updateDueDate(policyNo,date);
             JOptionPane.showMessageDialog(this,"Done");
             
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

    private double calculateSurrenderValue(Policy policy) {
        Date doc = policy.getPolicyStartDate();
        String mode = policy.getMode();
        Plan plan = new Plandao().getPlan(policy.getPlanNo());
        float percentage = plan.getSurrenderValueInterest();
        Date lastDueDate = new Receiptdao().getLastPaidDueDate(policy.getPolicyNo());
        float count = calculateTotalPremiumsDeposited(doc, lastDueDate, mode);
        System.out.println(doc + " " + lastDueDate + " " + count);
        return count * policy.getPayment() * percentage / 100;
    }

    private int calculateTotalPremiumsDeposited(Date doc, Date lastDueDate, String mode) {
        Period period = Period.between(doc.toLocalDate(), lastDueDate.toLocalDate());
        if ("YEARLY".equals(mode.toUpperCase())) {
            return period.getYears() + 1;
        } else if ("HALFYEARLY".equals(mode.toUpperCase())) {
            return 2 * period.getYears() + period.getMonths() / 6 + 1;
        } else if ("QUATERLY".equals(mode.toUpperCase())) {
            return 4 * period.getYears() + period.getMonths() / 3 + 1;
        } else {
            return 12 * period.getYears() + period.getMonths() + 1;
        }
    }

    private double calculateRevivalValue(Policy policy) {
        Date doc = policy.getPolicyStartDate();
        String mode = policy.getMode();
        Plan plan = new Plandao().getPlan(policy.getPlanNo());
        float lateFee = plan.getLateFeePercent();
        Date date = new Date(System.currentTimeMillis());
        Date lastDueDate = new Receiptdao().getLastPaidDueDate(policy.getPolicyNo());
        float count = calculateTotalPremiumsDeposited(lastDueDate, date, mode) - 1;
        return count*policy.getPayment() + count * policy.getPayment() * lateFee / 100;

    }

}
