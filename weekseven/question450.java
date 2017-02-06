/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution 1: Recursively
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // corner case
        if (root == null) {
            return null;
        }
        
        // core logic
        // If the current node is larger than the key value, delete from left child
        // If the current node is smaller than the key value, delete from right child
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            // The current node equals the key value:
            // 1. if left child == null, return right
            // 2. if right child == null, return left
            if (root.left == null) {
                return root.right;
            }
            
            if (root.right == null) {
                return root.left;
            }
            
            // 3. if both left and right child exist:
            // Either find the smallest node in the right subtree, or find the largest
            // node in the left subetree and replace the current node.val with that value.
            // Then, do deleteNode with the value of the node.val found in the subtree.
            TreeNode right = root.right;
            while (right.left != null) {
                right = right.left;
            }
            root.val = right.val;
            
            root.right = deleteNode(root.right, root.val);
        }
        
        return root;
    }
}

// Solution 2: Iteratively
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // corner case
        if (root == null) {
            return null;
        }
        
        // core logic
        TreeNode cur = root;
        TreeNode prev = null;
        
        // Find the node that has value equals to key and its previous node
        while (cur != null && cur.val != key) {
            prev = cur;
            if (cur.val > key) {
                cur = cur.left;
            } else if (cur.val < key) {
                cur = cur.right;
            }
        }
        
        // If prev has not been updated, cur.val == key. Delete cur.
        if (prev == null) {
            return helper(cur);
        }
        
        // Update prev.left or prev.right according to the position of cur node.
        if (prev.left == cur) {
            prev.left = helper(cur);
        } else {
            prev.right = helper(cur);
        }
        
        return root;
    }
    
    public TreeNode helper(TreeNode cur) {
        // If cur deos not exist, return null
        if (cur == null) {
            return null;
        }
        
        // If left child is null, return right child
        if (cur.left == null) {
            return cur.right;
        }
        
        // If right child is null, return left child
        if (cur.right == null) {
            return cur.left;
        }
        
        // Find the smallest value in the right subtree
        TreeNode next = cur.right;
        TreeNode prev = null;
        while (next.left != null) {
            prev = next;
            next = next.left;
        }
        
        // Replace the left subtree of node next (which is null) with the left
        // subtree of the node that needs to be deleted (which is node cur).
        next.left = cur.left;
        
        // If the node next is the right child of the node cur, there is no need
        // to adjust the tree, just return. Otherwise, the tree needs to be adjusted
        // to make the node next the new root of the tree.
        if (cur.right != next) {
            // prev.left is originally next. Since next.right is still at prev's left tree,
            // next.right is still smaller than prev. Therefore, it needs to go to the right
            // subtree of prev.
            prev.left = next.right;
            // Since cur.right is definitely larger than next.right and noe next.right is
            // repositioned to another place and left empty, cur.right will take the place
            // of next.right. Now, next becomes the new root of the tree.
            next.right = cur.right;
        }
        
        return next;
    }
}