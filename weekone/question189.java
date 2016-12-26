// Method No.1:
public class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (k >= length) {
            k = k % length;
        }
        
        if (k == 0) {
            return;
        }
    
        if (length == 0) {
            return;
        }
        
        int[] newNums = new int[length];
        int startIndex = length - k;
        
        for (int i = 0; i < length; i++) {
            newNums[i] = nums[i];
        }
        
        for (int i = 0; i < length; i++) {
            nums[i] = newNums[startIndex];
            startIndex = (startIndex + 1) % length;
        }
        
    }
}

// Method No.2:
public class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (k >= length) {
            k = k % length;
        }
        
        if (k == 0) {
            return;
        }
    
        if (length == 0) {
            return;
        }
        
        int num = 0;
        for (int i = 0; num < length; i++) {
            int count = i;
            int hold = nums[i];
            do {
                int tmp = nums[count];
                nums[count] = hold;
                hold = tmp;
                count = (count + k) % length;
                num++;
            } while (count != i);
            nums[i] = hold;
        }
    }
}