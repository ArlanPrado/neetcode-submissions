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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidHelper(root, root.val+1, root.val-1);
    }
    private boolean isValidHelper(TreeNode root, int lowestLeft, int mostRight) {
        if (root == null) {
            return true;
        }
        if (root.val > lowestLeft || root.val < mostRight) {
            return false;
        }
        boolean leftBool = isValidHelper(root.left, root.val, mostRight);
        boolean rightBool = isValidHelper(root.right, lowestLeft, root.val);
        return leftBool && rightBool;
    }
}
