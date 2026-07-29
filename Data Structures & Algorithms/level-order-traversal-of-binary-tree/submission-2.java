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
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(queue.size() > 0) {
            int qSize = queue.size();
            List<Integer> levelVals = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                 TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                levelVals.add(node.val);
            }
            result.add(levelVals);
        }
        return result;
    }
    /*
    Time Complexity: each node is being accessed one time, O(n)
    Space Complexity: we are creating 2 lists, but levelVals is of size w since its emptied at the width, and result list is O(n)
    */
}
