package com.zsgs.InterviewPanel.teamsetup;

import com.zsgs.InterviewPanel.login.LoginView;
import com.zsgs.InterviewPanel.managecandidates.ManageCandidateView;
import com.zsgs.InterviewPanel.model.Team;

import java.util.Scanner;

public class TeamSetupView {
    Scanner s= new Scanner(System.in);
    private TeamSetupModel teamSetupModel;
    String app="InterviewPanel";
    public TeamSetupView() throws Exception {
        teamSetupModel = new TeamSetupModel(this);
    }

    public void init() throws Exception{
        teamSetupModel.startSetup();
    }


    public void initiateSetup() throws Exception {

        System.out.println("Enter the Team Detail:");
        Team team = new Team();
        System.out.println("Enter Team Name:");
        team.setTeamName(s.next());

        System.out.println("Enter Team ID:");
        team.setTeamId(s.nextInt());

        System.out.println("Enter Team Email:");
        team.setTeam_Email(s.next());

        System.out.println("Enter Team Phone number:");
        team.setTeamPhone(s.next());
        teamSetupModel.createTeam(team);

    }
    public void showAlert(String alert) throws Exception {
        System.out.println(alert);
        initiateSetup();
    }

    public void onSetupComplete(Team team) throws Exception {
    	System.out.println("\nInterview Panel setup completed");
		System.out.println("\nCurrent Team Name - " + team.getTeamName());

        int choice=0;

        while(choice!=9){
            System.out.println("1. ADD Candidate\n2. Candidate info\n3. Candidate CheckIn" +
                    "\n4. Candidate CheckOut\n5. Status \n8. Logout\n9.Exit \n Enter your Choice:");
             choice=s.nextInt();

            switch(choice) {
            case 1:
                new ManageCandidateView().initAdd();
                break;
            case 2:
                new ManageCandidateView().initCandidateinfo();
                break;
            case 3:
                new ManageCandidateView().initCheckIn();
                break;
            case 4:
                new ManageCandidateView().initCheckOut();
                break;
                case 5:
                    new ManageCandidateView().initstatus();
                    break;
            case 8:
                System.out.println("\n-- You are logged out successfully -- \n\n");
                new LoginView().init();
                return; // Exit from the current session

            case 9:
                System.out.println("Thank for using " + app);
                break;
            default:
                System.out.println("Enter the choice between 1 to 6");
        }
        }
    }
}
