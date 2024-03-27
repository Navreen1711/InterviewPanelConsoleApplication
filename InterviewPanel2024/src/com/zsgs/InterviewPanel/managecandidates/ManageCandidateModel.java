package com.zsgs.InterviewPanel.managecandidates;

import com.zsgs.InterviewPanel.datalayer.TeamDatabase;
import com.zsgs.InterviewPanel.model.Candidate;

public class ManageCandidateModel {
    private ManageCandidateView manageCandidateView;
    ManageCandidateModel(ManageCandidateView manageCandidateView) {

        this.manageCandidateView = manageCandidateView;
    }
    public void addNewCandidate(Candidate candidate) throws Exception{
        if (TeamDatabase.getInstance().insertUser(candidate)) {
            manageCandidateView.onUserAdded(candidate);
        } else {
            manageCandidateView.onUserExist(candidate);
        }
    }

}
