/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // Create a PathSum class to hold two largest sum path:
    // 1. the one that starts from the current node
    // 2. the one that the current node is in the middle
    public class PathSum {
        int singlePath;
        int doublePath;
        
        public PathSum(int singlePath, int doublePath) {
            this.singlePath = singlePath;
            this.doublePath = doublePath;
        }
    }
    
    public int maxPathSum(TreeNode root) {
        PathSum result = helper(root);
        return result.doublePath;
    }
    
    public PathSum helper(TreeNode root) {
        // corner case
        if (root == null) {
            return new PathSum(0, Integer.MIN_VALUE);
        }
        
        // core logic
        // Calculate the both the left child and the right child
        PathSum left = helper(root.left);
        PathSum right = helper(root.right);
        
        // Calculate the max single path for the current node
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(0, singlePath);
        
        // Calculate the max double path for the current node
        int doublePath = Math.max(left.doublePath, right.doublePath);
        doublePath = Math.max(doublePath, left.singlePath + right.singlePath + root.val);
        
        return new PathSum(singlePath, doublePath);
    }
}