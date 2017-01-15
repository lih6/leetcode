public class Solution {
    public int reverse(int x) {
        // corner case
        if (x > -10 && x < 10) {
            return x;
        }
        
        // core logic
        int count = 0;
        int result = 0;
        int flag = 0;
        int max = Integer.MAX_VALUE / 10;
        
        if (x < 0) {
            x = -x;
            flag = 1;
        }
        
        while (x > 0) {
            int curDigit = x % 10;
            result = result * 10 + curDigit;
            x = x / 10;
            count++;
            
            if (count == 9 && x != 0 && result > max) {
                return 0;
            }
        }
        
        if (flag == 1) {
            result = -result;
        }
        
        return result;
    }
}