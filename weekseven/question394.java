public class Solution {
    public String decodeString(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return "";
        }
        
        if (s.length() <= 2) {
            return s;
        }
        
        // core logic
        String result = "";
        Stack<Integer> numStack = new Stack<>();
        Stack<String> letterStack = new Stack<>();
        
        int index = 0;
        while (index < s.length()) {
            char cur = s.charAt(index);
            if (cur >= '0' && cur <= '9') {
                int endIndex = index + 1;
                while (endIndex < s.length()) {
                    char endChar = s.charAt(endIndex);
                    if (endChar == '[') {
                        numStack.push(Integer.parseInt(s.substring(index, endIndex)));
                        break;
                    }
                    endIndex++;
                }
                index = endIndex;
            } else if (cur == '[') {
                int endIndex = index + 1;
                while (endIndex < s.length()) {
                    char endChar = s.charAt(endIndex);
                    if (endChar == ']' || endChar >= '0' && endChar <= '9') {
                        letterStack.push(s.substring(index + 1, endIndex));
                        break;
                    }
                    endIndex++;
                }
                index = endIndex;
            } else if (cur == ']') {
                int repeat = numStack.pop();
                String str = letterStack.pop();
                String curRes = "";
                while (repeat > 0) {
                    curRes += str;
                    repeat--;
                }
                
                if (!numStack.isEmpty()) {
                    letterStack.push(letterStack.pop() + curRes);
                } else {
                    result += curRes;
                    while (!letterStack.isEmpty()) {
                        result += letterStack.pop();
                    }
                }
                index++;
            } else {
                if (!numStack.isEmpty()) {
                    letterStack.push(letterStack.pop() + cur);
                } else {
                    result += cur;
                }
                index++;
            }
        }
        return result;
    }
}