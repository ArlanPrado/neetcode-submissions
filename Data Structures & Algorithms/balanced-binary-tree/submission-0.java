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
        int leftDepth = maxRecurse(root.left, 1);
        int rightDepth = maxRecurse(root.right, 1);
        int diff = Math.abs(leftDepth - rightDepth);
        if (diff <= 1) return true;
        return false;
            
    }
    private int maxRecurse(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        int leftD = maxRecurse(root.left, depth);
        int rightD = maxRecurse(root.right, depth);
        if (leftD > rightD) {
            return leftD;
        } else {
            return rightD;
        }
    }
}
