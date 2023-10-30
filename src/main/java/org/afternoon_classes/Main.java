package org.afternoon_classes;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Employees myEmployees = new Employees();
        try {
            myEmployees.createAndAddEmployee(1, "Natallia", "IT", "CTO", 0);
            myEmployees.createAndAddEmployee(2, "Nina", "HR", "Recruiter", 0);
            myEmployees.createAndAddEmployee(3, "Nadine", "IT", "Developer", 1);
            myEmployees.createAndAddEmployee(3, "Nadine", "IT", "Developer", 1);
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Search in set managerId=1");
        System.out.println(myEmployees.searchInSet(EmployeeFields.managerId, String.valueOf(1)).toString());
        System.out.println("Filer by departament = IT");
        myEmployees.filterEmployees(EmployeeFields.department, "IT").forEach(employee -> System.out.println(employee.toString()));
        myEmployees.updateEmployeeInMap(3, "", "", "Backend Engineer", 0);
        System.out.println("Get employee after update id = 3");
        System.out.println(myEmployees.getEmployeeFromMapById(3).toString());
        myEmployees.deleteEmployeeFromMap(1);
        System.out.println("");
        myEmployees.printReport("report.txt");
    }
}
