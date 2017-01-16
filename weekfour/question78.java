public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (nums == null) {
            return result;
        }
        
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        Arrays.sort(nums);
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        helper(result, list, nums, 0);
        
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int position) {
        result.add(new ArrayList<Integer>(list));
        
        for (int i = position; i < nums.length; i++) {
            list.add(nums[i]);
            helper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}