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
        // if root val is greater or equal to left then its false, if root val is less than or equal to right then its false
        if (root.val >= lowestLeft || root.val <= mostRight) {
            System.out.println(String.format("Root: %d, Left: %d, Right: %d", root.val, lowestLeft, mostRight));
            return false;
        }
        boolean leftBool = isValidHelper(root.left, root.val, -1001);
        boolean rightBool = isValidHelper(root.right, 1001, root.val);
        return leftBool && rightBool;
    }
    /*
    2, 3, 1
    1 >= 2 ... 1 <= 1
    3 >= 3 ... 3 <= 2
    */
}
