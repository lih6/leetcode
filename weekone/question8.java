public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int begin = 0;
        int end = str.length() - 1;
        str = str.trim();

        int negativeFlag = 0;

        if (str.charAt(0) == '+') {
            str = str.substring(1);
        } else if (str.charAt(0) == '-') {
            negativeFlag = 1;
            str = str.substring(1);
        } // clean your logic

        if (str.length() == 0) {
            return 0;
        }

        int firstVal = Character.getNumericValue(str.charAt(0));
        if ((firstVal > 9) || (firstVal < 0)) {
            return 0;
        }

        int length = str.length();
        int max = 2147483647;
        int min = -2147483648;// NO HARDCODE please use Integer.MAX_VALUE
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
                    if (negativeFlag == 0) { // no need to check every time
                        int newResult = result + curVal * ((int) Math.pow(10, index - offset));
                        // no need to use newResult. Math.pow hurts performance
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
// Please refer to the following solution
// public int myAtoi(String str) {
//         if(str == null){
//             return 0;
//         }
//         str = str.trim();
//         if(str.length() == 0){
//             return 0;
//         }
//         long total = 0;
//         int sign = 1;
//         int index = 0;
//         if(str.charAt(index) == '+' || str.charAt(index) == '-'){
//             sign = str.charAt(index) == '+' ? 1 : -1;
//             index ++;
//         }
//         while(index < str.length()){
//             int digit = str.charAt(index) - '0';
//             if(digit < 0 || digit > 9) break;
//
//             //check if total will be overflow after 10 times and add digit
//             if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
//                 return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//
//             total = 10 * total + digit;
//             index ++;
//         }
//         return (int)total * sign;
//     }
