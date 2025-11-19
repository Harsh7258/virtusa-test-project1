package com.java.baolay;

import com.java.dataolay.LeaveImple;
import com.java.dataolay.LeaveOps;
import com.java.exceptionsHan.LeaveExceptions;
import com.java.models.LeaveModel;

import java.util.Date;
import java.util.List;

public class LeaveOpsBalay {
    static StringBuilder errStr;
    static LeaveOps leaveops;

    static {
        errStr = new StringBuilder();
        leaveops = new LeaveImple(); // passing to implementation
    }

    // READ all
    public List<LeaveModel> showAllLeaves(){
        return leaveops.showAllLeavesDalay();
    }

    // CREATE create/add
    public String addLeavesBalay(LeaveModel model) throws LeaveExceptions{
        if(validateLeaves(model)){
            return leaveops.addLeaveDalay(model);
        }
        throw new LeaveExceptions("Leave cannot be created for validation reasons!");
    }

    public boolean validateLeaves(LeaveModel model){
        boolean valid = true;
        Date today = new Date();
        Date yest = new Date(today.getTime() - (24*60*60*1000));

        Date start = model.getLeaveStartDate();
        Date end = model.getLeaveEndDate();

        // leaveStartDate cannot be yesterday
        if(start.equals(yest)){ // nullpointerexception
            valid = false;
        }
        if(end.equals(yest)){ // leaveEndDate cannot be Yesterday
            valid = false;
        }
        if(start.after(yest)){ // leaveStartDate cannot be greater than leaveEndDate
            valid = false;
        }

        return valid;
    }
}
