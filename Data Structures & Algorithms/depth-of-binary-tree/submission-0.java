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
    public int maxDepth(TreeNode root) {
        /*
        Thought process: do recursion?
        keep going until the leaf is reached 
        and then compare from both sides and return the biggest depth back up 
        */
        return maxRecurse(root, 0);
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
