public class Solution {
    public boolean isPalindrome(int x) {
        // corner case
        if (x < 0) {
            return false;
        }
        
        if (x < 10) {
            return true;
        }
        
        // core logic
        int tens = 1;
        while (x / tens >= 10) {
            tens *= 10;
        }
        
        while (x >= 10 || tens >= 10) {
            if (x % 10 == x / tens) {
                x = (x % tens) / 10;
                tens /= 100;
            } else {
                return false;
            }
        }
        
        return true;
    }
}