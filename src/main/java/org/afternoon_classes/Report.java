package org.afternoon_classes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Report {

    public static void printReport(Object obj, ReportType reportType) {
        reportType.printMessage();
        try {
            obj.getClass().getDeclaredMethod("printReport").invoke(obj);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void printReportByType(Object obj) {
        ReportType selectedReport = getReportTypeFromInput();
        selectedReport.getReport(obj);
    }

    public static ReportType getReportTypeFromInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter which type of report to print Employee/Department/Hierarchy:");
        String userInput = sc.nextLine();
        sc.close();
        return switch (userInput.toLowerCase()){
            case "employee": yield ReportType.EMPLOYEE;
            case "department": yield ReportType.DEPARTMENT;
            case "hierarchy": yield ReportType.HIERARCHY;
            default:yield null;
        };
    }

}
