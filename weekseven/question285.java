/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution 1: iteratively
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // corner case
        if (root == null || p == null) {
            return null;
        }
        
        // iterative core logic
        // Two situations:
        // 1. root.val > p.val: go to left tree and save root to prev
        // 2. root.val <= p.val: go to right tree
        TreeNode next = root;
        while (root != null) {
            if (root.val > p.val) {
                next = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        // corner case
        // If p.left == p.right == null
        if (next.val <= p.val) {
            return null;
        }
        
        return next;
    }
}

// Solution 2: recursively
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // corner case
        if (root == null || p == null) {
            return null;
        }
        
        // recursive core logic
        // Two situations:
        // 1. root.val > p.val: get result from the left tree. If the result is null, then return the current node.
        // 2. root.val <= p.val: get result from the right tree
        if (root.val > p.val) {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        } else {
            return inorderSuccessor(root.right, p);
        }
    }
}