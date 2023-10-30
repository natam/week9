package org.afternoon_classes;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Employees {
    private HashSet<Employee> employeesSet = new HashSet<>();
    private HashMap<Integer, Employee> employeesMap = new HashMap<>();


    public void addEmployeeToSet(Employee employee) {
        employeesSet.add(employee);
    }

    public Employee searchInSet(EmployeeFields searchField, String value) {
        for (Employee employee : employeesSet) {
            if (employee.getFieldValue(searchField).equalsIgnoreCase(value)) {
                return employee;
            }
        }
        return null;
    }

    public void addEmployeeToMap(Employee employee) {
        employeesMap.putIfAbsent(employee.getId(), employee);
    }

    public void createAndAddEmployee(int id, String name, String department, String jobTitle, int managerId) throws Exception {
        if (employeesMap.containsKey(id)) {
            throw new Exception("Employee with id " + id + " already exists in system");
        } else {
            Employee newEmployee = new Employee(id, name, department, jobTitle, managerId);
            employeesMap.put(id, new Employee(id, name, department, jobTitle, managerId));
            employeesSet.add(newEmployee);
        }
    }

    public Employee getEmployeeFromMapById(int employeeId) {
        return employeesMap.get(employeeId);
    }

    public void updateEmployeeInMap(Employee employee) throws Exception {
        if (employeesMap.containsKey(employee.getId())) {
            employeesMap.replace(employee.getId(), employee);
        } else {
            throw new Exception("Employee not exists in system");
        }
    }

    public void updateEmployeeInMap(int employeeId, String newName, String newDepartment, String newJobTitle, int newManagerId) {
        if (employeesMap.containsKey(employeeId)) {
            Employee employeeToUpdate = getEmployeeFromMapById(employeeId);
            if (!newName.isEmpty()) {
                employeeToUpdate.setName(newName);
            }
            if (!newDepartment.isEmpty()) {
                employeeToUpdate.setDepartment(newDepartment);
            }
            if (!newJobTitle.isEmpty()) {
                employeeToUpdate.setJobTitle(newJobTitle);
            }
            if (newManagerId > 0) {
                employeeToUpdate.setManagerId(newManagerId);
            }
        }
    }

    public void deleteEmployeeFromMap(int employeeId) {
        employeesMap.remove(employeeId);
    }

    public List<Employee> filterEmployees(EmployeeFields filterField, String query) {
        return employeesMap
                .values()
                .stream()
                .filter(employee -> employee.getFieldValue(filterField).equalsIgnoreCase(query))
                .toList();
    }

    public void printReport(String file) {
        StringBuilder report = new StringBuilder();
        report
                .append("Report ")
                .append(LocalDateTime.now())
                .append(System.lineSeparator())
                .append("Employees number: ")
                .append(employeesMap.size())
                .append(System.lineSeparator())
                .append("Employees by department")
                .append(System.lineSeparator());
        employeesMap
                .values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .forEach((key, value) -> report.append(key).append(" - ").append(value).append(System.lineSeparator()));
        System.out.println(report.toString());
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(report.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
