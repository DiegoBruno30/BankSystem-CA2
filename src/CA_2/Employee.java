/*
 * CCT College Dublin
 * H.Dip in Computing - Algorithms & Constructs
 * Continuous Assessment 2 - Bank Employee Management System
 * 
 * Student: Diego Bruno Evangelista dos Santos
 * Student Number: 2025145
 * Date: November 2025
 * 
 * Employee.java - Main class representing bank employees
 */
package CA_2;

/**
 * Employee class - represents an employee in the bank
 * This is the main data class used throughout the system
 * 
 * @author Diego Bruno Evangelista dos Santos
 */
public class Employee {
    
    // Employee information
    private int id;
    private String name;
    private String managerType;  // Type of manager they report to
    private String department;   // Department they work in
    
    /**
     * Creates a new employee with the given details
     * 
     * @param id Employee ID number
     * @param name Employee's full name
     * @param managerType Type of manager (Branch, Department, or Regional)
     * @param department Department name (Retail Banking, Loans, Investment, or IT)
     */
    public Employee(int id, String name, String managerType, String department) {
        this.id = id;
        this.name = name;
        this.managerType = managerType;
        this.department = department;
    }
    
    /**
     * Gets the employee ID
     * @return employee ID
     */
    public int getId() {
        return id;
    }
    
    /**
     * Gets the employee name
     * @return employee name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the manager type
     * @return manager type
     */
    public String getManagerType() {
        return managerType;
    }
    
    /**
     * Gets the department name
     * @return department
     */
    public String getDepartment() {
        return department;
    }
    
    /**
     * Changes the employee name
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Changes the manager type
     * @param managerType new manager type
     */
    public void setManagerType(String managerType) {
        this.managerType = managerType;
    }
    
    /**
     * Changes the department
     * @param department new department
     */
    public void setDepartment(String department) {
        this.department = department;
    }
    
    /**
     * Returns employee info as a formatted string
     * Used when displaying employee details
     * @return string with all employee information
     */
    @Override
    public String toString() {
        return "Employee ID: " + id + " | Name: " + name + 
               " | Manager: " + managerType + " | Dept: " + department;
    }
}