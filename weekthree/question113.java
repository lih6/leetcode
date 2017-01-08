public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        
        dfs(root, sum - root.val, list, result);
        
        return result;
    }
    
    private void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {
        // base case
        if (sum == 0 && root.left == null && root.right == null) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(list);
            result.add(temp);
        }
        
        // general case
        if (root.left != null) {
            list.add(root.left.val);
            dfs(root.left, sum - root.left.val, list, result);
            list.remove(list.size() - 1);
        }
        
        if (root.right != null) {
            list.add(root.right.val);
            dfs(root.right, sum - root.right.val, list, result);
            list.remove(list.size() - 1);
        }
    }
}