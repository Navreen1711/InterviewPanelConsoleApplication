package com.zsgs.InterviewPanel.login;

import com.zsgs.InterviewPanel.teamsetup.TeamSetupView;

import java.sql.SQLOutput;
import java.util.Scanner;

public class LoginView {
    private LoginModel loginModel;
    public LoginView() {
        loginModel = new LoginModel(this);
    }


    public void init() throws Exception{
        System.out.println("\n\nPlease login to proceed.");
        proceedLogin();
    }

    public void proceedLogin() throws Exception{
        Scanner s= new Scanner(System.in);
        loginModel.getVariable();
        System.out.println("Enter UserName:");
        String username= s.next();
        System.out.println("Enter Password:");
        String password=s.next();

        loginModel.isValid(username,password);
    }

    public void onSuccess() throws Exception {
        System.out.println("Login Successfully");
        TeamSetupView librarySetupView = new TeamSetupView();
        librarySetupView.init();
    }
}
