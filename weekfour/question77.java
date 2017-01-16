public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (n == 0 || k == 0) {
            return result;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        helper(result, list, n, k, 1);
        
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> list, int n, int k, int pos) {
        if (list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = pos; i <= n; i++) {
            if (list.contains(i)) {
                continue;
            }
            
            list.add(i);
            helper(result, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}