/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.peoplemanagementsystem.frames;

import edu.neu.csye6200.peoplemanagementsystem.Factory.personFactories.EmployeeBuilderFactory;
import edu.neu.csye6200.peoplemanagementsystem.builder.EmployeeBuilder;
import edu.neu.csye6200.peoplemanagementsystem.pojo.*;
import edu.neu.csye6200.peoplemanagementsystem.services.SearchService;

import java.awt.CardLayout;
import java.sql.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nata
 */
public class EmployeeListJPanel extends JPanel {

    /**
     * Creates new form EmployeeListJPanel
     */
    
    JPanel mainWorkArea;
    
    public EmployeeListJPanel(JPanel mainWorkArea) {
        initComponents();
        this.mainWorkArea = mainWorkArea;
        
        SearchService allemp = new SearchService();
        List<Employee> all = new ArrayList<>();
        all = allemp.getAllEmployees();
        
        populateTable(all);
        tbl_EmployeeList.setEnabled(false);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        tbl_EmployeeList.setAutoResizeMode(0);
    }
    
    public EmployeeListJPanel(JPanel mainWorkArea, List<Employee> elist) {
        initComponents();
        this.mainWorkArea = mainWorkArea;
        populateTable(elist);
        tbl_EmployeeList.setEnabled(false);
    }
    
        private String empId;

    private LocalDateTime dateOfJoining;
    
    private EmployeeCategory empCategory;

    private String organization;

    private String teamId;

    private Compensation compensation;

    private String employeeStatus;
    
    private String userName;

    public void populateTable(List<Employee> elist){
        String columns [] = {"First Name","Last Name",
            "Gender","Phone","Email","Street Address","City",
            "Country","Zipcode","ID Type","User Name","Employee ID",
            "Date of Joining","Salary Type","Employee Level","Working Type","Organization",
            "Team ID","Base Pay","Bonus","401K","Health Insurance","Total Compensation"};
//        String data [][] = {{"1","Jeff","Boston"},
//            {"3","Bob","Butchland"},
//            {"13","Lex","New New York"}};
        DefaultTableModel dtm = new DefaultTableModel(columns,0);
        /*
        EmployeeBuilderFactory employeeBuilderFactory = EmployeeBuilderFactory.getInstance();
        EmployeeBuilder employeeBuilder = employeeBuilderFactory.getBuilder();
        
        Employee employee = employeeBuilder.createEntity()
                .setFName("HHH")
                .setLName("BBB")
                .setDob(LocalDateTime.now())
                .setGender(Gender.valueOf("male"))
                .setPhone(String.valueOf(131414114))
                .setEmail("abd@gmail.com")
                .setCity("HYYD")
                .setStreetAddress("ajnfajkfnajkdnvanvnavnkajvnnvlanvlknavafak ")
                .setCountry(CountryEnum.valueOf("india"))
                .setZipCode("000193")
                .setIdType("pan")
                .setDateOfJoining(LocalDateTime.now())
                .setUserName("abcd")
                .setEmpId("123")
                .setEmployeeCategory(new EmployeeCategory("FullTime", "01","Full"))
                .setOrganization("organization")
                .setTeam("setTeam")
                .setCompensation(new Compensation(30.2, 6, 7, 5, 7))
//                .setCompensation(new Compensation(11111,1344, 1414,144, 98586))
                .build();
        
        
        
        List<Employee> llll = new ArrayList<>();
        llll.add(employee);


         */
        for(Employee list: elist){
            String fname = list.getFName();
            String lname = list.getLName();
            String gender = list.getGender().toString();
            String phone = list.getPhone();
            String email = list.getEmail();
            String street = list.getStreetAddress();
            String city = list.getCity();
            String country = list.getCountry().toString();
            String zipcode = list.getZipCode();
            String idtype = list.getIdType();
            String username = list.getUserName();
            String empid = list.getEmpId();
            String doj = list.getDateOfJoining().toString();
            String saltype = list.getEmpCategory().getSalaryType();
            String emplvl = list.getEmpCategory().getLevel();
            String worktype = list.getEmpCategory().getWorkingType();
            String org = list.getOrganization();
            String teamid = list.getTeamId();
            Double compbase = list.getCompensation().getBasePay();
            Double compbonus = list.getCompensation().getBonus(); 
            Double comp401 = list.getCompensation().getContribute401k();
            Double compinsurance = list.getCompensation().getHealthinsurance();
            Double comptotal = list.getCompensation().getTotalComp();
            
            Object [] data = {fname,lname,gender,phone,email,street,city,country,zipcode,idtype,
                username,empid,doj,saltype,emplvl,worktype,org,teamid,compbase,compbonus,comp401,compinsurance,comptotal};
            
            dtm.addRow(data);
            
        }
        
        
        
        tbl_EmployeeList.setModel(dtm);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_EmployeeListTitle = new javax.swing.JLabel();
        jScrollPane1 = new JScrollPane();
        tbl_EmployeeList = new javax.swing.JTable();
        btn_Home = new javax.swing.JButton();

        lbl_EmployeeListTitle.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbl_EmployeeListTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_EmployeeListTitle.setText("Employee List");

        tbl_EmployeeList.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_EmployeeList);

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
                .addGap(116, 116, 116)
                .addComponent(lbl_EmployeeListTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 627, Short.MAX_VALUE)
                .addComponent(btn_Home)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_EmployeeListTitle)
                    .addComponent(btn_Home))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HomeActionPerformed
        // TODO add your handling code here:
            JPanel selectedPanel = new AdminHomeJPanel(mainWorkArea);
            mainWorkArea.add("WorkAreaJPanel", selectedPanel);
            CardLayout layout = (CardLayout) mainWorkArea.getLayout();
            layout.next(mainWorkArea);
    }//GEN-LAST:event_btn_HomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Home;
    private JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_EmployeeListTitle;
    private javax.swing.JTable tbl_EmployeeList;
    // End of variables declaration//GEN-END:variables
}
