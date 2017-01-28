public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // Corner case:
        if (k == 0 || s == null) {
            return 0;
        }
        
        if (s.length() <= k) {
            return s.length();
        }
        
        // Core logic
        int left = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
            
            if (map.size() > k) {
                max = Math.max(max, i - left);
                while (map.size() > k) {
                    char cc = s.charAt(left);
                    if (map.get(cc) == 1) {
                        map.remove(cc);
                    } else {
                        map.put(cc, map.get(cc) - 1);
                    }
                    left++;
                }
            }
        }
        
        return Math.max(max, s.length() - left);
    }
}