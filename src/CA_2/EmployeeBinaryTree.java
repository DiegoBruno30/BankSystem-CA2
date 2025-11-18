/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 package CA_2;

import java.util.LinkedList;
import java.util.Queue;
 
/** 
 * Binary Tree implementation for Employee Hierarchy
 * Uses level-order insertion to maintain balanced structure
 * @author diego
 */
public class EmployeeBinaryTree {
    private TreeNode root;
    
    // Constructor
    public EmployeeBinaryTree() {
        this.root = null;
    }
    
    /**
     * Insert employee using level-order approach
     * Fills tree level by level from left to right
     */
    public void insert(Employee employee) {
        TreeNode newNode = new TreeNode(employee);
        
        // If tree is empty, make this the root
        if (root == null) {
            root = newNode;
            return;
        }
        
        // Use queue for level-order insertion
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            
            // Try to insert on left
            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                queue.add(current.left);
            }
            
            // Try to insert on right
            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }
    
    /**
     * Check if tree is empty
     */
    public boolean isEmpty() {
        return root == null;
    }
    /**
     * Display tree in level-order traversal
     * Shows hierarchy level by level
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
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            System.out.println("\n--- Level " + level + " ---");
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                System.out.println(current.getEmployee());
                
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
     * Calculate height of the tree
     * Height = number of edges on longest path from root to leaf
     */
    public int getHeight() {
        return calculateHeight(root);
    }
    
    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    /**
     * Count total number of nodes in tree
     */
    public int getNodeCount() {
        return countNodes(root);
    }
    
    private int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
    
    /**
     * Display tree statistics
     */
    public void displayStatistics() {
        System.out.println("\n========== TREE STATISTICS ==========");
        System.out.println("Total Nodes: " + getNodeCount());
        System.out.println("Tree Height: " + getHeight());
        System.out.println("====================================");
    }
}
   
