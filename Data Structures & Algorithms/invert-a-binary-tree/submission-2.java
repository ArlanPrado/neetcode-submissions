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
        if (root == null) {
            return root;
        }
        
        //List of TreeNodes that will be inverted
        List<TreeNode> todo = new ArrayList<>();
        todo.add(root);
        while(!todo.isEmpty()) {
            TreeNode look = todo.getFirst();
            todo.removeFirst(); // remove from list since this will be inverted in this step
            if (look != null) { // if node isn't null then get the TreeNodes left and right then swap, 
            // this won't be a problem if left or right is null, 
            // we only care at the evaluate step if its null so we don't accidentally try to access data that doesn't exist with .left or .right
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
