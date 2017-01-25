public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // corner case
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2; 
        if (sum < desiredTotal) {
            return false;
        }
        
        // core logic
        // At start, all the numbers can be used. Therefore, set all of
        // their status to 1.
        int status = (1 << maxChoosableInteger) - 1;
        
        // Remember: cannot use primitive types here
        Map<Integer, Boolean> dp = new HashMap<Integer, Boolean>();
        return helper(dp, status, desiredTotal, maxChoosableInteger);
    }
    
    private boolean helper(Map<Integer, Boolean> dp, int status, int total, int range) {
        if (total < 0) {
            return false;
        }
        
        for (int i = range - 1; i >= 0; i--) {
            // if the current number hasn't been used yet
            if ((status & (1 << i)) != 0) { 
                // calculate the new status
                int newStatus = status ^ (1 << i);
                if (!dp.containsKey(newStatus)) {
                    // calculate the result of second player's move and put it into dp
                    dp.put(newStatus, helper(dp, newStatus, total - (i + 1), range));
                }
                // if the current value is larger than total or the second player
                // will never win, then return true
                if ((i + 1 >= total) || (!dp.get(newStatus))) {
                    dp.put(status, true);
                    return true;
                }
            }
        }
        dp.put(status, false);
        return false;
    }
}