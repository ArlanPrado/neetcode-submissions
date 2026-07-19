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
    public int diameterOfBinaryTree(TreeNode root) {
        /*
        First instinct is to go to the deepest node and look up.
        This would require keeping track of the parent which would cause more space complexity..
        The O(n^2) way is to start at the root and calculate the diameter of each node..
        Finding the longest edge on the left and the right on every node, this will take very long
        Maybe we can track nodes longest length on each side using some data structure that identifies the node by the pointer and gives the longest left and right..
        So if there is a path not discovered then we can check with that and use the longest depth algorithm on that..
        
        max(3,0)+1 1 
            max(2,1)+1 2
max(1,0)+1        3       max(0,0)+1 4
    5 (max(0,0)+1)
        
        Go all the way down, once reached, on one side return +1
        */
    Pair<Integer,Integer> rootPair = maxEdgeRecurse(root, 0);
     return rootPair.getKey();   

    }

    // return Pair(largest diameter seen, height)
    private Pair maxEdgeRecurse(TreeNode root, int depth) {
        if (root == null) {
            return new Pair<Integer,Integer>(0, 0);
        }
        Pair<Integer,Integer> leftPair = maxEdgeRecurse(root.left, depth);
        Pair<Integer,Integer> rightPair = maxEdgeRecurse(root.right, depth);
        Integer currentDiameter = leftPair.getValue() + rightPair.getValue();
        Integer currentHeight = Math.max(leftPair.getValue(), rightPair.getValue()) + 1;
        Integer maxDiameter = Math.max(currentDiameter, Math.max(leftPair.getKey(), rightPair.getKey()));

        return new Pair(maxDiameter, currentHeight);
    }

}