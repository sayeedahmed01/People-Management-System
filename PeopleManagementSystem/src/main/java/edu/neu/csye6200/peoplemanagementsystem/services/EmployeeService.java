package edu.neu.csye6200.peoplemanagementsystem.services;

import edu.neu.csye6200.peoplemanagementsystem.dao.EmployeeDao;
import edu.neu.csye6200.peoplemanagementsystem.dao.TeamDao;
import edu.neu.csye6200.peoplemanagementsystem.pojo.Employee;

import java.util.List;

public class EmployeeService {

    public String signIn(String userName, String password) {
        try {
            List<Employee> employee = EmployeeDao.getEmployeeByUserName(userName);

            if (employee.size() == 0) {
                return "Employee ID wrong";
            }

            if (!employee.get(0).getPassword().equals(password)) {
                return "Wrong password";
            }

            return "Success";

        } catch (Exception e) {
            System.out.println("Error while sign up "+e);
            throw e;
        }
    }

    public String signInAdmin(Integer empId, String password) {
        try {
            Employee employee = EmployeeDao.getEmployeeById(empId).get(0);

            if (employee == null) {
                return "Employee ID wrong";
            }

            if (!employee.getPassword().equals(password)) {
                return "Wrong password";
            }

            if (!employee.isAdmin()) {
                return "Not an Admin";
            }

            return "Success";
        } catch (Exception e) {
            System.out.println("Error while sign up "+e);
            throw e;
        }
    }

    public Boolean terminateEmployee(String empId){
        try {
            return EmployeeDao.deleteEmployee(Integer.parseInt(empId));
        } catch (Exception e) {
            System.out.println("Error while terminating Employee " + e);
            return false;
        }
    }

}
