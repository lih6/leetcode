public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // corner case
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // core logic
        String result = strs[0];
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            while (j < strs[i].length() 
                && j < result.length() 
                && strs[i].charAt(j) == result.charAt(j)) {
                j++;
            }
            
            if (j == 0) {
                return "";
            }
            
            if (j < result.length()) {
                result = result.substring(0, j);
            }
        }
        
        return result;
    }
}