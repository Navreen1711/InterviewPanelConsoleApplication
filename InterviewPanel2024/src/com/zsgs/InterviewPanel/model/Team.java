package com.zsgs.InterviewPanel.model;

public class Team {
    private String teamName;
    private int teamId;
    private String team_Email;
    private String teamPhone;

    public String getTeamName(){
        return teamName;
    }
    public void setTeamName(String teamName){
        this.teamName=teamName;
    }

    public int getTeamId(){
        return teamId;
    }
    public void setTeamId(int teamId){
        this.teamId=teamId;
    }

    public String getTeam_Email(){
        return team_Email;
    }
    public void setTeam_Email(String team_Email){
        this.team_Email=team_Email;
    }

    public String getTeamPhone(){
        return teamPhone;
    }
    public void setTeamPhone(String teamPhone){
        this.teamPhone=teamPhone;
    }
}
