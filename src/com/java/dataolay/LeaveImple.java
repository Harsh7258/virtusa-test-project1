package com.java.dataolay;

import com.java.models.LeaveModel;

import java.util.ArrayList;
import java.util.List;

public class LeaveImple implements LeaveOps{

    // static - to access the old when created
    static List<LeaveModel> leavesList;
    static{
        leavesList = new ArrayList<LeaveModel>();
    }

    @Override
    public List<LeaveModel> showAllLeavesDalay() {
        return leavesList;
    }

    @Override
    public String addLeaveDalay(LeaveModel leaves) {
        leavesList.add(leaves);
        return "200 Leave created successfully";
    }

    @Override
    public LeaveModel searchLeavesDalay(int id) {
        // filtering the leaveId
        LeaveModel leaveFnd = leavesList.stream()
                .filter(v -> v.getLeaveId() == id)
                .findAny().orElse(null);
        return leaveFnd;
    }

    @Override
    public String deleteLeaveDalay(int id) {
        LeaveModel voter = searchLeavesDalay(id);
        if(voter != null){
            leavesList.remove(id);
            return "Deleted leave details successfully!!";
        } else {
            return "No leave found!!";
        }
    }

    @Override
    public String updateLeaveDalay(LeaveModel model) {
        LeaveModel leave = searchLeavesDalay(model.getLeaveId());
        if(leave != null){
            leave.setLeaveId(model.getLeaveId());
            leave.setEmpoId(model.getEmpoId());
            leave.setLeaveStartDate(model.getLeaveStartDate());
            leave.setLeaveEndDate(model.getLeaveEndDate());
            leave.setNoOfDays(model.getNoOfDays());
            leave.setAppliedOn(model.getAppliedOn());
            leave.setLeaveReason(model.getLeaveReason());
            return "Leave details updated successfully!!";
        } else {
            return "Leave id not found!!";
        }
    }
}
