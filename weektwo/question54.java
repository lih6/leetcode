public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        
        // corner case
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        if (matrix[0].length == 0) {
            return result;
        }
        
        // core logic
        int m = matrix.length;
        int n = matrix[0].length;
        
        int levelm = (m % 2 == 0) ? (m / 2) : ((m + 1) / 2);
        int leveln = (n % 2 == 0) ? (n / 2) : ((n + 1) / 2);
        int level = (levelm < leveln) ? levelm : leveln;
        
        for (int i = 0; i < level; i++) {
            // top
            for (int j = i; j < (n - i); j++) {
                result.add(matrix[i][j]);
            }
            
            // right
            for (int j = i + 1; j < (m - i); j++) {
                result.add(matrix[j][n - 1 - i]);
            }
            
            // bottom
            if (i != (m - 1 - i)) {
                for (int j = ((n - 1) - (i + 1)); j >= i; j--) {
                    result.add(matrix[m - 1 - i][j]);
                }
            }
            
            // left
            if (i != (n - 1 - i)) {
                for (int j = ((m - 1) - (i + 1)); j >= i + 1; j--) {
                    result.add(matrix[j][i]);
                }
            }
        }
        
        return result;
    }
}