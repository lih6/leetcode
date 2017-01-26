public class Solution {
    public int maxProfit(int[] prices) {
        // corner case
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        if (prices.length < 2) {
            return 0;
        }
        
        // core logic
        // Use left to keep track of the profits before position i
        // Use right to keep track of the profits after position i
        // Then, find the maximum left[i] + right[i]
        int len = prices.length;
        int[] left = new int[len];
        int[] right = new int[len];
        
        int min = prices[0];
        left[0] = 0;
        
        int max = prices[len - 1];
        right[len - 1] = 0;
        
        for (int i = 1; i < len - 1; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
            
            max = Math.max(max, prices[len - i - 1]);
            right[len - i - 1] = Math.max(right[len - i], max - prices[len - i - 1]);
        }
        
        min = Math.min(min, prices[len - 1]);
        left[len - 1] = Math.max(left[len - 2], prices[len - 1] - min);
        
        max = Math.max(max, prices[0]);
        right[0] = Math.max(right[1], max - prices[0]);
        
        int result = 0;
        for (int i = 0; i < len; i++) {
            result = Math.max(result, left[i] + right[i]);
            
        }
        
        return result;
    }
}