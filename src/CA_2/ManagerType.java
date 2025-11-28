/*
 * CCT College Dublin
 * H.Dip in Computing - Algorithms & Constructs
 * Continuous Assessment 2 - Bank Employee Management System
 * 
 * Student: Diego Bruno Evangelista dos Santos
 * Student Number: 2025145
 * Date: November 2025
 * 
 * ManagerType.java - Enum listing valid manager types
 */
package CA_2;

/**
 * ManagerType enum - defines the three types of managers in the bank
 * Using an enum ensures only valid manager types can be selected
 * 
 * @author Diego Bruno Evangelista dos Santos
 */
public enum ManagerType {
    
    // The three manager types available in the bank
    BRANCH_MANAGER("Branch Manager"),
    DEPARTMENT_MANAGER("Department Manager"),
    REGIONAL_MANAGER("Regional Manager");
    
    private String type;
    
    /**
     * Constructor - sets the manager type name
     * @param type the display name for this manager type
     */
    ManagerType(String type) {
        this.type = type;
    }
    
    /**
     * Gets the manager type as a string
     * @return manager type name
     */
    public String getType() {
        return type;
    }
    
    /**
     * Displays all manager types as a numbered list
     * Used when user needs to pick a manager type
     */
    public static void displayTypes() {
        System.out.println("\nManager Types:");
        int i = 1;
        for (ManagerType mt : ManagerType.values()) {
            System.out.println(i + ". " + mt.getType());
            i++;
        }
    }
}