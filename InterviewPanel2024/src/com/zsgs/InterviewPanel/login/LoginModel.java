package com.zsgs.InterviewPanel.login;

import java.util.Scanner;

public class LoginModel {

    private String appName="Interview Panel Management";

    private String version="0.1.0";
    private LoginView loginview;
    LoginModel(LoginView loginview) {
        this.loginview = loginview;
    }

    public void getVariable(){
        System.out.println("Application: "+appName+"\n"+"Version: "+version);
    }
    public void isValid(String username,String password) throws Exception{
        if(username.equals("admin")){
            if(password.equals("admin123")){
                //System.out.println("Login Successfully");
                loginview.onSuccess();

            }
            else {
                alertMsg("Invalid Password");
            }
        }else{
            alertMsg("Invalid UserName");
        }

    }
    private void alertMsg(String s1) throws Exception{
        System.out.println(s1);
        tryagain();
    }
    public void tryagain() throws Exception{
        Scanner s= new Scanner(System.in);
        System.out.println("You want to try Again Enter yes or no:");
        String str=s.next();

        if(str.equalsIgnoreCase("yes")){
            loginview.proceedLogin();
        }
        else if(str.equalsIgnoreCase("no")){
            System.out.println("Thank you");
        }
        else{
            tryagain();
        }


    }

}
