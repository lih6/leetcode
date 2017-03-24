// 332. Reconstruct Itinerary
public class Solution {
    // Using hashmap for stroing the relationship between airports.
    // Using priorityqueue to make sure the airport names ollow lexico order.
    HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    LinkedList<String> result = new LinkedList<String>();
    
    public List<String> findItinerary(String[][] tickets) {
        // Build the map by going through all the "from" airports and add them into the map
        for (String[] airports : tickets) {
            if (!map.containsKey(airports[0])) {
                map.put(airports[0], new PriorityQueue<String>());
            }
            map.get(airports[0]).add(airports[1]);
        }
        
        // Using DFS to figure out the results
        dfs("JFK");
        return result;
    }
    
    private void dfs(String airport) {
        // Get all the airports that comes after the current airport
        PriorityQueue<String> next = map.get(airport);
        
        // Add all the airports into the return list
        while (next != null && !next.isEmpty()) {
            dfs(next.poll());
        }
        
        // Put the current airport into the return list
        // This need to be at the end to work!
        result.addFirst(airport);
    }
}