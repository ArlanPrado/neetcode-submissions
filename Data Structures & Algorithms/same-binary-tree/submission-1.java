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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if at the end of the same tree then that branch is identical
        if (p == null && q == null) {
            return true;
        }
        // if p or q is at the end of the leaf, or the value is not the same then its not the same
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        // search identical between left and right
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
