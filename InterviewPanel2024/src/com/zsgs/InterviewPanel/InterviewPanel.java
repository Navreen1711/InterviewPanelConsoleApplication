package com.zsgs.InterviewPanel;
import com.zsgs.InterviewPanel.login.LoginView;

public class InterviewPanel {
    private String appName="Interview Panel Management";

    private String version="0.1.0";
    private static InterviewPanel interviewpanel;

    public static InterviewPanel getInstance(){
        if(interviewpanel == null){
            interviewpanel = new InterviewPanel();
        }
        return interviewpanel;
    }

    private void create() throws Exception{
        LoginView loginView= new LoginView();
        loginView.init();
    }

    public static void main(String[] args) throws Exception {
        InterviewPanel.getInstance().create();
    }
    public String getAppName() {
        return appName;
    }

}
