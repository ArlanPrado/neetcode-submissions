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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> roots = new ArrayList<>();
        helper(root, roots);
        return roots;
    }
    public void helper(TreeNode root, List<Integer> roots) {
        if (root == null) {
            return;
        }
        roots.add(root.val);
        helper(root.left, roots);
        helper(root.right, roots);
    }
}