package com.zsgs.InterviewPanel.model;

public class Candidate {
    private String candidateName;
    private String candidateID;
    private String email;
    private String degree;
    private String year;
    private String PhoneNo;
    private String feedback;

    public String getDegree(){
        return degree;
    }
    public void setDegree(String s1){
        degree=s1;
    }

    public String getyear(){
        return year;
    }
    public void setYear(String s1){
        year=s1;
    }

    public String getFeedback(){
        return feedback;
    }
    public void setFeedback(String s1){
        feedback=s1;
    }

    public String getCandidateName(){
        return candidateName;
    }
    public void setCandidateName(String s1){
        candidateName=s1;
    }

    public String getCandidateID(){
        return candidateID;
    }
    public void setCandidateID(String s1){
        candidateID=s1;
    }
    public String getEmailID(){
        return email;
    }
    public void setEmailID(String s1){
        email=s1;
    }
    public String getPhoneNo(){
        return PhoneNo;
    }
    public void setPhoneNo(String s1){
        PhoneNo=s1;
    }

    public String getEmailId() {
        return email;
    }

    public String getName() {
        return candidateName;
    }
}
