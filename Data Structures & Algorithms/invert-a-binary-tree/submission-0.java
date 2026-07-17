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
    public TreeNode invertTree(TreeNode root) {
        /*
        Recursively?
        Keep going until the leaf nodes are reached
        Prefer to go root down to the leaf and do operations to the leaf
        inverting a binary tree is all about solving the subproblem then going down
        look at left and right, then swap , use temporary treeNode so their references
        */

    }
    public TreeNode recurse(TreeNode top) {
        if (top.left == null || top.right || null) {
            return top;
        }
        
        TreeNode left = top.left;
        TreeNode right = top.right;
        top.left = right;
        top.right = left;

        recurse(top.left); 
        recurse(top.left)
    }
}
