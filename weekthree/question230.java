public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        int count = 1;
        while (!stack.isEmpty() && count < k) {
            TreeNode cur = stack.pop();
            cur = cur.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            count++;
        }
        
        return stack.pop().val;
    }
}