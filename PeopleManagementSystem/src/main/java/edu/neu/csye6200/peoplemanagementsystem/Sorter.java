package edu.neu.csye6200.peoplemanagementsystem;

import edu.neu.csye6200.peoplemanagementsystem.pojo.Employee;
import edu.neu.csye6200.peoplemanagementsystem.pojo.Person;

import java.util.Comparator;

public enum Sorter {

    EmployeeSorterByFName("sortByFName", (Employee emp1, Employee emp2) -> emp1.getFName().compareTo(emp2.getFName())),
    EmployeeSorterByLName("sortByLName", (Employee emp1, Employee emp2) -> emp1.getLName().compareTo(emp2.getLName())),
    EmployeeSorterByJoiningDate("SortByJoinDate", (Employee emp1, Employee emp2) -> emp1.getDateOfJoining().compareTo(emp2.getDateOfJoining()));

    String name;
    Comparator<Employee> comparator;

    private Sorter(String name, Comparator<Employee> comparator) {
        this.name = name;
        this.comparator = comparator;
    }

    public String getName() {
        return name;
    }

    public Comparator<Employee> getComparator() {
        return comparator;
    }
}
