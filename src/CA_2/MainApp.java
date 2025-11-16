/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.InputMismatchException;
/**
 *
 * @author diego
 */
public class MainApp {
  
        // Class variables (outside main method!)
    private static ArrayList<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int employeeIdCounter = 1000;
    
    // Only ONE main method
    public static void main(String[] args) {
        System.out.println("Welcome to Bank Employee Management System!");
        
        // Read file
        loadEmployeesFromFile();
        
        // Menu loop
        boolean running = true;
        
       while (running) {
    MenuOption.displayMenu();
    
    try {
        int choice = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        
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
                // will implement later
                break;
            case 5:
                System.out.println("Goodbye!");
                running = false;
                break;
            default:
                System.out.println("Invalid option!");
        }
    } catch (InputMismatchException e) {
        System.out.println("Error: Please enter a valid number!");
        scanner.nextLine(); // clear the bad input
    }
   } 
  }
    // Function to read file
    private static void loadEmployeesFromFile() {
        System.out.print("Please enter the filename to read: ");
        String filename = scanner.nextLine();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    // Create employee with random data for now
                    String name = line.trim();
                    String managerType = "Branch Manager"; // temporary
                    String department = "Retail Banking"; // temporary
                    
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
    // Function to sort employees using Merge Sort
    private static void sortEmployees() {
        System.out.println("\n========== SORTING EMPLOYEES ==========");
        
        if (employeeList.isEmpty()) {
            System.out.println("No employees to sort!");
            return;
        }
        
        // Create copy to sort
        ArrayList<Employee> sortedList = new ArrayList<>(employeeList);
        
        // Perform merge sort
        mergeSort(sortedList, 0, sortedList.size() - 1);
        
        // Display first 20 names
        System.out.println("\nFirst 20 employees (sorted alphabetically):");
        int displayCount = Math.min(20, sortedList.size());
        for (int i = 0; i < displayCount; i++) {
            System.out.println((i + 1) + ". " + sortedList.get(i).getName());  
        }
        
        System.out.println("\nTotal employees sorted: " + sortedList.size());
        System.out.println("=======================================");
    } 
    
    // Recursive Merge Sort implementation
    private static void mergeSort(ArrayList<Employee> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            
            // Recursively sort left half
            mergeSort(list, left, mid);
            
            // Recursively sort right half
            mergeSort(list, mid + 1, right);
            
            // Merge sorted halves
            merge(list, left, mid, right);
        }
    }
    
    // Merge function for merge sort
    private static void merge(ArrayList<Employee> list, int left, int mid, int right) {
        // Create temporary arrays
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        ArrayList<Employee> leftArray = new ArrayList<>();
        ArrayList<Employee> rightArray = new ArrayList<>();
        
        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray.add(list.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightArray.add(list.get(mid + 1 + j));
        }
        
        // Merge temporary arrays back
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            // Compare employee names
            if (leftArray.get(i).getName().compareToIgnoreCase(rightArray.get(j).getName()) <= 0) {
                list.set(k, leftArray.get(i));
                i++;
            } else {
                list.set(k, rightArray.get(j));  
                j++;
            }
            k++;
        }
        
        // Copy remaining elements
        while (i < n1) {
            list.set(k, leftArray.get(i));
            i++;
            k++;
        }
        
        while (j < n2) {
            list.set(k, rightArray.get(j));
            j++;
            k++;
        }
    }
    // Function to search employee using Binary Search
    private static void searchEmployee() {
        System.out.println("\n========== SEARCH EMPLOYEE ==========");
        
        if (employeeList.isEmpty()) {
            System.out.println("No employees available to search!");
            return;
        }
        
        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine().trim();
        
        // First, sort the list for binary search
        ArrayList<Employee> sortedList = new ArrayList<>(employeeList);
        mergeSort(sortedList, 0, sortedList.size() - 1);
        
        // Perform binary search
        int index = binarySearch(sortedList, searchName);
        
        if (index != -1) {
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
    
    // Binary Search implementation
    private static int binarySearch(ArrayList<Employee> list, String name) {
        int left = 0;
        int right = list.size() - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = list.get(mid).getName().compareToIgnoreCase(name);
            
            if (comparison == 0) {
                return mid; // Found
            } else if (comparison < 0) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; //
            }
        }
        
        return -1; // Not found
    }
// Function to add new employee with validation
    private static void addNewEmployee() {
        System.out.println("\n========== ADD NEW EMPLOYEE ==========");
        
        // Get employee name
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine().trim();
        
        // Validate name is not empty
        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty!");
            return;  
        }
        
        // Display and select manager type
        System.out.println("\nAvailable Manager Types:");
        System.out.println("1. Branch Manager");
        System.out.println("2. Department Manager");
        System.out.println("3. Regional Manager");
        System.out.print("Select manager type (1-3): ");
        
        int managerChoice = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        
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
        
        // Display and select department
        System.out.println("\nAvailable Departments:");
        System.out.println("1. Retail Banking");
        System.out.println("2. Loans");
        System.out.println("3. Investment");
        System.out.println("4. IT");
        System.out.print("Select department (1-4): ");
        
        int deptChoice = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        
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
        
        // Create new employee
        Employee newEmployee = new Employee(employeeIdCounter++, name, managerType, department);
        employeeList.add(newEmployee);
        
        // Confirmation message
        System.out.println("\n✓ Employee added successfully!");
        System.out.println(newEmployee);
        
        System.out.println("======================================");
    }

}
