public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // core logic
        Arrays.sort(nums);
        int min = 0;
        int absDiff = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = sum - target;
                if (diff == 0) {
                    return target;
                } else if (diff < 0) {
                    left++;
                } else {
                    right--;
                }
                
                if (absDiff > Math.abs(diff)) {
                    absDiff = Math.abs(diff);
                    min = sum;
                }
            }
        }
        
        return min;
    }
}