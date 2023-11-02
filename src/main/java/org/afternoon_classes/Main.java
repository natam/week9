package org.afternoon_classes;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employees myEmployees = new Employees();
        Employee employee1 = new Employee(1, "Dmitry", "", "CO", 0);
        try {
            myEmployees.addEmployeeToMap(employee1);
            myEmployees.addEmployeeToSet(employee1);
            myEmployees.createAndAddEmployee(2, "Natallia", "IT", "CTO", 1);
            myEmployees.createAndAddEmployee(3, "Nina", "HR", "Director HR", 1);
            myEmployees.createAndAddEmployee(4, "Jon", "IT", "Engineering Manager", 2);
            myEmployees.createAndAddEmployee(5, "Nadine", "IT", "Developer", 4);
            myEmployees.createAndAddEmployee(6, "Jane", "IT", "Developer", 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
//        System.out.println("Search in set managerId=1");
//        System.out.println(myEmployees.searchInSet(EmployeeFields.managerId, String.valueOf(1)).toString());
//        System.out.println("Filer by departament = IT");
//        myEmployees.filterEmployees(EmployeeFields.department, "IT").forEach(employee -> System.out.println(employee.toString()));
//        myEmployees.updateEmployeeInMap(3, "", "", "Backend Engineer", 0);
//        System.out.println("Get employee after update id = 3");
//        System.out.println(myEmployees.getEmployeeFromMapById(3).toString());
//        //myEmployees.deleteEmployeeFromMap(1);
//        System.out.println("");
//        myEmployees.printReport("report.txt");

        CompanyHierarchy hierarchy = new CompanyHierarchy();
        try {
            for (Employee employee : myEmployees.getEmployeesMap().values()) {
                hierarchy.addNode(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            TreeNode commonParent = hierarchy.getLowestCommonParent(myEmployees.getEmployeeFromMapById(6), myEmployees.getEmployeeFromMapById(5));
            if(commonParent!=null){
                System.out.println("COMMON MANAGER: " + commonParent.getEmployee().getName());
            }else {
                System.out.println("NO COMMON MANAGER");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Report.printReport(employee1, ReportType.EMPLOYEE);
        Report.printReportByType(hierarchy);
    }
}
