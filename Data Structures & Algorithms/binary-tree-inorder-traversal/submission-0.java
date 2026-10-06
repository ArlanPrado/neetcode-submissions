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
    public List<Integer> inorderTraversal(TreeNode root) {
        // left, middle, right, back up
        // call until it gets to the left.root return the value, once the value is returned, then attach the returned to the current then search right
        List<Integer> roots = new ArrayList<Integer>();
        helper(root, roots);
        return roots;
    }
    public void helper(TreeNode root, List<Integer> roots) {
        if (root == null) {
            return;
        }
        helper(root.left, roots);
        roots.add(root.val);
        helper(root.right, roots);

    }
}