package edu.neu.csye6200.peoplemanagementsystem.services;

import edu.neu.csye6200.peoplemanagementsystem.dao.EmployeeDao;
import edu.neu.csye6200.peoplemanagementsystem.dao.TeamDao;
import edu.neu.csye6200.peoplemanagementsystem.pojo.Employee;
import edu.neu.csye6200.peoplemanagementsystem.pojo.Team;
import edu.neu.csye6200.peoplemanagementsystem.pojo.TeamObject;

import java.util.ArrayList;
import java.util.List;

public class TeamService {

    public TeamObject getTeamData(Integer teamId) {
        try {
            List<TeamObject> teamList = TeamDao.getTeamById(teamId);
            return teamList.get(0);
        } catch (Exception e) {
            System.out.println("Exception while fetching Team" + e);
            return new TeamObject();
        }
    }

    public List<Employee> getTeamMembers(Integer teamId) {
        try {
            List<Employee> list = EmployeeDao.getEmployeeByTeamId(teamId);
            return list;
        } catch (Exception e) {
            System.out.println("Exception while fetching Team members" + e);
            return new ArrayList<>();
        }
    }

    public Boolean terminateTeam(String teamId){
        try {
            return TeamDao.deleteTeam(Integer.parseInt(teamId));
        } catch (Exception e) {
            System.out.println("Error while terminating team " + e);
            return false;
        }
    }




}
