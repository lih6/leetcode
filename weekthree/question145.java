public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        // corner case
        if (root == null) {
            return result;
        }
        
        // core logic
        Stack<TreeNode> stackOne = new Stack<>();
        Stack<TreeNode> stackTwo = new Stack<>();
        
        stackOne.push(root);
        
        while (!stackOne.isEmpty()) {
            TreeNode cur = stackOne.pop();
            stackTwo.push(cur);
            
            if (cur.left != null) {
                stackOne.push(cur.left);
            }
            
            if (cur.right != null) {
                stackOne.push(cur.right);
            }
        }
        
        while (!stackTwo.isEmpty()) {
            result.add(stackTwo.pop().val);
        }
        
        return result;
    }
}