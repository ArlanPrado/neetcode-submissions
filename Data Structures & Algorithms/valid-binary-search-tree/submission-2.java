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
        return isValidHelper(root, -1001, 1001);
    }
    private boolean isValidHelper(TreeNode root, int lowestLeft, int mostRight) {
        if (root == null) {
            return true;
        }
        // if root val is greater or equal to left then its false, if root val is less than or equal to right then its false
        if (root.val <= lowestLeft || root.val >= mostRight) {
            System.out.println(String.format("Root: %d, Left: %d, Right: %d", root.val, lowestLeft, mostRight));
            return false;
        }
        //only check left, automatically pass right check 
        boolean leftBool = isValidHelper(root.left, lowestLeft, root.val);
        //only check right, automatically pass left check
        boolean rightBool = isValidHelper(root.right, root.val, mostRight);
        return leftBool && rightBool;
    }
}
