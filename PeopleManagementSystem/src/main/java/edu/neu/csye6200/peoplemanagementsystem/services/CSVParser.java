package edu.neu.csye6200.peoplemanagementsystem.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class CSVParser {
        static final String DB = "jdbc:mysql://127.0.0.1:3306/employeemanagementsystem";
        static final String USER_root = "root";
        static final String PASS_root = "rootlol";

        static final String csv_file_emp = "empdata.csv";
        static final String csv_file_team = "teamdata.csv";
        static final int batchSize = 20;

        public static void insertEmpData(){
                int i = 0;
                try {
                        Connection con = DriverManager.getConnection(DB,USER_root,PASS_root);
                        String sql = "INSERT INTO employees (fName ,lName,gender,phone,email,city,streetAddress,country, zipCode, idType,salaryType,empLevel,workingType,organizationType,teamId,basePay,bonus,healthinsurance,contribute401k,totalComp,userName) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
                        PreparedStatement statement = con.prepareStatement(sql);
                        String lin= null;
                        int count = 0;
                        BufferedReader bf = new BufferedReader(new FileReader(csv_file_emp));
                        bf.readLine();
                        while ((lin= bf.readLine()) != null) {
                                i++;
                                String[] data = lin.split(",");
                                String fName = data[0];
                                String lName = data[1];
                                String gender = data[2];
                                String phone = data[3];
                                String email = data[4];
                                String city = data[5];
                                String streetAddress = data[6];
                                String country = data[7];
                                String zipCode= data[8];
                                String idType= data[9];
                                String salaryType= data[10];
                                String empLevel= data[11];
                                String workingType= data[12];
                                String organizationType= data[13];
                                String teamId= data[14];
                                String basePay= data[15];
                                String bonus= data[16];
                                String healthinsurance= data[17];
                                String contribute401k= data[18];
                                String totalComp= data[19];
                                String userName= data[20];
                                statement.setString(1, fName);
                                statement.setString(2, lName);
                                statement.setString(3, gender);
                                statement.setString(4, phone);
                                statement.setString(5, email);
                                statement.setString(6, city);
                                statement.setString(7, streetAddress);
                                statement.setString(8, country);
                                statement.setString(9, zipCode);
                                statement.setString(10, idType);
                                statement.setString(11, salaryType);
                                statement.setString(12, empLevel);
                                statement.setString(13, workingType);
                                statement.setString(14, organizationType);
                                statement.setString(15, teamId);
                                statement.setString(16, basePay);
                                statement.setString(17, bonus);
                                statement.setString(18, healthinsurance);
                                statement.setString(19, contribute401k);
                                statement.setString(20, totalComp);
                                statement.setString(21, userName);
                                statement.addBatch();
                                if (count % batchSize == 0) {
                                        statement.executeBatch();
                                }
                        }
                        bf.close();
                        statement.executeBatch();
//            con.commit();
                        con.close();
                        System.out.println("Employee Data inserted");
                } catch (SQLException | FileNotFoundException e) {
                        throw new RuntimeException(e);
                } catch (Exception e) {
                        throw new RuntimeException(e);
                }
        }
        public static void insertTeamData(){
                try {
                        Connection con = DriverManager.getConnection(DB,USER_root,PASS_root);
                        String sqlT = "INSERT INTO teams (team_organization, team_name, managerId, team_size, team_type) VALUES (?,?,?,?,?) ";
                        PreparedStatement statement = con.prepareStatement(sqlT);
                        String lin= null;
                        int count = 0;
                        BufferedReader bf = new BufferedReader(new FileReader(csv_file_team));
                        bf.readLine();
                        while ((lin= bf.readLine()) != null) {
                                String[] data = lin.split(",");
                                String team_organization = data[0];
                                String team_name = data[1];
                                String managerId = data[2];
                                String team_size = data[3];
                                String team_type = data[4];
                                statement.setString(1, team_organization);
                                statement.setString(2, team_name);
                                Integer sqlManager = Integer.valueOf(managerId);
                                statement.setInt(3, sqlManager);
                                Integer sqlSize = Integer.valueOf(team_size);
                                statement.setInt(4, sqlSize);
                                statement.setString(5, team_type);
                                statement.addBatch();
                                if (count % batchSize == 0) {
                                        statement.executeBatch();
                                }
                        }
                        bf.close();
                        statement.executeBatch();
//            con.commit();
                        con.close();
                        System.out.println("Teams Data inserted");
                } catch (SQLException | FileNotFoundException e) {
                        throw new RuntimeException(e);
                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
        }



}
