public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        // Corner case:
        // nums array is null or it contains less than three numbers.
        if (nums == null || nums.length < 3) {
            return result;
        }
        
        // Core logic:
        // Sort the array first. It will be easier to get rid of duplicates
        // this way.
        Arrays.sort(nums);
        
        // The outer for loop will go through every element in the array
        // to find results. The inner loop will start after the ith element.
        // It will iterate through the rest of the array to find whether 
        // there is a match or not.
        for (int i = 0; i < nums.length - 2; i++) {
            // If the current number is a duplicate, move to the next one.
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Since the array is sorted, use two scanners: 
            // One start from the left after i-th element and the other start
            // form the right.
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // If the sum == 0, then find one result, add it to the result
                // list and update left and right. If sum < 0, left too small,
                // increment left. If sum > 0, right to large, decrease right.
                if (sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    
                    left++;
                    // Get rid of dulicates
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    
                    right--;
                    // Get rid of duplicates
                    while (right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }
}