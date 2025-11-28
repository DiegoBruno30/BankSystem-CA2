/*
 * CCT College Dublin
 * H.Dip in Computing - Algorithms & Constructs
 * Continuous Assessment 2 - Bank Employee Management System
 * 
 * Student: Diego Bruno Evangelista dos Santos
 * Student Number: 2025145
 * Date: November 2025
 * 
 * Manager.java - Represents bank managers
 */
package CA_2;

/**
 * Manager class - represents a manager in the bank
 * Each manager has an ID, name, and role type
 * 
 * @author Diego Bruno Evangelista dos Santos
 */
public class Manager {
    
    // Manager information
    private int id;
    private String name;
    private String role;  // Type of manager (Branch, Department, or Regional)
    
    /**
     * Creates a new manager with the given details
     * 
     * @param id Manager ID number
     * @param name Manager's full name
     * @param role Manager type (Branch Manager, Department Manager, or Regional Manager)
     */
    public Manager(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }
    
    /**
     * Gets the manager ID
     * @return manager ID
     */
    public int getId() {
        return id;
    }
    
    /**
     * Gets the manager name
     * @return manager name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the manager role type
     * @return role (e.g., "Branch Manager")
     */
    public String getRole() {
        return role;
    }
    
    /**
     * Changes the manager name
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Changes the manager role
     * @param role new role type
     */
    public void setRole(String role) {
        this.role = role;
    }
    
    /**
     * Returns manager info as a formatted string
     * @return string with manager details
     */
    @Override
    public String toString() {
        return "Manager ID: " + id + " | Name: " + name + " | Role: " + role;
    }
}