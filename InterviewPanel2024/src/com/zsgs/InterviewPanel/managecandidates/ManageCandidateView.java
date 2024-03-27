package com.zsgs.InterviewPanel.managecandidates;

import com.zsgs.InterviewPanel.datalayer.TeamDatabase;
import com.zsgs.InterviewPanel.model.Candidate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.json.simple.parser.ParseException;

public class ManageCandidateView {
    private ManageCandidateModel manageCandidateModel;

    public ManageCandidateView() {
        manageCandidateModel = new ManageCandidateModel(this);
    }

    public void onUserAdded(Candidate candidate) throws Exception {
        System.out.println("\n------- User '" + candidate.getName() + "' added successfully ------- \n");
        checkForAddNewUser();
    }

    private void checkForAddNewUser() throws Exception {
        System.out.println("Do you want to add more users? \nType Yes/No");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();


        if (choice.equalsIgnoreCase("yes")) {
            initAdd();
        } else if (choice.equalsIgnoreCase("no")) {
            System.out.println("\n Thanks for adding users");
        } else {
            System.out.println("\nInvalid choice, Please enter valid choice.\n");
            checkForAddNewUser();
        }
    }

    public void initAdd() throws Exception {
        System.out.println("Enter the following user Details: ");
        Scanner scanner = new Scanner(System.in);
        Candidate candidate = new Candidate();
        System.out.println("\nEnter user name:");
        candidate.setCandidateName(scanner.nextLine());

        System.out.println("\nEnter user emailId:");
        candidate.setEmailID(scanner.next());

        System.out.println("\nEnter user Id:");
        candidate.setCandidateID(scanner.next());
        scanner.nextLine();

        System.out.println("\nEnter user degree:");
        candidate.setDegree(scanner.nextLine());

        System.out.println("\nEnter user year of passing:");
        candidate.setYear(scanner.next());


        manageCandidateModel.addNewCandidate(candidate);
    }
    public void initCandidateinfo() throws FileNotFoundException, IOException, ParseException{
        List<Candidate>us= new ArrayList<>();
        us= TeamDatabase.getInstance().getCandidateList();
        for(int i=0;i<us.size();i++){
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Candidate Name: "+us.get(i).getCandidateName());
            System.out.println("Candidate EmailID: "+us.get(i).getEmailID());
            System.out.println("Candidate ID: "+us.get(i).getCandidateID());
            System.out.println("Candidate Degree: "+us.get(i).getDegree());
            System.out.println("Candidate Year of Passing: "+us.get(i).getyear());
            System.out.println("---------------------------------------------------------------------");
        }

    }
    public void initCheckIn(){
        Queue<String> us= new ArrayDeque<>();
        us= TeamDatabase.getInstance().getCandidateQueue();
        System.out.println("Interview Start for: "+us.peek());
    }
    public void initCheckOut() throws FileNotFoundException, IOException, ParseException{
        Scanner s= new Scanner(System.in);

        List<Candidate>ul= new ArrayList<>();
        ul= TeamDatabase.getInstance().getCandidateList();

        Queue<String> us= new ArrayDeque<>();
        us= TeamDatabase.getInstance().getCandidateQueue();
        if(us.isEmpty()){
            System.out.println("Interview is Over");
        }
        else {
            System.out.println("Enter Feedback:");
            for(int i=0;i<ul.size();i++){
                if(ul.get(i).getCandidateName().equals(us.peek())){
                    ul.get(i).setFeedback(s.nextLine());
                }
            }
            System.out.println("Interview End for: " + us.poll());
        }
    }
    public void initstatus() throws FileNotFoundException, IOException, ParseException{
        List<Candidate>us= new ArrayList<>();
        us= TeamDatabase.getInstance().getCandidateList();
        for(int i=0;i<us.size();i++){
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Candidate Name: "+us.get(i).getCandidateName());
            System.out.println("Candidate EmailID: "+us.get(i).getEmailID());
            System.out.println("Candidate Status: "+us.get(i).getFeedback());
            System.out.println("---------------------------------------------------------------------");
        }
    }

    public void onUserExist(Candidate candidate) throws Exception {

        System.out.println("\n------- User '" + candidate.getName() + "' already exist -------\n");
        checkForAddNewUser();
    }
}
