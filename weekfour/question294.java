public class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        return helper(s.toCharArray());
    }
    
    private boolean helper(char[] str) {
        for (int i = 0; i < str.length - 1; i++) {
            if (str[i] == '+' && str[i + 1] == '+') {
                str[i] = '-';
                str[i + 1] = '-';
                
                boolean second = helper(str);
                
                str[i] = '+';
                str[i + 1] = '+';
            
                if (!second) {
                    return true;
                }
            }
        }
        
        return false;
    }
}