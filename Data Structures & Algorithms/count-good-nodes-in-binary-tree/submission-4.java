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
    // int goodCount = 0;
    public int goodNodes(TreeNode root) {
        /*
        DFS solution, 
        when passing down the tree, keep sending the biggest value seen
        if at each node the node.val is the biggest val then add to good count and then increase the biggest val
        */
        // the root val is the biggest seen so far
        int goodCount = dfs(root, root.val);
        return goodCount;
    }
    private int dfs(TreeNode node, int big) {
        if (node == null) {
            return 0;
        }
        int sol = 0;
        if (node.val >= big) {
            ++sol;
            big = node.val;
        }
        
        int left = dfs(node.left, big);
        int right = dfs(node.right, big);
        return sol + left + right;
    }
    /*
    Time Complexity: O(n), search through every node to see if its good
    Space Complexity: O(n), stack memory containing the trace of the tree
    */
}
