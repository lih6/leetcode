// 10. Regular Expression Matching
public class Solution {
    public boolean isMatch(String s, String p) {
        // Corner case
        if (p.length() > 0 && p.charAt(0) == '*') {
            return false;
        }
        
        // Use dynamic programming
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        
        // Assign the first element
        dp[0][0] = true;
        
        // '*' would only occur at even index positions
        for (int i = 1; i < p.length(); i += 2) {
            if (p.charAt(i) == '*') {
                dp[0][i + 1] = dp[0][i - 1];
            }
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) != '*') {
                    // If the current character is not a *, then check whether the current letter matches and
                    // whether the previous part of the string s is matching.
                    dp[i][j] = dp[i - 1][j - 1] && (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1));
                } else {
                    // If the current character is a *, then check whether zero occurrance of the character
                    // followed by * is possible and whether the previous character in string s is matched.
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2)));
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
}