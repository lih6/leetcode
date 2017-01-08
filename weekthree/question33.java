public class Solution {
    public int search(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        // core logic
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[mid] > nums[start]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                start++; // avoid duplicates
            }
        }
        
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else {
            return -1;
        }
    }
}