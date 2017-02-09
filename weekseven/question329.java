public class Solution {
    //          L    R   U   D
    int[] dx = {-1,  1,  0,  0};
    int[] dy = { 0,  0, -1,  1};
    
    public int longestIncreasingPath(int[][] matrix) {
        // corner case
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        // core logic
        // Memorized search: keep track of the longest length starts
        // from each cell.
        int[][] track = new int[matrix.length][matrix[0].length];
        int max = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, track, i, j));
            }
        }
        
        return max;
    }
    
    private int dfs(int[][] matrix, int[][] track, int row, int col) {
        // If the cell has been visited, just return the current value.
        if (track[row][col] != 0) {
            return track[row][col];
        }
        
        // Try the four possible ways to move one by one.
        for (int i = 0; i < 4; i++) {
            int x = row + dx[i];
            int y = col + dy[i];
            
            // If found one value nearby that is larger than the current cell, update
            // the current cell with the larger one between the current value of the
            // current cell and the longest length starting from the cell labeled (x, y).
            if (x >= 0 && y >= 0 && x < matrix.length 
                && y < matrix[0].length && matrix[row][col] < matrix[x][y]) {
                track[row][col] = Math.max(track[row][col], dfs(matrix, track, x, y));
            }
        }
        
        // Update the cell value (include the current cell to calculation) before returning it
        return ++track[row][col];
    }
}