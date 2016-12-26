public class Solution {
    public int strStr(String haystack, String needle) {
        int nLen = needle.length();
        int hLen = haystack.length();
        
        if (nLen == 0) {
            return 0;
        }
        
        if (nLen > hLen) {
            return -1;
        }
        
        if (nLen == hLen) {
           if (needle.equals(haystack)) {
               return 0;
           } else {
               return -1;
           }
        }
        
        for (int i = 0; i < hLen - nLen + 1; i++) {
            String curSub = haystack.substring(i, i + nLen);
            if (curSub.equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
}