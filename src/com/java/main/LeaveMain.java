package com.java.main;

import com.java.baolay.LeaveOpsBalay;
import com.java.exceptionsHan.LeaveExceptions;
import com.java.models.LeaveModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LeaveMain {
    static LeaveOpsBalay leavebalay;
    static {
        leavebalay = new LeaveOpsBalay();
    }

    // String input conversion to Date
    public static Date toDate(String input) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return date.parse(input);
        } catch (ParseException e) {
            System.err.println("Invalid date!!");
            return null; // return null if invalid
        }
    }

    // number of days that applied for
    public static int getDays(Date s, Date e){
        long diffInMs = e.getTime() - s.getTime(); // milliseconds difference
        long days = diffInMs / (1000 * 60 * 60 * 24);
        return (int) days;
    }

    public static void addLeavesDe(){
        Scanner sc = new Scanner(System.in);
        LeaveModel model = new LeaveModel();
        System.out.println("Enter leaveId: ");
        model.setLeaveId(sc.nextInt());
        System.out.println("Enter employ ID: ");
        model.setEmpoId(sc.nextInt());
        System.out.println("Enter leave start date (yyyy-MM-dd): ");
        model.setLeaveStartDate(toDate(sc.nextLine()));
        System.out.println("Enter leave end date (yyyy-MM-dd): ");
        model.setLeaveEndDate(toDate(sc.nextLine()));

        Date s = model.getLeaveStartDate();
        Date e = model.getLeaveEndDate();
        model.setNoOfDays(getDays(s,e));
        System.out.println("Leave applied for: "+ model.getNoOfDays());

        model.setAppliedOn(new Date()); // automatic today's date
        System.out.println("Applied on this date: "+model.getAppliedOn());

        System.out.println("Enter the reason for leave: ");
        model.setLeaveReason(sc.nextLine());

        System.out.println(leavebalay.addLeavesBalay(model));
    }
    public static void showAllLeavesDe(){
        List<LeaveModel> list = new ArrayList<LeaveModel>();
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Leave details options: ");
            System.out.println("1. Add Leave");
            System.out.println("2. Show Leave details");
//            System.out.println("3. Search Leave details");
//            System.out.println("4. Delete Leave details");
//            System.out.println("5. Update Leave details");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");
            num = sc.nextInt();
            switch(num) {
                case 1 :
                    try {
                        addLeavesDe();
                    } catch (LeaveExceptions | InputMismatchException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2 :
                    showAllLeavesDe();
                    break;
            }
        } while(num != 6);
    }
}
