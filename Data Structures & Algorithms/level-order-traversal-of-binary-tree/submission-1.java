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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        while(queue.size() > 0) {
            List<Integer> levelVals = new ArrayList<>();
            List<TreeNode> nextQueue = new ArrayList<>();
            for (TreeNode n : queue) {
                if (n.left != null) {
                    nextQueue.add(n.left);
                }
                if (n.right != null) {
                    nextQueue.add(n.right);
                }
                levelVals.add(n.val);
            }
            result.add(levelVals);
            queue = nextQueue;
        }
        return result;
    }
    /*
    Time Complexity: each node is being accessed one time, O(n)
    Space Complexity: we are creating 3 lists, but each level 2 lists (nextQueue and levelVals) are being emptied, and result list is O(n)
        w= width of the tree, O(n + w) = O(n)
    */
}
