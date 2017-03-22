// 315. Count of Smaller Numbers After Self
// Solution 1: sorted list
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        // construct the return list
        List<Integer> result = new ArrayList<Integer>();
        
        // corner case
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // construct a list to store sorted value of the list
        List<Integer> sorted = new ArrayList<Integer>();
        
        // start from the end of the list to prevent access the int array multiple times
        for (int i = nums.length - 1; i >= 0; i--) {
            // get the index of the current num
            int index = findIndex(sorted, nums[i]);
            // add the current num to the index position in the sorted list
            sorted.add(index, nums[i]);
            // add the index (# of nums smaller than current num) of the current num to 
            // the beginning of the return list
            result.add(0, index);
        }
        
        return result;
    }
    
    private int findIndex(List<Integer> sorted, int target) {
        // corner case
        if (sorted == null || sorted.size() == 0) {
            return 0;
        }
        
        int start = 0;
        int end = sorted.size() - 1;
        
        if (sorted.get(start) > target) {
            return 0;
        }
        
        if (sorted.get(end) < target) {
            return end + 1;
        }
        
        // core logic
        // use binary search to find the index of the current num in the sorted list
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // be careful here
            if (sorted.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (sorted.get(start) == target) {
            return start;
        } else {
            return end;
        }
    }
}