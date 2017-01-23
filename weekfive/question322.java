public class Solution {
    public int coinChange(int[] coins, int amount) {
        // corner case
        if (coins == null || amount < 0) {
            return -1;
        }
        
        if (amount == 0) {
            return 0;
        }
        
        // core logic
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}