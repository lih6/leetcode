public class Solution {
    public int pathSum(TreeNode root, int sum) {
        // corner case
        if (root == null) {
            return 0;
        }
        
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        int result = 0;
        
        if (sum == root.val) {
             result++;
        }
        
        return result + dfs(root.left, sum - root.val) + dfs(root.right, sum - root.val);
    }
}