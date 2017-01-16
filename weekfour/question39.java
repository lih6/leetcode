public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (candidates == null) {
            return result;
        }
        
        if (candidates.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        helper(result, list, candidates, target, 0);
        
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int position) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        if (target < 0) {
            return;
        }
        
        for (int i = position; i < candidates.length; i++) {
            list.add(candidates[i]);
            target -= candidates[i];
            helper(result, list, candidates, target, i);
            list.remove(list.size() - 1);
            target += candidates[i];
        }
    }
}