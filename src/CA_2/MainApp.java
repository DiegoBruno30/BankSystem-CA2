/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;
import java.util.Scanner;
/**
 *
 * @author diego
 */
public class MainApp {
  
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MenuOption choice;

        System.out.println("======================================");
        System.out.println("     BANK MANAGEMENT PROTOTYPE");
        System.out.println("======================================");

        do {
            // Exibe o menu
            System.out.println("\nPlease select an option:");
            System.out.println("1. Add Employee");
            System.out.println("2. Generate Random Employees");
            System.out.println("3. Sort Employees");
            System.out.println("4. Search Employee");
            System.out.println("5. View All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int option = input.nextInt();
            choice = getMenuOption(option);

            switch (choice) {
                case ADD_EMPLOYEE:
                    System.out.println("Adding employee...");
                    break;
                case GENERATE_RANDOM_EMPLOYEES:
                    System.out.println("Generating random employees...");
                    break;
                case SORT_EMPLOYEES:
                    System.out.println("Sorting employees...");
                    break;
                case SEARCH_EMPLOYEE:
                    System.out.println("Searching employee...");
                    break;
                case VIEW_ALL_EMPLOYEES:
                    System.out.println("Listing all employees...");
                    break;
                case EXIT:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }

        } while (choice != MenuOption.EXIT);
    }

    // Método auxiliar para converter número em enum
    private static MenuOption getMenuOption(int option) {
        switch (option) {
            case 1:
                return MenuOption.ADD_EMPLOYEE;
            case 2:
                return MenuOption.GENERATE_RANDOM_EMPLOYEES;
            case 3:
                return MenuOption.SORT_EMPLOYEES;
            case 4:
                return MenuOption.SEARCH_EMPLOYEE;
            case 5:
                return MenuOption.VIEW_ALL_EMPLOYEES;
            case 6:
                return MenuOption.EXIT;
            default:
                return null;
        }
    }  
}
