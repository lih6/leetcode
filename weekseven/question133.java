/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

// Solution 1:
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // corner case
        if (node == null) {
            return null;
        }
        
        // list: keeps track of all the old nodes
        // map: map the old node and corresponded new node
        // index: keeps track of the number of nodes that has been processed
        List<UndirectedGraphNode> list = new ArrayList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        int index = 0;
        
        // Add the current node that's been passed in to the list and the map
        list.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        // Construct a new node for all the nodes in the graph
        while (index < list.size()) {
            UndirectedGraphNode cur = list.get(index);
            // Go through all the neighbors of the current node. Construct a new node and
            // add them into the map if they do not exist in the map. Add the old node into
            // the list as well.
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    list.add(neighbor);
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
            }
            index++;
        }
        
        // After constructing all the nodes, it is time to add all the neighbors for each node
        // Reset the index
        index = 0;
        while (index < list.size()) {
            UndirectedGraphNode cur = list.get(index);
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                map.get(cur).neighbors.add(map.get(neighbor));
            }
            index++;
        }
        
        // Return the first node that has been added to the map
        return map.get(node);
    }
}

// Solution 2:
public class Solution {
    // map: keep track of the label of each node and the new node created for that node
    private HashMap<Integrer, UndirectedGraphNode> map = new HashMap<>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
       return clone(node);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        // corner case
       if (node == null) {
           return null;
       }
       
       // If the label of the current node is in the key set of map, then, return the new node
       // corresponds to that label.
       if (map.containsKey(node.label)) {
           return map.get(node.label);
       }
       
       // Put the label of the current node and the constructed new node into the map
       UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
       map.put(node.label, clone);
       // Do the same thing for all the neighbors of the current node and add all the
       // neighbors of the current node to the new node
       for (UndirectedGraphNode neighbor : node.neighbors) {
           clone.neighbors.add(clone(neighbor));
       }
       
       // Return the newly constructed node
       return clone;
    }
}