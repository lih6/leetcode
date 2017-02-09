public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        // This problem is equal to finding target = sum(p) - sum(n)
        // Where p = numbers with a plus sign in front, and n = numbers with a minus sign in front
        // target = sum(p) - sum(n)
        // target + sum(p) + sum(n) = sum(p) - sum(n) + sum(p) + sum(n)
        // target + sum(nums) = 2 * sum(p)
        // sum(p) = (target + sum(nums)) / 2;
        // This problem becomes finding all the subsets of nums which is half of target + sum(nums)
        // sum(p) should also be an even number since it is a multiple of two
        
        // corner case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // core logic
        // calculate the sum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // calculate the twice of the target
        int target = sum + S;
        
        // corner case
        if (sum < S || target % 2 != 0) {
            return 0;
        }
        
        // calculate the real target
        target = target >>> 1;
        return helper(nums, target);
    }
    
    private int helper(int[] nums, int target) {
        // dp array represents the number of ways to get to each number in the nums array
        int[] dp = new int[target + 1];
        // There is only one way to get to dp[0]
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}