package com.java.models;

import java.util.Date;

public class LeaveModel {
    private int leaveId;
    private int empoId;
    private Date leaveStartDate;
    private Date leaveEndDate;
    private int noOfDays;
    private Date appliedOn;
    private String leaveReason;

    public LeaveModel(){}
    public LeaveModel(int leaveId, int empoId, Date leaveStartDate, Date leaveEndDate, int noOfDays, Date appliedOn, String leaveReason) {
        this.leaveId = leaveId;
        this.empoId = empoId;
        this.leaveStartDate = leaveStartDate;
        this.leaveEndDate = leaveEndDate;
        this.noOfDays = noOfDays;
        this.appliedOn = appliedOn;
        this.leaveReason = leaveReason;
    }

    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    public int getEmpoId() {
        return empoId;
    }

    public void setEmpoId(int empoId) {
        this.empoId = empoId;
    }

    public Date getLeaveStartDate() {
        return leaveStartDate;
    }

    public void setLeaveStartDate(Date leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public Date getLeaveEndDate() {
        return leaveEndDate;
    }

    public void setLeaveEndDate(Date leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public Date getAppliedOn() {
        return appliedOn;
    }

    public void setAppliedOn(Date appliedOn) {
        this.appliedOn = appliedOn;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }
}
