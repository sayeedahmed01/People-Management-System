/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.peoplemanagementsystem.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author mehul
 */
public class Employee extends Person {

    private enum employmentStatus {
        NotHired,
        Active,
        Resigned,
        OnLeave,
        NoticePeriod,
        Terminated;
    }
    private String empId;

    private LocalDateTime dateOfJoining;
    
    private EmployeeCategory empCategory;

    private String organization;

    private String teamId;

    private Compensation compensation;

    private String employeeStatus;

    private String userName;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getTeam() {
        return teamId;
    }

    public void setTeam(String team) {
        this.teamId = team;
    }

    public Compensation getCompensation() {
        return compensation;
    }

    public void setCompensation(Compensation compensation) {
        this.compensation = compensation;
    }

    public EmployeeCategory getEmpCategory() {
        return empCategory;
    }

    public void setEmpCategory(EmployeeCategory empCategory) {
        this.empCategory = empCategory;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public LocalDateTime getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDateTime dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                ", empCategory=" + empCategory +
                ", organization='" + organization + '\'' +
                ", team='" + teamId + '\'' +
                ", compensation=" + compensation +
                '}';
    }
}
