public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        int res = heightDiff(root);
        
        if (res == -1) {
            return false;
        }
        
        return true;
    }
    
    private int heightDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = heightDiff(root.left);
        int right = heightDiff(root.right);
        
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        
        return Math.max(left, right) + 1;
    }
}