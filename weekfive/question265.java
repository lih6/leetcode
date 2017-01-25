public class Solution {
    public int minCostII(int[][] costs) {
        // corner case
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        // core logic
        // Keep track of min, second samllest cost, and the last color index used
        int preMin = 0;
        int preSecondMin = 0;
        int preIndex = -1;
        
        for (int i = 0; i < costs.length; i++) {
            int curMin = Integer.MAX_VALUE;
            int curSecondMin = Integer.MAX_VALUE;
            int curIndex = -1;
            
            for (int j = 0; j < costs[0].length; j++) {
                // If the current color index is the same as the previous one,
                // use the second smallest min to calculate. Otherwise, use the 
                // current min to calculate.
                if (preIndex == j) {
                    costs[i][j] += preSecondMin;
                } else {
                    costs[i][j] += preMin;
                }
                
                // Update current min, second smallest value and index
                if (curMin > costs[i][j]) {
                    curSecondMin = curMin;
                    curMin = costs[i][j];
                    curIndex = j;
                } else if (curSecondMin > costs[i][j]) {
                    curSecondMin = costs[i][j];
                }
            }
            
            // Update previous values
            preMin = curMin;
            preSecondMin = curSecondMin;
            preIndex = curIndex;
        }
        
        // Return the minimum cost 
        return preMin;
    }
}