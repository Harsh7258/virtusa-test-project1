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
        throw new LeaveExceptions(errStr.toString());
    }

    // READ search of leave id
    public LeaveModel searchLeaveBalay(int id){
        return leaveops.searchLeavesDalay(id);
    }

    // DELETE search and delete the leave details
    public String deleteLeaveBalay(int id){
        return leaveops.deleteLeaveDalay(id);
    }

    public String updateLeaveBalay(LeaveModel model) throws LeaveExceptions{
        if(validateLeaves(model)){
            return leaveops.updateLeaveDalay(model);
        }
        throw new LeaveExceptions(errStr.toString());
    }

    public boolean validateLeaves(LeaveModel model){
        boolean valid = true;
        Date today = new Date();
        Date yest = new Date(today.getTime() - (1000*60*60*24));

        Date start = model.getLeaveStartDate();
        Date end = model.getLeaveEndDate();

        // leaveStartDate cannot be yesterday
        if(start.equals(yest)){ // nullpointerexception
            errStr.append("Leave Start Date cannot be yesterday!!");
            valid = false;
        }
        if(end.equals(yest)){ // leaveEndDate cannot be Yesterday
            errStr.append("Leave End Date cannot be Yesterday!!");
            valid = false;
        }
        if(start.after(end)){ // leaveStartDate cannot be greater than leaveEndDate
            errStr.append("leave Start Date cannot be greater than leave End Date");
            valid = false;
        }

        if(model.getLeaveId() < 0){
            errStr.append("Leave can not be negative!!");
            valid=false;
        }
        if (model.getEmpoId() < 0){
            errStr.append("Employ can not be negative!!");
            valid=false;
        }

        return valid;
    }
}
