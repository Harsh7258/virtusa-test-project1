package com.java.dataolay;

import com.java.models.LeaveModel;

import java.util.List;

public interface LeaveOps {
    List<LeaveModel> showAllLeavesDalay();
    String addLeaveDalay(LeaveModel leaves);
}
