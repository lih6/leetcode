public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
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
        boolean[] isVisited = new boolean[nums.length];
        
        helper(result, list, nums, isVisited);
        
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] isVisited) {
        // base case
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i] || (i != 0 && nums[i] == nums[i - 1] && isVisited[i - 1])) {
                continue;
            }
            
            isVisited[i] = true;
            list.add(nums[i]);
            helper(result, list, nums, isVisited);
            list.remove(list.size() - 1);
            isVisited[i] = false;
        }
    }
}