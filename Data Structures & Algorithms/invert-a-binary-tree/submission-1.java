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
    public TreeNode invertTree(TreeNode root) {
        /*
        Recursively?
        Keep going until the leaf nodes are reached
        Prefer to go root down to the leaf and do operations to the leaf
        inverting a binary tree is all about solving the subproblem then going down
        look at left and right, then swap , use temporary treeNode so their references

        actually, go all the way down left, until there aren't anymore treenodes,
        once at the leaf then go back up and check right tree node if that has nodes to swap,
        if not then go back up swap the values,
        recurse 
        */
        if (root == null) {
            return root;
        }
        
        List<TreeNode> todo = new ArrayList<>();
        todo.add(root);
        while(!todo.isEmpty()) {
            TreeNode look = todo.getFirst();
            todo.removeFirst();
            if (look != null) {
                TreeNode tLeft = look.left;
                TreeNode tRight = look.right;
                look.left = tRight;
                look.right = tLeft;
                todo.add(tLeft);
                todo.add(tRight);
            }
        }
        return root;
    }
}
