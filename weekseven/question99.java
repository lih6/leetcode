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
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    
    public void recoverTree(TreeNode root) {
        // corner case
        if (root == null) {
            return;
        }
        
        // core logic
        inorderTraversal(root);
        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
        return;
    }
    
    private void inorderTraversal(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }
        
        inorderTraversal(root.left);
        
        // If the value of current node is smaller than the one preceding it,
        // then it must have been flipped.
        if (prev != null && root.val < prev.val) {
            // If first has been updated, then there is no need to update it.
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        
        // Update the prev for next node's comparison
        prev = root;
        
        
        inorderTraversal(root.right);
        return;
    }
}