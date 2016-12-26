public class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        
        if (aLen == 0) {
            return b;
        }
        
        if (bLen == 0) {
            return a;
        }
        
        // (expression) ? value1 : value2;
        int totalLen = 0;
        int shortLen = 0;
        String longStr = "";
        
        if (aLen > bLen) {
            totalLen = aLen;
            shortLen = bLen;
            longStr = a;
        } else {
            totalLen = bLen;
            shortLen = aLen;
            longStr = b;
        }
        
        StringBuilder result = new StringBuilder();
        
        int carry = 0;
        
        for (int i = 0; i < totalLen; i++) {
            if ((shortLen-i-1) >= 0) {
                int curA = Integer.parseInt(a.substring(aLen-i-1, aLen-i));
                int curB = Integer.parseInt(b.substring(bLen-i-1, bLen-i));
                int curTotal = curA + curB + carry;
                
                if (curTotal >= 2) {
                    carry = 1;
                } else {
                    carry = 0;
                }
                
                if ((curTotal % 2) == 0) {
                    result.append("0");
                } else {
                    result.append("1");
                }
            } else {
                String curStr = longStr.substring(totalLen-i-1, totalLen-i);
                if (carry == 1) {
                    if (Integer.parseInt(curStr) == 1) {
                        result.append("0");
                    } else {
                        result.append("1");
                        carry = 0;
                    }
                } else {
                    result.append(curStr);
                }
            } 
        }
        
        if (carry == 1) {
            result.append("1");
        }
        
        
        return result.reverse().toString();
    }
}