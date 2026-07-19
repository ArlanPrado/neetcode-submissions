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
        
        
        Go all the way down, once reached, return the base case of a node with no left or right ie. 0 diameter, 0 height
        This way we calculate the current height and get the max diameter seen.
        Space Complexity is O(H), Time Complexity is O(n)

        */
     Pair<Integer,Integer> rootPair = maxEdgeRecurse(root);
     return rootPair.getKey();   
    }

    // return Pair(largest diameter seen, height)
    private Pair maxEdgeRecurse(TreeNode root) {
        if (root == null) {
            return new Pair<Integer,Integer>(0, 0);
        }
        Pair<Integer,Integer> leftPair = maxEdgeRecurse(root.left);
        Pair<Integer,Integer> rightPair = maxEdgeRecurse(root.right);
        Integer currentDiameter = leftPair.getValue() + rightPair.getValue();
        Integer currentHeight = Math.max(leftPair.getValue(), rightPair.getValue()) + 1;
        Integer maxDiameter = Math.max(currentDiameter, Math.max(leftPair.getKey(), rightPair.getKey()));

        // this solution will get the max diameter seen and also the current height if the diameter above is greater
        return new Pair(maxDiameter, currentHeight);
    }

}