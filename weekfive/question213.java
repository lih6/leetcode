public class Solution {
    public int rob(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        // core logic
        int size = nums.length;
        // There are two situations to be considered:
        // 1. nums[0] is included and nums[size - 1] is not.
        // 2. nums[0] is not included and nums[size - 1] is.
        // A helper function is required to make that work.
        int maxOne = helper(nums, 0, size - 2);
        int maxTwo = helper(nums, 1, size - 1);
        
        return Math.max(maxOne, maxTwo);
    }
    
    private int helper(int[] nums, int start, int end) {
        // corner case
        if (start == end) {
            return nums[start];
        }
        
        // core logic
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            // Either choose the one before the current or
            // the current one plus the the one before the one before
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        
        return dp[end];
    }
}