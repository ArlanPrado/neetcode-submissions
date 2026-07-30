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

        /*
        if we find a root that matches either p or q then just return
        assuming that the other is in this branch
        */
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode leftN = lowestCommonAncestor(root.left, p, q);
        TreeNode rightN = lowestCommonAncestor(root.right, p, q);
        // if we later find that both branches return a node then return the root
        if (leftN != null && rightN != null) {
            return root;
        }
        // return the branch that isn't null
        return leftN == null ? rightN : leftN;
    }
    /*
    Time Complexity: O(n), At worst it will have to go through the entire tree
    Space Complexity: O(n), Stack memory on worst case has to go through the entire tree
    */
}
