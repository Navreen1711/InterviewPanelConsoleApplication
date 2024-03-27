package com.zsgs.InterviewPanel.datalayer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import com.zsgs.InterviewPanel.model.Candidate;
import com.zsgs.InterviewPanel.model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TeamDatabase {
    private Team team;
    private static TeamDatabase teamDatabase;
    private List<Candidate> candidateList = new ArrayList();
    private Queue<String> candidateQueue= new ArrayDeque<>();
    
    void saveCandidate() throws Exception {
    	JSONArray js= new JSONArray();
    	for(int i=0;i<candidateList.size();i++) {
    		JSONObject jObj= new JSONObject();
    		jObj.put("Candidate Name", candidateList.get(i).getCandidateName());
    		jObj.put("Candidate Email", candidateList.get(i).getEmailId());
    		jObj.put("Candidate Degree", candidateList.get(i).getDegree());
    		jObj.put("Candidate ID", candidateList.get(i).getCandidateID());
    		jObj.put("Candidate Year", candidateList.get(i).getyear());
    		js.add(jObj);
    	}
    	FileWriter file= new FileWriter("JSONCandidate.json");
    	file.write(js.toJSONString());
    	file.close();
    }
    List<Candidate> readCandidate() throws FileNotFoundException, IOException, ParseException {
    	List<Candidate>list= new ArrayList<Candidate>();
    	File f= new File("JSONCandidate.json");
    	if(!f.exists() || f.length()==0) {
    		return list;
    	}
    	JSONParser parser= new JSONParser();
		JSONArray jArray= (JSONArray) parser.parse(new FileReader("JSONCandidate.json"));
		
		for(Object obj: jArray) {
			JSONObject jObj= (JSONObject)obj;
			String name=(String) jObj.get("Candidate Name");
			String email=(String) jObj.get("Candidate Email");
			String degree= (String) jObj.get("Candidate Degree");
			String id=(String) jObj.get("Candidate ID");
			String year=(String) jObj.get("Candidate Year");
    		
			Candidate c = new Candidate();
    		c.setCandidateID(id);
    		c.setCandidateName(name);
    		c.setDegree(degree);
    		c.setEmailID(email);
    		c.setYear(year);
    		
    		list.add(c);
    	}
    	return list;
    	
    }

    public static TeamDatabase getInstance(){
        if(teamDatabase == null){
            teamDatabase = new TeamDatabase();
        }
        return teamDatabase;
    }
    public List<Candidate> getCandidateList() throws FileNotFoundException, IOException, ParseException{
        
    	return candidateList;
    }

    public Queue<String> getCandidateQueue(){
        return candidateQueue;
    }
    public Team getTeam() throws Exception {
    	candidateList=readCandidate();
        return team;  // SQL query and it's result here.
    }


    public Team insertTeam(Team team) {
        this.team = team;
        return  team;

    }
    static int i=0;
    public boolean insertUser(Candidate candidate) throws Exception {
        boolean hasUser = false;
        for (Candidate addedcandidate : candidateList) {
            if (addedcandidate.getEmailId().equals(candidate.getEmailId())) {
                hasUser = true;
                break;
            }
        }
        if (hasUser) {
            return false;
        } else {
        	
            candidateList.add(candidate);
            candidateQueue.add(candidateList.get(i++).getCandidateName());
            saveCandidate();
            return true;
        }
    }
}
