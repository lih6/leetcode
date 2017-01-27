public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // Corner case:
        if (s == null) {
            return 0;
        }
        
        if (s.length() < 3) {
            return s.length();
        }
        
        // Core logic:
        // Keep track of the left boundary and right boundary using left and right.
        // Start the loop from the second element.
        // If the current char == previous char, do nothing and continue.
        // If the current char != char at right bar and right char is not the second
        // one in the string, update the maximum length and move the left bar to the
        // left of the current char.
        // Otherwise, update the right bar to the left of the current char.
        int left = 0;
        int right = -1;
        int max = 0;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            
            // The current char is definitely different than the previous char.
            // Therefore, update left to be right + 1 to contain previous two different chars.
            if (right != -1 && s.charAt(i) != s.charAt(right)) {
                // i - left: does not include the current char
                max = Math.max(max, i - left);
                left = right + 1;
            }
            right = i - 1;
        }
        
        // (s.length() - 1) - left + 1 or s.length() - (left + 1) + 1
        return Math.max(max, s.length() - left);
    }
}