public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length < 3) {
            return result;
        }
        
        Arrays.sort(nums);
        
        Set<List<Integer>> checkSet = new HashSet<List<Integer>>();
        
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int rest = 0 - nums[i];
            
            while (left < right) {
                if (nums[left] + nums[right] == rest) {
                    List<Integer> newEle = new ArrayList<Integer>();
                    newEle.add(nums[i]);
                    newEle.add(nums[left]);
                    newEle.add(nums[right]);
                    if (checkSet.add(newEle)) {
                        result.add(newEle);
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < rest) {
                    left++;
                } else {
                    right--;
                }
                
            }
        }
        
        return result;
    }
}