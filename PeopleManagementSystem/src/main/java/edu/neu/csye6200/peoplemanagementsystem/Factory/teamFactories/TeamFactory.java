package edu.neu.csye6200.peoplemanagementsystem.Factory.teamFactories;

import edu.neu.csye6200.peoplemanagementsystem.pojo.Team;
import edu.neu.csye6200.peoplemanagementsystem.pojo.TeamObject;

public class TeamFactory implements BaseFactory {

    private TeamFactory teamFactory = new TeamFactory();

    private TeamFactory() {}

    @Override
    public Team getObject() {
        return new TeamObject();
    }

    public TeamFactory getInstance() {
        return teamFactory;
    }
}
