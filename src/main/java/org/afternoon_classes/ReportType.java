package org.afternoon_classes;

import java.lang.reflect.InvocationTargetException;

public enum ReportType {
    EMPLOYEE("Employee report"),
    DEPARTMENT("Report by Department"),
    HIERARCHY("Company Hierarchy");
    private String message;
    ReportType(String message){
        this.message=message;
    }

    public void printMessage(){
        System.out.println(message);
    }

    void getReport(Object object){
        printMessage();
        try {
            object.getClass().getDeclaredMethod("printReport").invoke(object);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    };
}
