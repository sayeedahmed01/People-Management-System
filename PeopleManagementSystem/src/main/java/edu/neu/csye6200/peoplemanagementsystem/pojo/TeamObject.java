package edu.neu.csye6200.peoplemanagementsystem.pojo;

import java.util.List;

public class TeamObject implements Team, Comparable {

    private String teamOrganization;

    private Integer teamId;

    private String teamName;

    private int teamSize;

    private String teamType;

    private int managerId;

    private List<Employee> teamMembersList;



    @Override
    public String getTeamOrganization() {
        return teamOrganization;
    }

    public void setTeamOrganization(String teamOrganization) {
        this.teamOrganization = teamOrganization;
    }

    @Override
    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Override
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    @Override
    public String getTeamType() {
        return teamType;
    }

    public void setTeamType(String teamType) {
        this.teamType = teamType;
    }

    @Override
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public List<Employee> getTeamMembersList() {
        return teamMembersList;
    }

    public void setTeamMembersList(List<Employee> teamMembersList) {
        this.teamMembersList = teamMembersList;
    }

    @Override
    public int compareTo(Object o) {
        TeamObject o2 = (TeamObject) o;
        if (this.teamSize > o2.teamSize) {
            return 1;
        } else if (this.teamSize < o2.teamSize) {
            return -1;
        } else {
            return 0;
        }
    }
}
