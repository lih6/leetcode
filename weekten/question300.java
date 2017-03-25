// 300. Longest Increasing Subsequence
// 1. Simple approach: 
// Create an array with the length of the input array. If any previous number is smaller than the current
// one, then increment the largest previous count by 1 and put the bew count into the current position. 
// If the current number is smaller than all the previous numbers, just put 1 into the current position.

// 2. Better approach:
public class Solution {
    public int lengthOfLIS(int[] nums) {
        // Corner case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // Use a list to store the current longest increasing sequence
        List<Integer> list = new ArrayList<Integer>();
        
        for (int num : nums) {
            // If the list is empty or the curent number is larger than the largest number in the list,
            // add the current number to the list.
            if (list.size() == 0 || num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                // Use binary search to find the position of the current number
                int start = 0;
                int end = list.size() - 1;
                
                // Pay attention to binary search (easy to mess up)
                while (start < end) {
                    int mid = start + (end - start) / 2;
                    if (list.get(mid) < num) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                
                list.set(start, num);
            }
        }
        
        return list.size();
    }
}