public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // corner case
        if (root == null) {
            return false;
        }
        
        // base case
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}