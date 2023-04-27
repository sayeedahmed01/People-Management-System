package edu.neu.csye6200.peoplemanagementsystem.pojo;

import java.util.List;

public interface Team {
    String getTeamOrganization();

    Integer getTeamId();

    String getTeamName();

    int getTeamSize();

    String getTeamType();

    int getManagerId();

    List<Employee> getTeamMembersList();
}
