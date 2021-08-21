package com.example.ganesh.cloning;

public class Employee implements Cloneable {

    private int employeeId;
    private String employeeName;
    private Department department;

    public Employee(int id, String name, Department dept) {
        this.employeeId = id;
        this.employeeName = name;
        this.department = dept;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();
        if (cloned.getDepartment() != null && cloned.getDepartment() instanceof Cloneable) {
            cloned.setDepartment((Department) cloned.getDepartment().clone());
        } else {
            cloned.setDepartment(new Department(-1, "default"));
        }
        return cloned;
    }


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
