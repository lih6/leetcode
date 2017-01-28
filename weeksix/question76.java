public class Solution {
    public String minWindow(String s, String t) {
        // corner case
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        
        // core logic
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        
        char[] sarr = s.toCharArray();
        int start = 0, end = 0, count = t.length(), startIndex = 0, minLen = Integer.MAX_VALUE;
        while (end < sarr.length) {
            if (map[sarr[end]]-- > 0) {
                count--;
            }
            
            end++;
            
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                
                if (map[sarr[start]]++ == 0) {
                    count++;
                }
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : new String(sarr, startIndex, minLen);
    }
}