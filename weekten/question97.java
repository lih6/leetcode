// 97. Interleaving String
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Corner case
        if (s1 == null || s1.length() == 0) {
            return s2.equals(s3);
        }
        
        if (s2 == null || s2.length() == 0) {
            return s1.equals(s3);
        }
        
        int len1 = s1.length();
        int len2 = s2.length();
        
        if (s3.length() != len1 + len2) {
            return false;
        }
        
        // Dynamic programming
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        
        // Initialize the first row and the first column of the array
        dp[0][0] = true;
        
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }
        
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = s2.substring(0, i).equals(s3.substring(0, i));
        }
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] |= dp[i - 1][j];
                }
                
                if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }
        
        return dp[len1][len2];
    }
}