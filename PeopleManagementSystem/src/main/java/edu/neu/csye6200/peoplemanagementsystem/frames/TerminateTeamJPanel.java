/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.peoplemanagementsystem.frames;

import edu.neu.csye6200.peoplemanagementsystem.services.TeamService;

import java.awt.CardLayout;
import javax.swing.*;

/**
 *
 * @author Nata
 */
public class TerminateTeamJPanel extends JPanel {

    /**
     * Creates new form TerminateTeamJPanel
     */
    
    JPanel mainWorkArea;
    
    public TerminateTeamJPanel(JPanel mainWorkArea) {
        initComponents();
        this.mainWorkArea = mainWorkArea;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_TerminateTeamTitle = new javax.swing.JLabel();
        lbl_EmployeeID = new javax.swing.JLabel();
        txt_TeamID = new javax.swing.JTextField();
        btn_Terminate = new javax.swing.JButton();
        btn_Home = new javax.swing.JButton();

        lbl_TerminateTeamTitle.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbl_TerminateTeamTitle.setText("Terminate Team");

        lbl_EmployeeID.setText("Team ID");

        btn_Terminate.setText("TERMINATE");
        btn_Terminate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TerminateActionPerformed(evt);
            }
        });

        btn_Home.setText("Home");
        btn_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(lbl_EmployeeID)
                        .addGap(37, 37, 37)
                        .addComponent(txt_TeamID, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(btn_Terminate)))
                .addContainerGap(236, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(lbl_TerminateTeamTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Home)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_TerminateTeamTitle)
                    .addComponent(btn_Home))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_EmployeeID)
                    .addComponent(txt_TeamID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(btn_Terminate)
                .addContainerGap(277, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TerminateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TerminateActionPerformed
        // TODO add your handling code here:
        String id = txt_TeamID.getText();
        
        TeamService empservices = new TeamService();
        
        empservices.terminateTeam(id);

        JOptionPane.showMessageDialog(null, "Team has been terminated!");
    }//GEN-LAST:event_btn_TerminateActionPerformed

    private void btn_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HomeActionPerformed
        // TODO add your handling code here:
        JPanel selectedPanel = new AdminHomeJPanel(mainWorkArea);
        mainWorkArea.add("WorkAreaJPanel", selectedPanel);
        CardLayout layout = (CardLayout) mainWorkArea.getLayout();
        layout.next(mainWorkArea);
    }//GEN-LAST:event_btn_HomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Home;
    private javax.swing.JButton btn_Terminate;
    private javax.swing.JLabel lbl_EmployeeID;
    private javax.swing.JLabel lbl_TerminateTeamTitle;
    private javax.swing.JTextField txt_TeamID;
    // End of variables declaration//GEN-END:variables
}