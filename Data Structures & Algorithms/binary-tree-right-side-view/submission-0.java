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
    public List<Integer> rightSideView(TreeNode root) {
        /*
        BFS
        Look by level then return the right most node
        */
        Queue<TreeNode> nodeQ = new ArrayDeque<>();
        nodeQ.add(root);
        List<Integer> rightVals = new ArrayList<>();
        while(!nodeQ.isEmpty()) {
            int qSize = nodeQ.size();
            Deque<Integer> levelVals = new ArrayDeque<>();
            for(int i = 0; i < qSize; i++) {
                TreeNode node = nodeQ.poll();
                if (node.left != null) {
                    nodeQ.add(node.left);
                }
                // gets the right most nodes as the last in the queue
                if (node.right != null) {
                    nodeQ.add(node.right);
                }
                levelVals.add(node.val);
            }
            // pop the last value since this will be the rightmost
            rightVals.add(levelVals.pollLast());
        }
        return rightVals;
    }
}
