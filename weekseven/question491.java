public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        
        // core logic
        // Hashset: make sure no duplicates
        // list: hold every increasing sequence
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        helper(set, list, nums, 0);
        return new ArrayList(set);
    }
    
    private void helper(Set<List<Integer>> set, List<Integer> list, int[] nums, int position) {
        // As long as the list is longer than 2, add it to the set
        if (list.size() >= 2) {
            set.add(new ArrayList(list));
        }
        
        for (int i = position; i < nums.length; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
                list.add(nums[i]);
                helper(set, list, nums, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}