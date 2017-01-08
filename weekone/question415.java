public class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0) {
            return num2;
        }
        if (len2 == 0) {
            return num1;
        }
        
        if (num1.equals("0")) {
            return num2;
        }
        
        if (num2.equals("0")) {
            return num1;
        }
        
        int longLen = 0;
        int shortLen = 0;
        String shortStr = "";
        String longStr = "";
        if (len1 > len2) {
            longLen = len1;
            shortLen = len2;
            longStr = num1;
            shortStr = num2;
        } else {
            longLen = len2;
            shortLen = len1;
            longStr = num2;
            shortStr = num1;
        }
        
        int carry = 0;
        String result = "";
        for (int i = 0; i < longLen; i++) {
            if (i >= shortLen) {
                if (carry == 0) {
                    result = longStr.substring(0, longLen - i) + result;
                    break;
                } else {
                    int longNum = Character.getNumericValue(longStr.charAt(longLen - 1 - i));
                    int total = longNum + carry;
                    if (total > 9) {
                        total = total - 10;
                        carry = 1;
                    } else {
                        carry = 0;
                    }
                    result = "" + total + result;
                }
            } else {
                int longNum = Character.getNumericValue(longStr.charAt(longLen - 1 - i));
                int shortNum = Character.getNumericValue(shortStr.charAt(shortLen - 1 - i));
                
                int total = shortNum + longNum + carry;
                if (total > 9) {
                    total = total - 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                
                result = "" + total + result;
            }
        }
        
        if (carry == 1) {
            result = "1" + result;
        }
        
        return result;
    }
}