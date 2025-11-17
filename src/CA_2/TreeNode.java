/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;
/*** 
 * Node class for Binary Tree structure
 * Each node contains an Employee and references to left and right children
 * @author diego
 */
public class TreeNode {
    Employee employee;
    TreeNode left;
    TreeNode right;
    
    // Constructor
    public TreeNode(Employee employee) {
        this.employee = employee;
        this.left = null;
        this.right = null;
    }
    
    // Getter for employee
    public Employee getEmployee() {
        return employee;
    }
}
    
