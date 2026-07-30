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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        /*
        DFS on the root,
        encounter a node that has the same value as the subroot,
            check the node if its the same tree, if it is just return true
            if its false then return back to the original DFS to find another candidate
        */
        if ((root == null && subRoot != null) || (root != null && subRoot == null)) {
            return false;
        }
        if (root.val == subRoot.val) {
            boolean result = isSameTree(root, subRoot);
            if (result) {
                return result;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if ((root == null && subRoot != null) 
        || (root != null && subRoot == null)
        || (root.val != subRoot.val)) {
            return false;
        }
        // if any is false then return false
        return isSameTree(root.right, subRoot.right) && isSameTree(root.left, subRoot.left);
        
    }
}
