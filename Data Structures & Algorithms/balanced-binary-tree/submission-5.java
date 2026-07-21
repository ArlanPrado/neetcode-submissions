/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // set up variable to hold the result of balanced
        boolean[] isBalancedArr = new boolean[1];
        isBalancedArr[0] = true;

        maxRecurse(root, 0, isBalancedArr);
        return isBalancedArr[0];
            
    }
    private int maxRecurse(TreeNode root, int depth, boolean[] isBalancedArr) {

        // if the root is null or if we already found an unbalanced TreeNode, then return
        if (root == null || !isBalancedArr[0]) {
            return depth;
        }
        int leftD = maxRecurse(root.left, depth, isBalancedArr);
        int rightD = maxRecurse(root.right, depth, isBalancedArr);
        
        //if encountering an unbalanced TreeNode then set isBalancedArr as false
        int diff = Math.abs(leftD - rightD);
        if (diff > 1) {
            isBalancedArr[0] = false;
        }
        return Math.max(leftD,rightD)+1;
    }
}
