public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // corner case
        if (root == null || root.left == null) {
            return root;
        }
        
        // core logic
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        
        root.left.right = root;
        root.left.left = root.right;
        
        root.left = null;
        root.right = null;
        
        return newRoot;
    }
}