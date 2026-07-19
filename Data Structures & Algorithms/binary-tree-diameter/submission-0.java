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
    public int diameterOfBinaryTree(TreeNode root) {
        /*
        First instinct is to go to the deepest node and look up.
        This would require keeping track of the parent which would cause more space complexity..
        The O(n^2) way is to start at the root and calculate the diameter of each node..
        Finding the longest edge on the left and the right on every node, this will take very long
        Maybe we can track nodes longest length on each side using some data structure that identifies the node by the pointer and gives the longest left and right..
        So if there is a path not discovered then we can check with that and use the longest depth algorithm on that..
        
        max(3,0)+1 1 
            max(2,1)+1 2
max(1,0)+1        3       max(0,0)+1 4
    5 (max(0,0)+1)
        
        Go all the way down, once reached, on one side return +1
        */

     return maxEdgeRecurse(root.left, 0) + maxEdgeRecurse(root.right, 0);   

    }

    //start with 0
    private int maxEdgeRecurse(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int leftD = maxEdgeRecurse(root.left, depth);
        int rightD = maxEdgeRecurse(root.right, depth);
        return Math.max(leftD, rightD) + 1;
    }

}