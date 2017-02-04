/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Define constants
    private static final String n = "n";
    private static final String separator = ",";

    // preorder traversal
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // corner case
        if (root == null) {
            return new String();
        }
        
        StringBuilder res = new StringBuilder();
        helper(root, res);
        return res.toString();
    }
    
    public void helper(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append(n).append(separator);
            return;
        }
        
        res.append(root.val).append(separator);
        helper(root.left, res);
        helper(root.right, res);
        return;
    }

    int index = 0;
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        
        String[] arr = data.split(",");
        return helper(arr);
    }
    
    public TreeNode helper(String[] arr) {
        if (index > arr.length - 1 || arr[index].equals(n)) {
            return null;
        }
        
        TreeNode cur = new TreeNode(Integer.parseInt(arr[index]));
        index++;
        cur.left = helper(arr);
        index++;
        cur.right = helper(arr);
        return cur;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));