// Method 1:
public class Solution {
    public String reverseString(String s) {
        int length = s.length();
        if ((length == 0) || (length == 1)) {
            return s;
        }
        
        StringBuilder result = new StringBuilder(length);
        for (int i = length - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
        
        return result.toString();
    }
}

// Method 2:
public class Solution {
    public String reverseString(String s) {
        int length = s.length();
        if ((length == 0) || (length == 1)) {
            return s;
        }
        
        char[] result = s.toCharArray();
        for (int i = 0; i < length / 2; i++) {
            char tmp = result[i];
            result[i] = result[length - 1 - i];
            result[length - 1 - i] = tmp;
        }
        
        return new String(result);
    }
}