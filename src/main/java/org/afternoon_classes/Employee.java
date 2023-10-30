package org.afternoon_classes;

public class Employee implements Comparable {
    private int id;
    private String name;
    private String department;
    private String jobTitle;
    private int managerId;

    public Employee(int id, String name, String department, String jobTitle, int managerId) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.jobTitle = jobTitle;
        this.managerId = managerId;
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
            default -> value = String.valueOf(getId());
        }
        return value;
    }

    @Override
    public String toString(){
        return "id: "+ id + " ,name: " + name + " ,department: "+ department + " ,job title: " + jobTitle + " ,manager id: " + managerId;
    }
}
