/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.peoplemanagementsystem.pojo;

/**
 *
 * @author mehul
 */
public class EmployeeCategory {
    public EmployeeCategory(String salaryType, String level, String workingType) {
        this.salaryType = salaryType; //part time/full time
        this.level = level; //l1 - l10
        this.workingType = workingType;
    }

    private String salaryType;
    private String level;
    private String workingType;

    public String getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getWorkingType() {
        return workingType;
    }

    public void setWorkingType(String workingType) {
        this.workingType = workingType;
    }
}
