/*
 * CCT College Dublin
 * H.Dip in Computing - Algorithms & Constructs
 * Continuous Assessment 2 - Bank Employee Management System
 * 
 * Student: Diego Bruno Evangelista dos Santos
 * Student Number: 2025145
 * Date: November 2025
 * 
 * TreeNode.java - Node structure for the binary tree
 */
package CA_2;

/**
 * TreeNode class - represents one node in the binary tree
 * Each node holds one employee and can point to two child nodes
 * This creates the tree structure for the hierarchy
 * 
 * @author Diego Bruno Evangelista dos Santos
 */
public class TreeNode {
    
    // What this node contains
    Employee employee;  // The employee at this position in hierarchy
    TreeNode left;      // Left child (subordinate)
    TreeNode right;     // Right child (subordinate)
    
    /**
     * Creates a new tree node with an employee
     * Left and right children start as null (no subordinates yet)
     * 
     * @param employee the employee to store in this node
     */
    public TreeNode(Employee employee) {
        this.employee = employee;
        this.left = null;
        this.right = null;
    }
    
    /**
     * Gets the employee stored in this node
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }
}