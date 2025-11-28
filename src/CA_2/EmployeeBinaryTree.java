/*
 * CCT College Dublin
 * H.Dip in Computing - Algorithms & Constructs
 * Continuous Assessment 2 - Bank Employee Management System
 * 
 * Student: Diego Bruno Evangelista dos Santos
 * Student Number: 2025145
 * Date: November 2025
 * 
 * EmployeeBinaryTree.java - Binary tree structure for employee hierarchy
 */
package CA_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * EmployeeBinaryTree class - manages the employee hierarchy as a binary tree
 * Uses level-order insertion to keep the tree balanced
 * Shows organizational structure with employees at different levels
 * 
 * @author Diego Bruno Evangelista dos Santos
 */
public class EmployeeBinaryTree {
    
    private TreeNode root;  // Top of the tree (CEO level)
    
    /**
     * Creates a new empty tree
     */
    public EmployeeBinaryTree() {
        this.root = null;
    }
    
    /**
     * Adds an employee to the tree using level-order insertion
     * This means it fills the tree level by level, left to right
     * Keeps the tree balanced instead of getting lopsided
     * 
     * @param employee the employee to add to the hierarchy
     */
    public void insert(Employee employee) {
        TreeNode newNode = new TreeNode(employee);
        
        // If tree is empty, this employee becomes the root (top level)
        if (root == null) {
            root = newNode;
            return;
        }
        
        // Use a queue to find the next available spot
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            
            // Try left side first
            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                queue.add(current.left);  // Left is full, check it later
            }
            
            // Try right side
            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.right);  // Right is full, check it later
            }
        }
    }
    
    /**
     * Checks if the tree has any employees
     * @return true if empty, false if has employees
     */
    public boolean isEmpty() {
        return root == null;
    }
    
    /**
     * Shows the entire hierarchy level by level
     * Level 1 is at the top (management), going down to lower levels
     */
    public void displayLevelOrder() {
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }
        
        System.out.println("\n========== EMPLOYEE HIERARCHY (Level Order) ==========");
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int level = 1;
        
        // Go through tree level by level
        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // How many employees at this level
            System.out.println("\n--- Level " + level + " ---");
            
            // Print everyone at this level
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                System.out.println(current.getEmployee());
                
                // Add their subordinates to check next
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            level++;
        }
        System.out.println("======================================================");
    }
    
    /**
     * Gets the height of the tree
     * Height = how many levels from top to bottom (minus 1)
     * @return tree height
     */
    public int getHeight() {
        return calculateHeight(root);
    }
    
    /**
     * Helper method to calculate height recursively
     * Checks both left and right sides and takes the taller one
     */
    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return -1;  // Empty tree has height -1
        }
        
        // Get height of left and right sides
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        
        // Return the taller side plus 1 for this level
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    /**
     * Counts how many employees are in the tree
     * @return total number of nodes
     */
    public int getNodeCount() {
        return countNodes(root);
    }
    
    /**
     * Helper method to count nodes recursively
     * Counts this node plus all nodes in left and right subtrees
     */
    private int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // Count this node (1) + left side + right side
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
    
    /**
     * Shows summary info about the tree
     * Displays total employees and how many levels the hierarchy has
     */
    public void displayStatistics() {
        System.out.println("\n========== TREE STATISTICS ==========");
        System.out.println("Total Nodes: " + getNodeCount());
        System.out.println("Tree Height: " + getHeight());
        System.out.println("====================================");
    }
}