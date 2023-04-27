package edu.neu.csye6200.peoplemanagementsystem.builder;

import edu.neu.csye6200.peoplemanagementsystem.pojo.*;

import java.time.LocalDateTime;

public class EmployeeBuilder implements Builder {

    private Employee employee;

    public EmployeeBuilder createEntity() {
        this.employee = new Employee();
        return this;
    }

    public Employee build() {
        return this.employee;
    }


    public EmployeeBuilder setEmpId(String value) {
        this.employee.setEmpId(value);
        return this;
    }

    public EmployeeBuilder setEmployeeCategory(EmployeeCategory value) {
        this.employee.setEmpCategory(value);
        return this;
    }

    public EmployeeBuilder setOrganization(String value) {
        this.employee.setOrganization(value);
        return this;
    }

    public EmployeeBuilder setTeam(String value) {
        this.employee.setTeam(value);
        return this;
    }

    public EmployeeBuilder setCompensation(Compensation value) {
        this.employee.setCompensation(value);
        return this;
    }

    public EmployeeBuilder setDateOfJoining(LocalDateTime value) {
        this.employee.setDateOfJoining(value);
        return this;
    }

    public EmployeeBuilder setEmployeeStatus(String value) {
        this.employee.setEmployeeStatus(value);
        return this;
    }


    @Override
    public EmployeeBuilder setFName(String value) {
        this.employee.setFName(value);
        return this;
    }

    @Override
    public EmployeeBuilder setLName(String value) {
        this.employee.setLName(value);
        return this;
    }

    @Override
    public EmployeeBuilder setGender(Gender value) {
        this.employee.setGender(value);
        return this;
    }

    @Override
    public EmployeeBuilder setPhone(String value) {
        this.employee.setPhone(value);
        return this;
    }

    @Override
    public EmployeeBuilder setEmail(String value) {
        this.employee.setEmail(value);
        return this;
    }

    @Override
    public EmployeeBuilder setDob(LocalDateTime value) {
        this.employee.setDob(value);
        return this;

    }

    @Override
    public EmployeeBuilder setCity(String value) {
        this.employee.setCity(value);
        return this;
    }

    @Override
    public EmployeeBuilder setStreetAddress(String value) {
        this.employee.setStreetAddress(value);
        return this;
    }

    @Override
    public EmployeeBuilder setZipCode(String value) {
        this.employee.setZipCode(value);
        return this;
    }

    @Override
    public EmployeeBuilder setIdType(String value) {
        this.employee.setIdType(value);
        return this;
    }

    @Override
    public EmployeeBuilder setPassword(String value) {
        this.employee.setPassword(value);
        return this;
    }

    @Override
    public EmployeeBuilder setCountry(CountryEnum value) {
        this.employee.setCountry(value);
        return this;
    }

    @Override
    public EmployeeBuilder setUserName(String value) {
        this.employee.setUserName(value);
        return this;
    }


}
