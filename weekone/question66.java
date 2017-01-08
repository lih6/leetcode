public class Solution {
    public int[] plusOne(int[] digits) {
        int position = -1;
        
        int size = digits.length;
        
        // Corner case: empty array
        if (digits.length == 0) {
            return digits;
        }
        
        // Corner case: array with only one element
        if (size == 1) {
            if (digits[0] == 9) {
                int[] newDigits = new int[2];
                newDigits[0] = 1;
                newDigits[1] = 0;
                return newDigits;
            } else {
                digits[0]++;
                return digits;
            }
        }
        
        // Corner case: only the second to last digit needs to be incremented
        if ((digits[size-1] == 9) && (digits[size-2] != 9)) {
            digits[size-2]++;
            digits[size-1] = 0;
            return digits;
        }
        
        // General case
        for (int i = 0; i < size-1; i++) {
            if (digits[i+1] == 9) {
                if (position == -1) {
                    position = i;
                }
            } else {
                if (position != -1) {
                    position = -1;
                }
            }
        }
        
        if (position != -1) {
            if ((position == 0) && (digits[0] == 9)) {
                int[] newDigits = new int[size+1];
                newDigits[0] = 1;
                for (int i = 1; i < size+1; i++) {
                    newDigits[i] = 0;
                }
                return newDigits;
            } else {
                for (int i = position; i < size; i++) {
                    if (digits[i] == 9) {
                        digits[i] = 0;
                    } else {
                        digits[i]++;
                    }
                }
            }
        } else {
            digits[size-1]++;
        }
        
        return digits;
    }
}