public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        
        // corner case
        if (n == 0) {
            return result;
        }
        
        // core logic
        int count = 1;
        int level = (n % 2 == 0) ? (n / 2) : ((n + 1) / 2);
        
        for (int i = 0; i < level; i++) {
            // top
            for (int j = i; j < (n - i); j++) {
                result[i][j] = count;
                count++;
            }
            
            // right
            for (int j = i + 1; j < (n - i); j++) {
                result[j][n - 1 - i] = count;
                count++;
            }
            
            // bottom
            for (int j = ((n - 1) - (i + 1)); j >= i; j--) {
                result[n - 1 - i][j] = count;
                count++;
            }
            
            // left
            for (int j = ((n - 1) - (i + 1)); j >= i + 1; j--) {
                result[j][i] = count;
                count++;
            }
        }
        
        return result;
    }
}