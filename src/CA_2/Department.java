/*
 * CCT College Dublin
 * H.Dip in Computing - Algorithms & Constructs
 * Continuous Assessment 2 - Bank Employee Management System
 * 
 * Student: Diego Bruno Evcangelista dos Santos
 * Student Number: 2025145
 * Date: November 2025
 * 
 * Department.java - Stores information about bank departments
 */
package CA_2;

/**
 * Department class - represents a department in the bank
 * Each department has an ID, name, and location
 * 
 * @author Diego Bruno Evangelista dos Santos
 */
public class Department {
    
    // Department info
    private int id;
    private String name;
    private String location;
    
    /**
     * Creates a new department with the given details
     * 
     * @param id Department ID number
     * @param name Department name (e.g., "Retail Banking")
     * @param location Physical location of the department
     */
    public Department(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
    
    /**
     * Gets the department ID
     * @return department ID
     */
    public int getId() {
        return id;
    }
    
    /**
     * Gets the department name
     * @return department name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the department location
     * @return location
     */
    public String getLocation() {
        return location;
    }
    
    /**
     * Changes the department name
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Changes the department location
     * @param location new location
     */
    public void setLocation(String location) {
        this.location = location;
    }
    
    /**
     * Returns department info as a formatted string
     * @return string with department details
     */
    @Override
    public String toString() {
        return "Department ID: " + id + " | Name: " + name + " | Location: " + location;
    }
}