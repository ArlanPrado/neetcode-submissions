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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
            return treeNode when both looks are true
            look in both for either p or q val, we know that nodes are unique vals
            so that if lowestCommonAncestor return a good response from either 
            branches then we can return the lowest ancestor
        */
        if (root == null) {
            return null;
        }
        if (root.val == p.val) {
            return root;
        }
        if (root.val == q.val) {
            return root;
        }
        TreeNode leftN = lowestCommonAncestor(root.left, p, q);
        TreeNode rightN = lowestCommonAncestor(root.right, p, q);

        if (leftN == null && rightN == null) {
            return null;
        } else if (leftN != null && rightN != null) {
            return root;
        }
        if (leftN == null) {
            return rightN;
        }
        if (rightN == null) {
            return leftN;
        }
        return null;
    }
}
