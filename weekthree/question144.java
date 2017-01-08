public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        // corner case
        if (root == null) {
            return result;
        }
        
        // core logic
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            
            if (cur.right != null) {
                stack.push(cur.right);
            }
            
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        
        return result;
    }
}