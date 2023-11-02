package org.afternoon_classes;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Report {

    public static void printReport(ReportInterface obj, ReportType reportType) {
        reportType.printMessage();
        try {
            obj.getClass().getDeclaredMethod("printReport").invoke(obj);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void printReportByType(ReportInterface obj) {
        try {
            ReportType selectedReport = getReportType(getUserInput());
            selectedReport.getReport(obj);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static ReportType getReportType(String userInput) throws Exception {
        return switch (userInput.toLowerCase()){
            case "employee": yield ReportType.EMPLOYEE;
            case "department": yield ReportType.DEPARTMENT;
            case "hierarchy": yield ReportType.HIERARCHY;
            default: throw new Exception("Report type is not valid.");
        };
    }

    public static String getUserInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter which type of report to print Employee/Department/Hierarchy:");
        String userInput = sc.nextLine();
        sc.close();
        return userInput;
    }
}
