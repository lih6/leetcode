// 261. Graph Valid Tree
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Corner case
        if (n > 1 && (edges == null || edges.length == 0)) {
            return false;
        }
        
        
        if (n == 0 || edges == null || edges.length == 0 || edges[0].length == 0) {
            return true;
        }
        
        // Using DFS to solve the problem
        // Construct the map and add all the relationship in
        List<List<Integer>> map = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<Integer>());
        }
        
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        // Construct visited list to keep track of each number
        boolean[] visited = new boolean[n];
        if (findCycle(-1, 0, map, visited)) {
            return false;
        }
        
        for (boolean value : visited) {
            if (!value) {
                return false;
            }
        }

        return true;
    }
    
    public boolean findCycle(int prev, int num, List<List<Integer>> map, boolean[] visited) {
        // Base case: if the current number has been visited, cycle found
        if (visited[num]) {
            return true;
        }
        
        // Set the current number to be visited and go through all the numbers that
        // are connected to the current number.
        visited[num] = true;
        for (int next : map.get(num)) {
            if (next != prev && findCycle(num, next, map, visited)) {
                return true;
            }
        }
        
        return false;
    }
}