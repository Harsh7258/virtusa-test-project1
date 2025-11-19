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
}
