// 91. Decode Ways
public class Solution {
    public int numDecodings(String s) {
        // Corner case
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        // Dynamic programming: create an array to store count values
        int len = s.length();
        int[] dp = new int[len + 1];
        
        // Start from the end of the array to take care of case "0" more elegantly
        dp[len] = 1;
        dp[len - 1] = s.charAt(len - 1) == '0' ? 0 : 1;
        
        for (int i = len - 2; i >= 0; i--) {
            // If current number is 0, cannot be alone, assign current position to be 0
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            
            // Get the two digit number
            int number = Integer.parseInt(s.substring(i, i + 2));
            // If it cannot be the encoding of a letter, just assign previous value to it
            if (number > 26) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = dp[i + 1] + dp[i + 2];
            }
        }
        
        return dp[0];
    }
}