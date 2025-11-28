/*
 * CCT College Dublin
 * H.Dip in Computing - Algorithms & Constructs
 * Continuous Assessment 2 - Bank Employee Management System
 * 
 * Student: Diego Bruno Evangelista dos Santos
 * Student Number: 2025145
 * Date: November 2025
 * 
 * MainApp.java - Main program that runs the employee management system
 */
package CA_2;

import java.util.Scanner;
import java.io.*;
import java.util.*;

/**
 * Main application for Bank Employee Management System
 * Handles menu, file reading, sorting, searching, and binary tree operations
 * 
 * @author Diego Bruno Evangelista dos Santos
 */
public class MainApp {
  
    // Global variables used throughout the program
    private static ArrayList<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int employeeIdCounter = 1000;  // Start IDs from 1000
    
    /**
     * Main method - program starts here
     * Shows menu and handles user choices
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Bank Employee Management System!");
        
        // Load employee data from file
        loadEmployeesFromFile();
        
        // Keep showing menu until user exits
        boolean running = true;
        
        while (running) {
            MenuOption.displayMenu();
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();  // Clear the buffer after reading number
                
                // Handle user's choice
                switch (choice) {
                    case 1:
                        System.out.println("SORT selected");
                        sortEmployees();
                        break;
                    case 2:
                        System.out.println("SEARCH selected");
                        searchEmployee();
                        break;
                    case 3:
                        System.out.println("ADD RECORD selected");
                        addNewEmployee();
                        break;
                    case 4:
                        System.out.println("BINARY TREE selected");
                        createBinaryTree();
                        break;
                    case 5:
                        System.out.println("Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            } catch (InputMismatchException e) {
                // Catch if user enters text instead of number
                System.out.println("Error: Please enter a valid number!");
                scanner.nextLine();  // Clear the bad input
            }
        }
        
        scanner.close();
    }
    
    /**
     * Reads employee names from a text file
     * Creates Employee objects and adds them to the list
     */
    private static void loadEmployeesFromFile() {
        System.out.print("Please enter the filename to read: ");
        String filename = scanner.nextLine();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            
            // Read file line by line
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String name = line.trim();
                    
                    // For now, give everyone same manager and department
                    // In real system, this would come from file too
                    String managerType = "Branch Manager";
                    String department = "Retail Banking";
                    
                    // Create employee and add to list
                    Employee emp = new Employee(employeeIdCounter++, name, managerType, department);
                    employeeList.add(emp);
                }
            }
            
            br.close();
            System.out.println("File read successfully! Loaded " + employeeList.size() + " employees.");
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Error reading file!");
        }
    }
    
    /**
     * Sorts employees alphabetically using Merge Sort
     * Shows first 20 sorted names on screen
     */
    private static void sortEmployees() {
        System.out.println("\n========== SORTING EMPLOYEES ==========");
        
        // Check if list is empty
        if (employeeList.isEmpty()) {
            System.out.println("No employees to sort!");
            return;
        }
        
        // Make a copy so we don't mess up the original list
        ArrayList<Employee> sortedList = new ArrayList<>(employeeList);
        
        // Sort using merge sort
        mergeSort(sortedList, 0, sortedList.size() - 1);
        
        // Show first 20 names
        System.out.println("\nFirst 20 employees (sorted alphabetically):");
        int displayCount = Math.min(20, sortedList.size());
        for (int i = 0; i < displayCount; i++) {
            System.out.println((i + 1) + ". " + sortedList.get(i).getName());
        }
        
        System.out.println("\nTotal employees sorted: " + sortedList.size());
        System.out.println("=======================================");
    }
    
    /**
     * Merge Sort - recursive sorting algorithm
     * Divides list in half, sorts each half, then merges back together
     */
    private static void mergeSort(ArrayList<Employee> list, int left, int right) {
        if (left < right) {
            // Find middle point
            int mid = (left + right) / 2;
            
            // Sort left half
            mergeSort(list, left, mid);
            
            // Sort right half
            mergeSort(list, mid + 1, right);
            
            // Merge the two sorted halves
            merge(list, left, mid, right);
        }
    }
    
    /**
     * Merges two sorted halves into one sorted list
     * This is where the actual sorting happens
     */
    private static void merge(ArrayList<Employee> list, int left, int mid, int right) {
        // Figure out sizes of the two halves
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // Create temp arrays to hold the two halves
        ArrayList<Employee> leftArray = new ArrayList<>();
        ArrayList<Employee> rightArray = new ArrayList<>();
        
        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            leftArray.add(list.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightArray.add(list.get(mid + 1 + j));
        }
        
        // Merge the temp arrays back into main list in order
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            // Compare names and put smaller one first
            if (leftArray.get(i).getName().compareToIgnoreCase(rightArray.get(j).getName()) <= 0) {
                list.set(k, leftArray.get(i));
                i++;
            } else {
                list.set(k, rightArray.get(j));
                j++;
            }
            k++;
        }
        
        // Copy any remaining elements from left array
        while (i < n1) {
            list.set(k, leftArray.get(i));
            i++;
            k++;
        }
        
        // Copy any remaining elements from right array
        while (j < n2) {
            list.set(k, rightArray.get(j));
            j++;
            k++;
        }
    }
    
    /**
     * Searches for an employee by name using Binary Search
     * Shows their details if found
     */
    private static void searchEmployee() {
        System.out.println("\n========== SEARCH EMPLOYEE ==========");
        
        if (employeeList.isEmpty()) {
            System.out.println("No employees available to search!");
            return;
        }
        
        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine().trim();
        
        // Binary search needs sorted list, so sort first
        ArrayList<Employee> sortedList = new ArrayList<>(employeeList);
        mergeSort(sortedList, 0, sortedList.size() - 1);
        
        // Search for the employee
        int index = binarySearch(sortedList, searchName);
        
        if (index != -1) {
            // Found! Show their info
            Employee found = sortedList.get(index);
            System.out.println("\n✓ Employee Found!");
            System.out.println("Name: " + found.getName());
            System.out.println("Manager Type: " + found.getManagerType());
            System.out.println("Department: " + found.getDepartment());
            System.out.println("Employee ID: " + found.getId());
        } else {
            System.out.println("\n✗ Employee not found!");
        }
        
        System.out.println("====================================");
    }
    
    /**
     * Binary Search - finds employee in sorted list
     * Returns index if found, -1 if not found
     */
    private static int binarySearch(ArrayList<Employee> list, String name) {
        int left = 0;
        int right = list.size() - 1;
        
        while (left <= right) {
            // Check middle element
            int mid = (left + right) / 2;
            int comparison = list.get(mid).getName().compareToIgnoreCase(name);
            
            if (comparison == 0) {
                return mid;  // Found it!
            } else if (comparison < 0) {
                left = mid + 1;  // Look in right half
            } else {
                right = mid - 1;  // Look in left half
            }
        }
        
        return -1;  // Not found
    }
    
    /**
     * Adds a new employee to the system
     * Validates input and shows confirmation
     */
    private static void addNewEmployee() {
        System.out.println("\n========== ADD NEW EMPLOYEE ==========");
        
        // Get employee name
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine().trim();
        
        // Make sure name isn't empty
        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty!");
            return;
        }
        
        // Show manager type options
        System.out.println("\nAvailable Manager Types:");
        System.out.println("1. Branch Manager");
        System.out.println("2. Department Manager");
        System.out.println("3. Regional Manager");
        System.out.print("Select manager type (1-3): ");
        
        int managerChoice = scanner.nextInt();
        scanner.nextLine();  // Clear buffer
        
        // Figure out which manager type they picked
        String managerType;
        if (managerChoice == 1) {
            managerType = "Branch Manager";
        } else if (managerChoice == 2) {
            managerType = "Department Manager";
        } else if (managerChoice == 3) {
            managerType = "Regional Manager";
        } else {
            System.out.println("Error: Invalid manager type!");
            return;
        }
        
        // Show department options
        System.out.println("\nAvailable Departments:");
        System.out.println("1. Retail Banking");
        System.out.println("2. Loans");
        System.out.println("3. Investment");
        System.out.println("4. IT");
        System.out.print("Select department (1-4): ");
        
        int deptChoice = scanner.nextInt();
        scanner.nextLine();  // Clear buffer
        
        // Figure out which department they picked
        String department;
        if (deptChoice == 1) {
            department = "Retail Banking";
        } else if (deptChoice == 2) {
            department = "Loans";
        } else if (deptChoice == 3) {
            department = "Investment";
        } else if (deptChoice == 4) {
            department = "IT";
        } else {
            System.out.println("Error: Invalid department!");
            return;
        }
        
        // Create the new employee and add to list
        Employee newEmployee = new Employee(employeeIdCounter++, name, managerType, department);
        employeeList.add(newEmployee);
        
        // Show confirmation
        System.out.println("\n✓ Employee added successfully!");
        System.out.println(newEmployee);
        
        System.out.println("======================================");
    }
    
    /**
     * Creates a binary tree showing employee hierarchy
     * Needs at least 20 employees to work
     */
    private static void createBinaryTree() {
        System.out.println("\n========== CREATE EMPLOYEE HIERARCHY ==========");
        
        // Check if we have enough employees
        if (employeeList.size() < 20) {
            System.out.println("Error: Need at least 20 employees!");
            System.out.println("Currently have: " + employeeList.size() + " employees");
            System.out.println("Please add more employees first.");
            return;
        }
        
        // Create new tree
        EmployeeBinaryTree tree = new EmployeeBinaryTree();
        
        // Put first 20 employees into the tree
        System.out.println("Inserting " + Math.min(employeeList.size(), 20) + " employees into hierarchy...");
        
        for (int i = 0; i < Math.min(employeeList.size(), 20); i++) {
            tree.insert(employeeList.get(i));
        }
        
        // Show the tree structure
        tree.displayLevelOrder();
        
        // Show tree stats (height, total nodes)
        tree.displayStatistics();
        
        System.out.println("===============================================");
    }
}