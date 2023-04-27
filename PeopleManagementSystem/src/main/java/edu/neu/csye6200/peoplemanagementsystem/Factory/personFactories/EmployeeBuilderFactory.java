package edu.neu.csye6200.peoplemanagementsystem.Factory.personFactories;

import edu.neu.csye6200.peoplemanagementsystem.builder.EmployeeBuilder;

public class EmployeeBuilderFactory implements BaseBuilderFactory {

    private static EmployeeBuilderFactory employeeBuilderFactory;

    private EmployeeBuilderFactory() {}

    public static EmployeeBuilderFactory getInstance() {
        if (employeeBuilderFactory == null) {
            employeeBuilderFactory = new EmployeeBuilderFactory();
        }
        return employeeBuilderFactory;
    }

    @Override
    public EmployeeBuilder getBuilder() {
        return new EmployeeBuilder();
    }
}
