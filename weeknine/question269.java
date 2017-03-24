public class Solution {
    public String alienOrder(String[] words) {
        // Using BFS to solve the problem
        // Corner case
        if (words == null || words.length == 0) {
            return new String();
        }
        
        // Construct the relationship map, indegree table, and return value
        Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        Map<Character, Integer> indegree = new HashMap<Character, Integer>();
        StringBuilder res = new StringBuilder();
        
        initialize(words, map, indegree);
        buildMap(words, map, indegree);
        BFS(map, indegree, res);
        
        return res.length() == indegree.size() ? res.toString() : new String();
    }
    
    // Initialize the relationship map and the indegree table with all the characters appear in "words".
    private void initialize(String[] words, Map<Character, Set<Character>> map, Map<Character, Integer> indegree) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.put(c, new HashSet<Character>());
                indegree.put(c, 0);
            }
        }
    }
    
    // Build the relationship map and the indegree table by comparing characters in every two consecutive strings in "words".
    // Since the strings in "words" are sorted, there is no need to compare every two strings.
    private void buildMap(String[] words, Map<Character, Set<Character>> map, Map<Character, Integer> indegree) {
        for (int i = 0; i < words.length - 1; i++) {
            // Get the two consecutive strings
            String first = words[i];
            String second = words[i + 1];
            
            // Create a hashset to keep track of all the from-to relationships between characters and prevent duplicates.
            // Set<String> edges = new HashSet<String>();
            
            for (int j = 0; j < first.length() && j < second.length(); j++) {
                // Get the two characters at the same position from two strings.
                char from = first.charAt(j);
                char to = second.charAt(j);
                
                // If they are equal, cannot compare at the current position. Continue.
                if (from == to) {
                    continue;
                }
                
                // If the current relationship is in "edges", then it has already been recorded. 
                // Since the current two characters are different and the two strings cannot be 
                // compared further, break out of the loop.
                /*if (edges.contains(from + "" + to)) {
                    System.out.println(edges.contains(from + "" + to));
                    break;
                }*/
                
                // Since contains does not work for some reason, changed to another strategy shown below.
                Set<Character> set = map.get(from);
                boolean flag = false;
                for (char c : set) {
                    if (c == to) {
                        flag = true;
                        break;
                    }
                }
                
                if (!flag) {
                    map.get(from).add(to);
                    indegree.put(to, indegree.get(to) + 1);
                }
                
                // Add the new relationship found to "edges" and the map.
                // Increase the indegree for "to".
                // edges.add(from + "" + to);
                // map.get(from).add(to);
                // indegree.put(to, indegree.get(to) + 1);
                
                // The two strings cannot be compared further, break out of the loop.
                break;
            }
        }
    }
    
    // Process the relationship map and indegree table in BFS manner and figure out letter order in the dictionary.
    private void BFS(Map<Character, Set<Character>> map, Map<Character, Integer> indegree, StringBuilder res) {
        // Construct a queue to implement BFS
        Queue<Character> queue = new ArrayDeque<Character>();
        
        // Push all the characters with indegree 0 to the queue
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }
        
        // Start processing the queue until it's empty
        while (!queue.isEmpty()) {
            // Get the current character from the queue
            char c = queue.poll();
            // Append the current character to the return value
            res.append(c);
            
            // Get all the letters that come after "c" from the relationship map
            for (char next : map.get(c)) {
                // If the indegree of "next" is 1, then put it into the queue
                int inval = indegree.get(next);
                if (inval == 1) {
                    queue.offer(next);
                }
        
                // Decrease the indegree of "next" by 1
                indegree.put(next, inval - 1);
            }
        }
    }
}