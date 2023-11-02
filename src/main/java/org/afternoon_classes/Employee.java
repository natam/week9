package org.afternoon_classes;

import java.time.LocalDateTime;

public class Employee implements Comparable, ReportInterface{
    private int id;
    private String name;
    private String department;
    private String jobTitle;
    private int managerId;
    private LocalDateTime hireDate;

    private double salary;
    public Employee(int id, String name, String department, String jobTitle, int managerId) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.jobTitle = jobTitle;
        this.managerId = managerId;
    }

    public Employee(int id, String name, String department, String jobTitle, int managerId, LocalDateTime hireDate, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.jobTitle = jobTitle;
        this.managerId = managerId;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee) {
            int result = Integer.compare(id, ((Employee) o).getId());
            if (result == 0) {
                result = name.compareTo(((Employee) o).getName());
            }
            return result;
        } else {
            return -1;
        }
    }

    public String getFieldValue(EmployeeFields fieldName){
        String value;
        switch (fieldName){
            case id -> value = String.valueOf(getId());
            case name -> value = getName();
            case department -> value=getDepartment();
            case jobTitle -> value=getJobTitle();
            case managerId -> value=String.valueOf(getManagerId());
            case hireDate -> value=getHireDate().toString();
            case salary -> value=String.valueOf(getSalary());
            default -> value = String.valueOf(getId());
        }
        return value;
    }

    @Override
    public String toString(){
        return "id: "+ id + " ,name: " + name + " ,department: "+ department + " ,job title: " + jobTitle + " ,manager id: " + managerId;
    }

    public void printReport(){
        System.out.println(this.toString());
    }
}
