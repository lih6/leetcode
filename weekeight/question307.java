// Solution 1: Binary Index Tree
public class NumArray {
    int[] nums;     // Store the input array
    int[] bit;      // Binary Index Tree

    public NumArray(int[] nums) {
        this.nums = nums;
        this.bit = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            updateIndex(i, nums[i]);
        }
    }
    
    // Update the the Binary Index Tree at a specific index
    private void updateIndex(int index, int value) {
        for (int i = index + 1; i <= nums.length; i += i & (-i)) {
            bit[i] += value;
        }
    }
    
    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        updateIndex(i, diff);
    }
    
    public int sumRange(int i, int j) {
        return calculateSum(j) - calculateSum(i - 1);
    }
    
    // Calculate the sum of numbers in nums from 0 to index
    private int calculateSum(int index) {
        int sum = 0;
        for (int i = index + 1; i > 0; i -= i & (-i)) {
            sum += bit[i];
        }
        
        return sum;
    }
}

// Solution 2: Segment Tree
public class NumArray {
    // Define the SengmentTreeNode class
    class SegmentTreeNode {
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;
        
        // Constructor
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
            this.left= null;
            this.right = null;
        }
    }
    
    // Keep track of the root node of the Segement Tree
    SegmentTreeNode root = null;
    
    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        // Base case
        if (start > end) {
            return null;
        }
        
        // Current level
        // Build the current node
        SegmentTreeNode cur = new SegmentTreeNode(start, end);
        
        if (start == end) {
            cur.sum = nums[end];
        } else {
            int mid = start + (end - start) / 2;
            cur.left = buildTree(nums, start, mid);
            cur.right = buildTree(nums, mid + 1, end);
            cur.sum = cur.right.sum + cur.left.sum;
        }
        return cur;
    }

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    public void update(int i, int val) {
        update(root, i, val);
    }
    
    private void update(SegmentTreeNode cur, int index, int value) {
        // Base case
        if (cur.start == cur.end) {
            cur.sum = value;
            return;
        }
        
        // Current level
        int mid = cur.start + (cur.end - cur.start) / 2;
        
        if (mid >= index) {
            update(cur.left, index, value);
        } else {
            update(cur.right, index, value);
        }
        
        cur.sum = cur.left.sum + cur.right.sum;
    }
    
    public int sumRange(int i, int j) {
        return sumRangeTree(root, i, j);
    }
    
    private int sumRangeTree(SegmentTreeNode cur, int start, int end) {
        // Base case
        if (cur.end == end && cur.start == start) {
            return cur.sum;
        }
        
        // Current level
        int mid = cur.start + (cur.end - cur.start) / 2;
        
        if (mid >= end) {
            return sumRangeTree(cur.left, start, end);
        } else if (mid < start) {
            return sumRangeTree(cur.right, start, end);
        } else {
            return sumRangeTree(cur.left, start, mid) + sumRangeTree(cur.right, mid + 1, end);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */