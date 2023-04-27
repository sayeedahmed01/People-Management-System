/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package edu.neu.csye6200.peoplemanagementsystem;

import edu.neu.csye6200.peoplemanagementsystem.builder.EmployeeBuilder;

import edu.neu.csye6200.peoplemanagementsystem.Factory.personFactories.EmployeeBuilderFactory;
import edu.neu.csye6200.peoplemanagementsystem.dao.TeamDao;
import edu.neu.csye6200.peoplemanagementsystem.pojo.*;
import edu.neu.csye6200.peoplemanagementsystem.dao.EmployeeDao;
import edu.neu.csye6200.peoplemanagementsystem.pojo.*;
import edu.neu.csye6200.peoplemanagementsystem.services.CSVParser;
import edu.neu.csye6200.peoplemanagementsystem.services.SearchService;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author mehul
 */
public class PeopleManagementSystem {

    public static void main(String[] args) {

        System.out.println("Hello World!");

//        EmployeeBuilderFactory employeeBuilderFactory = EmployeeBuilderFactory.getInstance();
//        EmployeeBuilder employeeBuilder = employeeBuilderFactory.getBuilder();
////        EmployeeBuilder employee = employeeBuilder.createEntity();
//        Employee employee = employeeBuilder.createEntity()
//                .setEmpId("1")
//                .setFName("Dada")
//                .setLName("Pada")
//                .setDob(LocalDateTime.now())
//                .setGender(Gender.valueOf("male"))
//                .setPhone(String.valueOf(131414114))
//                .setEmail("abd@gmail.com")
//                .setCity("HYYD")
//                .setStreetAddress("ajnfajkfnajkdnvanvnavnkajvnnvlanvlknavafak ")
//                .setCountry(CountryEnum.valueOf("india"))
//                .setZipCode("000193")
//                .setIdType("pan")
//                .setDateOfJoining(LocalDateTime.now())
//                .setEmployeeCategory(new EmployeeCategory("FullTime", "01","Full"))
//                .setOrganization("organization")
//                .setTeam("setTeam")
//                .setCompensation(new Compensation(11111,1344, 1414,144, 98586))
//                .build();
//        EmployeeDao.save(employee);
        //EmployeeDao.getEmployeeByName("BB");
        //EmployeeDao.getEmployeeById(1);
        //EmployeeDao.getEmployeeByTeamId()
        //EmployeeDao.update(employee);
        //EmployeeDao.getEmployeeByName("dada");
        //CSVParser.insertEmpData();
        //CSVParser.insertTeamData();

//        System.out.println(employee);

    }
}
