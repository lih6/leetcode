// 399. Evaluate Division
public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // Corner case
        if (queries == null || queries.length == 0) {
            return null;
        }
        
        // Construct return value
        double[] res = new double[queries.length];
        
        // Corner case
        if (equations == null || equations.length == 0) {
            return res;
        }
        
        // Construct map by putting all the variables and possible calculations into the map
        Map<String, Map<String, Double>> map = new HashMap<String, Map<String, Double>>();
        for (int i = 0; i < values.length; i++) {
            Map<String, Double> curm;
            if (!map.containsKey(equations[i][0])) {
                curm = new HashMap<String, Double>();
            } else {
                curm = map.get(equations[i][0]);
            }
            
            curm.put(equations[i][1], values[i]);
            map.put(equations[i][0], curm);
            
            if (!map.containsKey(equations[i][1])) {
                curm = new HashMap<String, Double>();
            } else {
                curm = map.get(equations[i][1]);
            }
            
            curm.put(equations[i][0], 1.0 / values[i]);
            map.put(equations[i][1], curm);
        }
        
        // Construct the return array
        for (int i = 0; i < queries.length; i++) {
            String[] cur = queries[i];
            
            // If the current variables do not exist, put -1.0 and continue
            if (!map.containsKey(cur[0]) || !map.containsKey(cur[1])) {
                res[i] = -1.0;
                continue;
            }
            
            // If the current variables equal to each other, put 1.0 and continue
            if (cur[0].equals(cur[1])) {
                res[i] = 1.0;
                continue;
            }
            
            // If the current variables have direct relationships, get that value and continue
            Map<String, Double> curm = map.get(cur[0]);
            if (curm.containsKey(cur[1])) {
                res[i] = curm.get(cur[1]);
                continue;
            }
            
            for (String key : map.keySet()) {
                System.out.println(key);
            }
            
            // If the current variables do not have direct relationships, use DFS to find their relationship
            // Use a hashset to keep track of visited variables
            Set<String> visited = new HashSet<String>();
            res[i] = dfs(cur[0], cur[1], 1.0, visited, map);
        }
        
        return res;
    }
    
    public double dfs(String from, String to, double distance, Set<String> visited, Map<String, Map<String, Double>> map) {
        if (!visited.contains(from)) {
            // Mark current from as visited
            visited.add(from);
            
            Map<String, Double> curm = map.get(from);
            
            // If from has direct relationship with to, return the current distance times from to to's distance
            if (curm.containsKey(to)) {
                return distance * curm.get(to);
            }
            
            for (String next : curm.keySet()) {
                double nextlevel = dfs(next, to, distance * curm.get(next), visited, map);
                
                // If result found, return
                if (nextlevel != -1.0) {
                    return nextlevel;
                }
            }
        }
        
        return -1.0;
    }
}