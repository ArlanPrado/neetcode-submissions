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
        boolean[] isBalancedArr = new boolean[1];
        isBalancedArr[0] = true;
        maxRecurse(root, 0, isBalancedArr);
        return isBalancedArr[0];
            
    }
    private int maxRecurse(TreeNode root, int depth, boolean[] isBalancedArr) {
        if (root == null || !isBalancedArr[0]) {
            return depth;
        }
        int leftD = maxRecurse(root.left, depth, isBalancedArr);
        int rightD = maxRecurse(root.right, depth, isBalancedArr);
        
        int diff = Math.abs(leftD - rightD);
        if (diff > 1) {
            isBalancedArr[0] = false;
        }
        return Math.max(leftD,rightD)+1;
    }
}
