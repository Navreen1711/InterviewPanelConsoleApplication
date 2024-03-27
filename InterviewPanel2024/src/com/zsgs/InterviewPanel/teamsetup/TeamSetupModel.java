package com.zsgs.InterviewPanel.teamsetup;

import com.zsgs.InterviewPanel.datalayer.TeamDatabase;
import com.zsgs.InterviewPanel.model.Team;

public class TeamSetupModel {

    private TeamSetupView teamSetupView;
    private Team team;
    TeamSetupModel(TeamSetupView teamSetupView) throws Exception {
        this.teamSetupView = teamSetupView;
        team = TeamDatabase.getInstance().getTeam();
    }




    public void startSetup() throws Exception{
        if(team ==null || team.getTeamId()==0){
            teamSetupView.initiateSetup();
        }
        else{
            teamSetupView.onSetupComplete(team);
        }
    }
    public void createTeam(Team team) throws Exception{
        if(team.getTeamName().length()<3 || team.getTeamName().length()>50){
            teamSetupView.showAlert("Enter the valid Name");
            return;
        }
        this.team = TeamDatabase.getInstance().insertTeam(team); // To insert query
        teamSetupView.onSetupComplete(team);

    }
}
