package edu.neu.csye6200.peoplemanagementsystem.dao;


import edu.neu.csye6200.peoplemanagementsystem.Factory.personFactories.EmployeeBuilderFactory;
import edu.neu.csye6200.peoplemanagementsystem.builder.EmployeeBuilder;
import edu.neu.csye6200.peoplemanagementsystem.pojo.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static edu.neu.csye6200.peoplemanagementsystem.pojo.CountryEnum.getCountryEnum;

public class EmployeeDao extends Dao {

    private static final EmployeeBuilder employeeBuilder = EmployeeBuilderFactory.getInstance().getBuilder();

    public static List<Employee> save(Employee e) {

        //have it output the row
        try (Connection c = getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "INSERT INTO employees (fName,lName,gender,phone,email,city,streetAddress,country,zipCode,idType, " +
                             " salaryType, empLevel, workingType, organizationType, teamId, basePay,bonus, healthinsurance, contribute401k, totalComp, userName, userPassword) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ) {
            statement.setString(1, e.getFName());
            statement.setString(2, e.getLName());
            //statement.setTimestamp(3, Timestamp.valueOf(e.getDob().toString().replace("T"," ")));
            statement.setString(3, String.valueOf(e.getGender()));
            statement.setString(4, e.getPhone());
            statement.setString(5, e.getEmail());
            statement.setString(6, e.getCity());
            statement.setString(7, e.getStreetAddress());
            statement.setString(8, String.valueOf(e.getCountry()));
            statement.setString(9, e.getZipCode());
            statement.setString(10, e.getIdType());
            //statement.setTimestamp(12, Timestamp.valueOf(e.getDateOfJoining().toString().replace("T"," ")));
            statement.setString(11, e.getEmpCategory().getSalaryType());
            statement.setString(12, e.getEmpCategory().getLevel());
            statement.setString(13, e.getEmpCategory().getWorkingType());
            statement.setString(14, e.getOrganization());
            statement.setString(15, e.getTeam());
            statement.setString(16, String.valueOf(e.getCompensation().getBasePay()));
            statement.setString(17, String.valueOf(e.getCompensation().getBonus()));
            statement.setString(18, String.valueOf(e.getCompensation().getHealthinsurance()));
            statement.setString(19, String.valueOf(e.getCompensation().getContribute401k()));
            statement.setString(20, String.valueOf(e.getCompensation().getTotalComp()));
            statement.setString(21, e.getUserName());
            statement.setString(22, e.getPassword());
            int result = statement.executeUpdate();
            boolean res = result > 0 ? true : false;

            //logic to have it output the saved record
            PreparedStatement displayStmt = c.prepareStatement("SELECT * FROM employees WHERE empId = (SELECT MAX(empId) FROM employees)");
            List<Employee> list = new ArrayList<>();
            ResultSet resultSet = displayStmt.executeQuery();
                int i = 0;
            list = getEmployeeObjectByResultSet(resultSet);
            return list;
        } catch (Exception ex) {
            System.out.println("Exception while saving employee data" + ex.getLocalizedMessage());
            return null;
        }
    }


    public static List<Employee> update(Employee e) {

        //have it output the row
        try (Connection c = getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "UPDATE employees " +
                             "SET fName=?, lName=?, gender=?, phone=?, email=?, city=?, streetAddress=?, country=?, zipCode=?, idType=?, salaryType=?, empLevel=?, workingType=?, organizationType=?, teamId=?, basePay=?, bonus=?, healthinsurance=?, contribute401k=?, totalComp=?, userName=?," +
                             " userPassword=? WHERE empId=?;");
        ) {
            statement.setString(1, e.getFName());
            statement.setString(2, e.getLName());
            //statement.setTimestamp(3, Timestamp.valueOf(e.getDob().toString().replace("T"," ")));
            statement.setString(3, String.valueOf(e.getGender()));
            statement.setString(4, e.getPhone());
            statement.setString(5, e.getEmail());
            statement.setString(6, e.getCity());
            statement.setString(7, e.getStreetAddress());
            statement.setString(8, String.valueOf(e.getCountry()));
            statement.setString(9, e.getZipCode());
            statement.setString(10, e.getIdType());
            //statement.setTimestamp(11, Timestamp.valueOf(e.getDateOfJoining().toString().replace("T"," ")));
            statement.setString(11, e.getEmpCategory().getSalaryType());
            statement.setString(12, e.getEmpCategory().getLevel());
            statement.setString(13, e.getEmpCategory().getWorkingType());
            statement.setString(14, e.getOrganization());
            statement.setString(15, e.getTeam());
            statement.setString(16, String.valueOf(e.getCompensation().getBasePay()));
            statement.setString(17, String.valueOf(e.getCompensation().getBonus()));
            statement.setString(18, String.valueOf(e.getCompensation().getHealthinsurance()));
            statement.setString(19, String.valueOf(e.getCompensation().getContribute401k()));
            statement.setString(20, String.valueOf(e.getCompensation().getTotalComp()));
            statement.setString(21, e.getUserName());
            statement.setString(22, e.getPassword());
            statement.setInt(23, Integer.parseInt(e.getEmpId()));
            statement.toString();
            int result = statement.executeUpdate();
            if (result < 0) {
                return null;
            }

            List<Employee> list = new ArrayList<>();
            list.add(e);
            return list;
        } catch (Exception ex) {
            System.out.println("Exception while updating employee data" + ex.getLocalizedMessage());
            return null;
        }
    }

    public static List<Employee> getEmployeeByName(String name) {
        try (Connection c = getConnection();
             PreparedStatement statement = c.prepareStatement("SELECT * FROM employees WHERE fName LIKE concat( '%',?,'%') or lName LIKE concat( '%',?,'%')");
        ) {
            statement.setString(1, name);
            statement.setString(2, name);
            List<Employee> list = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            list = getEmployeeObjectByResultSet(resultSet);
            return list;
        } catch (Exception ex) {
            System.out.println("Exception while fetching employee data : " + ex.getLocalizedMessage());
            return null;
        }
    }

    public static List<Employee> getAllEmployees() {
        try (Connection c = getConnection();
             PreparedStatement statement = c.prepareStatement("SELECT * FROM employees");
        ) {
            List<Employee> list = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            list = getEmployeeObjectByResultSet(resultSet);
            return list;
        } catch (Exception ex) {
            System.out.println("Exception while fetching employee data : " + ex.getLocalizedMessage());
            return null;
        }
    }

    public static List<Employee> getEmployeeByUserName(String userName) {
        try (Connection c = getConnection();
             PreparedStatement statement = c.prepareStatement("SELECT * FROM employees WHERE userName = ?");
        ) {
            statement.setString(1, userName);
            List<Employee> list = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            list = getEmployeeObjectByResultSet(resultSet);
            return list;
        } catch (Exception ex) {
            System.out.println("Exception while fetching employee data : " + ex.getLocalizedMessage());
            return null;
        }
    }

    public static List<Employee> getEmployeeById(Integer id) {
        try (Connection c = getConnection();
             PreparedStatement statement = c.prepareStatement("SELECT * FROM employees WHERE empId = ?");
        ) {
            statement.setInt(1, id);
            statement.toString();
            ResultSet resultSet = statement.executeQuery();

            return getEmployeeObjectByResultSet(resultSet);
        } catch (Exception ex) {
            System.out.println("Exception while fetching employee data" + ex.getLocalizedMessage());
            return null;
        }
    }

    public static List<Employee> getEmployeeByTeamId(Integer teamId) {
        try (Connection c = getConnection();
             PreparedStatement statement = c.prepareStatement("SELECT * FROM teams WHERE teamId = ?");
        ) {
            statement.setInt(1, teamId);
            ResultSet resultSet = statement.executeQuery();
            return getEmployeeObjectByResultSet(resultSet);
        } catch (Exception ex) {
            System.out.println("Exception while fetching employee data for team ID: "+teamId+" e:"+ ex.getLocalizedMessage());
            return null;
        }
    }

    public static boolean deleteEmployee(Integer empId) {
        try (Connection c = getConnection();
             PreparedStatement statement = c.prepareStatement("DELETE FROM employees WHERE empId = ?");
        ) {
            statement.setInt(1, empId);
            int resultSet = statement.executeUpdate();
            return resultSet > 0;
        } catch (Exception ex) {
            System.out.println("Exception while deleting employee data" + ex.getLocalizedMessage());
            return false;
        }
    }

    private static List<Employee> getEmployeeObjectByResultSet(ResultSet resultSet) throws SQLException {
        List<Employee> employees = new ArrayList<Employee>();
        while (resultSet.next()) {
            Employee emp = new Employee();
            emp.setEmpId(String.valueOf(resultSet.getInt(1)));
            emp.setFName(resultSet.getString(2));
            emp.setLName(resultSet.getString(3));
            emp.setDob(resultSet.getTimestamp(4).toLocalDateTime());
            emp.setGender(Gender.valueOf(resultSet.getString(5)));
            emp.setPhone(resultSet.getString(6));
            emp.setEmail(resultSet.getString(7));
            emp.setCity(resultSet.getString(8));
            emp.setStreetAddress(resultSet.getString(9));
            emp.setCountry(getCountryEnum(resultSet.getString(10)));
            emp.setZipCode(resultSet.getString(11));
            emp.setIdType(resultSet.getString(12));
            emp.setDateOfJoining(resultSet.getTimestamp(13).toLocalDateTime());
            emp.setEmpCategory(new EmployeeCategory(resultSet.getString(14), resultSet.getString(15),resultSet.getString(16)));
            emp.setOrganization(resultSet.getString(17));
            emp.setTeam(resultSet.getString(18));
            emp.setCompensation(new Compensation(Double.parseDouble(resultSet.getString(19)),Double.parseDouble(resultSet.getString(20)),
                    Double.parseDouble(resultSet.getString(21)),Double.parseDouble(resultSet.getString(22)), Double.parseDouble(resultSet.getString(23))));
            emp.setUserName(resultSet.getString(24));
            emp.setPassword(resultSet.getString(25));
            employees.add(emp);
        }
        return employees;
    }

}
