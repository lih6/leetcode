// DFS solution
public class Solution {
    public int countComponents(int n, int[][] edges) {
        // corner case
        if (n <= 0) {
            return 0;
        }
        
        // core logic
        // map: stores all the edges
        // isVisited: stores information about whether each node has been visited or not
        // num: keeps track of the number of connected compnenets
        List<List<Integer>> map = new ArrayList<List<Integer>>();
        boolean[] isVisited = new boolean[n];
        int num = 0;
        
        // Construct the map based on the number of nodes
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<Integer>());
        }
        
        // Store all the edges into the map
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        // Go through all the nodes starting from 0 to find the number of connected components
        for (int i = 0; i < n; i++) {
            // If current node has been visited, it means that the current node alreay belongs
            // to a previous counted component. Therefore, should ignore the current node.
            if (isVisited[i]) {
                continue;
            }
            // Use a helper function to find all the nodes that is connected to the current node
            helper(map, i, isVisited);
            // Increase num
            num++;
        }
        
        return num;
    }
    
    public void helper(List<List<Integer>> map, int cur, boolean[] isVisited) {
        // Base case: if the current node has been visited, return.
        if (isVisited[cur]) {
            return;
        }
        
        // Mark the current node as visited.
        isVisited[cur] = true;
        // Get all the nodes that is connected to the current node. Do recursion to find their
        // connections and return.
        for (int node : map.get(cur)) {
            helper(map, node, isVisited);
        }
        return;
    }
}

// BFS solution
public class Solution {
    public int countComponents(int n, int[][] edges) {
        // corner case
        if (n <= 0) {
            return 0;
        }
        
        // core logic
        // map: stores all the edges
        // queue: used for bfs to store all nodes that is connected to the current node
        // isVisited: stores information about whether each node has been visited or not
        // num: keeps track of the number of connected compnenets
        List<List<Integer>> map = new ArrayList<List<Integer>>();
        Queue<Integer> queue = new ArrayDeque<Integer>();
        boolean[] isVisited = new boolean[n];
        int num = 0;
        
        // Construct the map based on the number of nodes
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<Integer>());
        }
        
        // Store all the edges into the map
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        // Go through all the nodes starting from 0 to find the number of connected components
        for (int i = 0; i < n; i++) {
            // If current node has been visited, it means that the current node alreay belongs
            // to a previous counted component. Therefore, should ignore the current node.
            if (isVisited[i]) {
                continue;
            }
            
            // push the current node into the queue
            queue.offer(i);
            // Set the current node to be visited
            isVisited[i] = true;
            // As long as the queue is not empty, pull from the queue and push every unvisited
            // node that is connected to the node (that has just been pulled) into the queue.
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int node : map.get(cur)) {
                    if (isVisited[node]) {
                        continue;
                    }
                    queue.offer(node);
                    isVisited[node] = true;
                }
            }
            // Increase num
            num++;
        }
        return num;
    }
}