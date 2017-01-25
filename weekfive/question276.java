public class Solution {
    public int numWays(int n, int k) {
        // corner case
        if (n <= 0 || k <= 0) {
            return 0;
        }
        
        // core logic
        // Situation 1:
        // If the first one and the second one have the same color,
        // there are k options for them. The third one has (k - 1)
        // options. Then, in total, there are k * (k - 1) options.
        // Situation 2:
        // If the first one and the second one have different color,
        // there are k * (k - 1) options for them. The third one has
        // k options. Then, in total, there are k * (k - 1) * k
        // options.
        // In general:
        // The third one either does not have the same color as the
        // first one, or does not have the same color as the second
        // one.
        // f(n) = (k - 1) * f(n - 1) + (k - 1) * f(n - 2);
        
        int[] dp = {0, k, k*k, 0};
        
        if (n <= 2) {
            return dp[n];
        }
        
        // start from the third element
        for (int i = 2; i < n; i++) {
            dp[3] = (k - 1) * (dp[1] + dp[2]);
            dp[1] = dp[2];
            dp[2] = dp[3];
        }
        return dp[3];
    }
}