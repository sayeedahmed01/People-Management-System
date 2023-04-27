package edu.neu.csye6200.peoplemanagementsystem.services;

import edu.neu.csye6200.peoplemanagementsystem.Sorter;
import edu.neu.csye6200.peoplemanagementsystem.dao.EmployeeDao;
import edu.neu.csye6200.peoplemanagementsystem.dao.TeamDao;
import edu.neu.csye6200.peoplemanagementsystem.pojo.Employee;
import edu.neu.csye6200.peoplemanagementsystem.pojo.TeamObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchService {


    public List<Employee> searchEmployeeBasedOnName(String name) {
        try {
            List<Employee> employeeList = EmployeeDao.getEmployeeByName(name);
            return employeeList;
        } catch (Exception e) {
            System.out.println("Exception while searching employee" + e);
            return null;
        }
    }

    public List<Employee> getAllEmployees() {
        try {
            List<Employee> employeeList = EmployeeDao.getAllEmployees();
            return employeeList;
        } catch (Exception e) {
            System.out.println("Exception while searching employee" + e);
            return null;
        }
    }


    public List<TeamObject> getAllTeams() {
        try {
            List<TeamObject> teams = TeamDao.getAllTeams();
            return teams;
        } catch (Exception e) {
            System.out.println("Exception while searching employee" + e);
            return null;
        }
    }

    public List<Employee> searchAndSortEmployee(String fieldName, String fieldValue, Sorter sort) {
        List<Employee> list = new ArrayList<>();
        try {
            if ("id".equals(fieldName)) {
                list = EmployeeDao.getEmployeeById(Integer.parseInt(fieldValue));
            } else {
                list = EmployeeDao.getEmployeeByName(fieldValue);
            }
            return sort(list, sort);
        } catch (Exception e) {
            System.out.println("Exception while searching and sorting employee" + e);
            return list;
        }
    }

    public List<TeamObject> searchAndSortTeam(String fieldName, String fieldValue, String sortBy) {
        List<TeamObject> list = new ArrayList<>();
        try {
            if ("name".equals(fieldName)) {
                list = TeamDao.getTeamByName(fieldValue);
            } else {
                list = TeamDao.getTeamByType(fieldValue);
            }

            if (sortBy != null) {
                Collections.sort(list);
            }
            return list;
        } catch (Exception e) {
            System.out.println("Exception while searching and sorting employee" + e);
            return list;
        }
    }

    public Employee searchEmployeeBasedOnId(Integer id) {
        try {
            Employee employee = EmployeeDao.getEmployeeById(id).get(0);
            return employee;
        } catch (Exception e) {
            System.out.println("Exception while searching employee" + e);
            return null;
        }
    }

    public List<TeamObject> searchTeamBasedOnName(String name) {
        try {
            List<TeamObject> employeeList = TeamDao.getTeamByName(name);
            return employeeList;
        } catch (Exception e) {
            System.out.println("Exception while searching employee" + e);
            return null;
        }
    }


    public TeamObject searchTeamBasedOnId(Integer id) {
        try {
            List<TeamObject> team = TeamDao.getTeamById(id);
            return team.get(0);
        } catch (Exception e) {
            System.out.println("Exception while searching employee" + e);
            return null;
        }
    }

    private List<Employee> sort(List<Employee> list, Sorter sorter) {
        if (sorter == null)
            return list;
        list.sort(sorter.getComparator());
        return list;
    }


}
