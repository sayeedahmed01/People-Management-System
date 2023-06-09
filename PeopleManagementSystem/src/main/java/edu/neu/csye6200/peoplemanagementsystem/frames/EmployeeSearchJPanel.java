/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.peoplemanagementsystem.frames;


import edu.neu.csye6200.peoplemanagementsystem.Sorter;
import edu.neu.csye6200.peoplemanagementsystem.pojo.Employee;
import edu.neu.csye6200.peoplemanagementsystem.services.SearchService;

import java.awt.CardLayout;
import java.util.List;
import java.util.Locale;
import javax.swing.JPanel;

/**
 *
 * @author Nata
 */
public class EmployeeSearchJPanel extends JPanel {

    JPanel mainWorkArea;

    /**
     * Creates new form EmployeeSearchJPanel
     */
    public EmployeeSearchJPanel(JPanel mainWorkArea) {
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

        lbl_EmployeeSearchTitle = new javax.swing.JLabel();
        txt_SearchField = new javax.swing.JTextField();
        cmb_SearchType = new javax.swing.JComboBox<>();
        btn_SearchEmployee = new javax.swing.JButton();
        btn_Home = new javax.swing.JButton();
        cmb_SortType = new javax.swing.JComboBox<>();

        lbl_EmployeeSearchTitle.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbl_EmployeeSearchTitle.setText("Employee Search");

        txt_SearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SearchFieldActionPerformed(evt);
            }
        });

        cmb_SearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "ID" }));
        cmb_SearchType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_SearchTypeActionPerformed(evt);
            }
        });

        btn_SearchEmployee.setText("SEARCH");
        btn_SearchEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchEmployeeActionPerformed(evt);
            }
        });

        btn_Home.setText("Home");
        btn_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HomeActionPerformed(evt);
            }
        });

        cmb_SortType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Sort", "First Name", "Last Name" }));
        cmb_SortType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_SortTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(txt_SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmb_SearchType, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmb_SortType, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(btn_SearchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(lbl_EmployeeSearchTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Home)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_EmployeeSearchTitle)
                    .addComponent(btn_Home))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_SearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_SortType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btn_SearchEmployee)
                .addContainerGap(180, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_SearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SearchFieldActionPerformed

    private void cmb_SearchTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_SearchTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_SearchTypeActionPerformed

    private void btn_SearchEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchEmployeeActionPerformed
        // TODO add your handling code here:
        
        String txt = txt_SearchField.getText();
        String type = cmb_SearchType.getSelectedItem().toString().toLowerCase(Locale.ROOT);
        String sort = cmb_SortType.getSelectedItem().toString();
        
        SearchService ss = new SearchService();
        
        Sorter sorter;
        
        if(sort == "First Name"){
            sorter = Sorter.EmployeeSorterByFName;
        }
        else if(sort == "Last Name"){
            sorter = Sorter.EmployeeSorterByLName;
        }
        else{
            sorter = null;
        }
        
        
        List<Employee> emplist = ss.searchAndSortEmployee(type, txt, sorter);
        
        JPanel selectedPanel = new EmployeeListJPanel(mainWorkArea,emplist);
        mainWorkArea.add("WorkAreaJPanel", selectedPanel);
        CardLayout layout = (CardLayout) mainWorkArea.getLayout();
        layout.next(mainWorkArea);
        
        
    }//GEN-LAST:event_btn_SearchEmployeeActionPerformed

    private void btn_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HomeActionPerformed
        // TODO add your handling code here:
        JPanel selectedPanel = new AdminHomeJPanel(mainWorkArea);
        mainWorkArea.add("WorkAreaJPanel", selectedPanel);
        CardLayout layout = (CardLayout) mainWorkArea.getLayout();
        layout.next(mainWorkArea);
    }//GEN-LAST:event_btn_HomeActionPerformed

    private void cmb_SortTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_SortTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_SortTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Home;
    private javax.swing.JButton btn_SearchEmployee;
    private javax.swing.JComboBox<String> cmb_SearchType;
    private javax.swing.JComboBox<String> cmb_SortType;
    private javax.swing.JLabel lbl_EmployeeSearchTitle;
    private javax.swing.JTextField txt_SearchField;
    // End of variables declaration//GEN-END:variables
}
