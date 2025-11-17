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
                current.left = newNode
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
}
   
