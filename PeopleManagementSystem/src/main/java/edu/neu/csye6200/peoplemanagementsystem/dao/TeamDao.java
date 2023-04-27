package edu.neu.csye6200.peoplemanagementsystem.dao;

import edu.neu.csye6200.peoplemanagementsystem.pojo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static edu.neu.csye6200.peoplemanagementsystem.pojo.CountryEnum.getCountryEnum;

public class TeamDao extends Dao {


    public static List<Team> save(TeamObject team) {

        //have it output the row
        try (Connection c = getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "INSERT INTO teams (team_organization, team_name, managerId, team_size, team_type) VALUES(?, ?, ?, ?, ?);");
        ) {
            statement.setString(1, team.getTeamOrganization());
            statement.setString(2, team.getTeamName());
            statement.setInt(3, team.getManagerId());
            statement.setInt(4, team.getTeamSize());
            statement.setString(5, team.getTeamType());

            int result = statement.executeUpdate();
            boolean res = result > 0 ? true : false;

            //logic to have it output the saved record
            PreparedStatement displayStmt = c.prepareStatement("SELECT * FROM teams WHERE team_id = (SELECT Max(team_id) from teams)");
            List<Team> list = new ArrayList<>();
            ResultSet resultSet = displayStmt.executeQuery();
            int i = 0;
            while (resultSet.next()) {
                TeamObject teamObject = new TeamObject();
                teamObject.setTeamId(resultSet.getInt(1));
                teamObject.setTeamOrganization(resultSet.getString(2));
                teamObject.setTeamName(resultSet.getString(3));
                teamObject.setManagerId(resultSet.getInt(4));
                teamObject.setTeamSize(resultSet.getInt(5));
                teamObject.setTeamType(resultSet.getString(6));
                list.add(teamObject);
            }
            return list;
        } catch (Exception ex) {
            System.out.println("Exception while saving employee data" + ex.getLocalizedMessage());
            return null;
        }
    }


    public static List<TeamObject> getTeamByName(String name) {
        try (Connection c = getConnection();
             PreparedStatement statement = c.prepareStatement("SELECT * FROM teams WHERE team_name like concat( '%',?,'%')");
        ) {
            statement.setString(1, "%"+name+"%");
            List<TeamObject> list = new ArrayList<>();
            //statement.setString();
            statement.toString();
            ResultSet resultSet = statement.executeQuery();
            return getTeamObjectByResultSet(resultSet);
        } catch (Exception ex) {
            System.out.println("exception while fetching team by team Name" + ex.getLocalizedMessage());
            return null;
        }
    }

    public static List<TeamObject> getTeamByType(String type) {
        try (Connection c = getConnection();
             PreparedStatement statement = c.prepareStatement("SELECT * FROM teams WHERE team_type like concat( '%',?,'%')");
        ) {
            statement.setString(1, "%"+type+"%");
            List<TeamObject> list = new ArrayList<>();
            //statement.setString();
            statement.toString();
            ResultSet resultSet = statement.executeQuery();
            return getTeamObjectByResultSet(resultSet);
        } catch (Exception ex) {
            System.out.println("Exception while fetching team by team type" + ex.getLocalizedMessage());
            return null;
        }
    }

    public static List<TeamObject> getTeamById(Integer id) {
        try (Connection c = getConnection();
             PreparedStatement statement = c.prepareStatement("SELECT * FROM teams WHERE team_id = ?");
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return getTeamObjectByResultSet(resultSet);
        } catch (Exception ex) {
            System.out.println("Exception while fetching employee data" + ex.getLocalizedMessage());
            return null;
        }
    }

    public static List<TeamObject> getAllTeams() {
        try (Connection c = getConnection();
             PreparedStatement statement = c.prepareStatement("SELECT * FROM teams");
        ) {
            ResultSet resultSet = statement.executeQuery();
            return getTeamObjectByResultSet(resultSet);
        } catch (Exception ex) {
            System.out.println("Exception while fetching employee data" + ex.getLocalizedMessage());
            return null;
        }
    }

    private static List<TeamObject> getTeamObjectByResultSet(ResultSet resultSet) throws SQLException {
        List<TeamObject> teams = new ArrayList<TeamObject>();
        while (resultSet.next()) {
            TeamObject teamObject = new TeamObject();
            teamObject.setTeamId(resultSet.getInt(1));
            teamObject.setTeamOrganization(resultSet.getString(2));
            teamObject.setTeamName(resultSet.getString(3));
            teamObject.setManagerId(resultSet.getInt(4));
            teamObject.setTeamSize(resultSet.getInt(5));
            teamObject.setTeamType(resultSet.getString(6));
            teams.add(teamObject);
        }
        return teams;
    }

    public static boolean deleteTeam(Integer teamId) {
        try (Connection c = getConnection();
             PreparedStatement statement = c.prepareStatement("DELETE FROM teams WHERE team_id = ?");
        ) {
            statement.setInt(1, teamId);
            int resultSet = statement.executeUpdate();
            return resultSet > 0;
        } catch (Exception ex) {
            System.out.println("Exception while fetching employee data" + ex.getLocalizedMessage());
            return false;
        }
    }
}
