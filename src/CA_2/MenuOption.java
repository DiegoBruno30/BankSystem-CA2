/*
 * CCT College Dublin
 * H.Dip in Computing - Algorithms & Constructs
 * Continuous Assessment 2 - Bank Employee Management System
 * 
 * Student: Diego Bruno Evangelista dos Santos
 * Student Number: 2025145
 * Date: November 2025
 * 
 * MenuOption.java - Enum for main menu options
 */
package CA_2;

/**
 * MenuOption enum - defines the five main menu options
 * Makes the menu structure clear and easy to manage
 * 
 * @author Diego Bruno Evangelista dos Santos
 */
public enum MenuOption {
    
    // The five menu options available to users
    SORT(1, "Sort Employee List"),
    SEARCH(2, "Search for Employee"),
    ADD_RECORD(3, "Add New Employee"),
    BINARY_TREE(4, "Create Employee Hierarchy"),
    EXIT(5, "Exit Program");
    
    private int option;           // Menu number (1-5)
    private String description;   // What the option does
    
    /**
     * Constructor - sets up each menu option
     * @param option the menu number
     * @param description what this option does
     */
    MenuOption(int option, String description) {
        this.option = option;
        this.description = description;
    }
    
    /**
     * Gets the option number
     * @return option number (1-5)
     */
    public int getOption() {
        return option;
    }
    
    /**
     * Gets the description of what this option does
     * @return description text
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Displays the complete menu with all options
     * Shows numbered list and waits for user choice
     */
    public static void displayMenu() {
        System.out.println("\n===== BANK EMPLOYEE SYSTEM =====");
        for (MenuOption menu : MenuOption.values()) {
            System.out.println(menu.getOption() + ". " + menu.getDescription());
        }
        System.out.println("================================");
        System.out.print("Choose option: ");
    }
}