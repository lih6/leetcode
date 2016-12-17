public class Solution {
    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        
        int begin = 0;
        int end = str.length() - 1;
        while ((str.charAt(begin) == ' ') && (begin <= end)) {
                begin++;
        }
        
        while ((str.charAt(end) == ' ') && (end >= 0)) {
                end--;
        }
        
        str = str.substring(begin, end + 1);
        
        int negativeFlag = 0;
        
        if (str.charAt(0) == '+') {
            str = str.substring(1);
        } else if (str.charAt(0) == '-') {
            negativeFlag = 1;
            str = str.substring(1);
        }
        
        if (str.length() == 0) {
            return 0;
        }
        
        int firstVal = Character.getNumericValue(str.charAt(0));
        if ((firstVal > 9) || (firstVal < 0)) {
            return 0;
        }
        
        int length = str.length();
        int max = 2147483647;
        int min = -2147483648;
        int index = 0;
        int offset = 0;
        int result = 0;
        
        while (index < length) {
            int curVal = Character.getNumericValue(str.charAt(length - 1 - index));
            
            if (curVal != 0) {
                if ((curVal > 9) || (curVal < 0)) {
                    result = 0;
                    offset = index + 1;
                } else {
                    if (negativeFlag == 0) {
                        int newResult = result + curVal * ((int) Math.pow(10, index - offset));
                        if (newResult < result) {
                            if (length < 10) {
                                return 0;
                            } else {
                                return max;
                            }
                        } else {
                            result = newResult;
                        }
                    } else {
                        int newResult = result - curVal * ((int) Math.pow(10, index - offset));
                        if (newResult > result) {
                            if (length < 10) {
                                return 0;
                            } else {
                                return min;
                            }
                        } else {
                            result = newResult;
                        }
                    }
                }
            }
            
            index++;
        }
        
        return result;
    }
}