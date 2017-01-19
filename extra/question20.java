public class Solution {
    public boolean isValid(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return true;
        }
        
        if (s.length() % 2 == 1) {
            return false;
        }
        
        // core logic
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
                continue;
            } 
            
            if (!stack.isEmpty()) {
                char prev = stack.pop();
                if (!((prev == '(' && cur == ')') 
                    || (prev == '[' && cur == ']') 
                    || (prev == '{' && cur == '}'))) {
                     return false;
                }
            } else {
                return false;
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        }
        
        return true;
    }
}