/*
 * CCT College Dublin
 * H.Dip in Computing - Algorithms & Constructs
 * Continuous Assessment 2 - Bank Employee Management System
 * 
 * Student: Diego Bruno Evangelista dos Santos
 * Student Number: 2025145
 * Date: November 2025
 * 
 * DepartmentName.java - Enum listing valid bank departments
 */
package CA_2;

/**
 * DepartmentName enum - defines the four departments in the bank
 * Using an enum ensures only valid departments can be selected
 * 
 * @author Diego Bruno Evangelista dos Santos 
 */
public enum DepartmentName {
    
    // The four departments available in the bank
    RETAIL_BANKING("Retail Banking"),
    LOANS("Loans"),
    INVESTMENT("Investment"),
    IT("IT");
    
    private String name;
    
    /**
     * Constructor - sets the department name
     * @param name the display name for this department
     */
    DepartmentName(String name) {
        this.name = name;
    }
    
    /**
     * Gets the department name as a string
     * @return department name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Displays all departments as a numbered list
     * Used when user needs to pick a department
     */
    public static void displayDepartments() {
        System.out.println("\nDepartments:");
        int i = 1;
        for (DepartmentName dept : DepartmentName.values()) {
            System.out.println(i + ". " + dept.getName());
            i++;
        }
    }
}