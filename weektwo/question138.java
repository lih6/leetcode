/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // corner case
        if (head == null) {
            return null;
        }
        
        if (head.next == null && head.random == null) {
            return new RandomListNode(head.label);
        }
        
        // core logic
        RandomListNode curnode = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode prev = dummy;
        
        List<RandomListNode> random = new ArrayList<RandomListNode>();
        
        while (curnode != null) {
            // create the new node
            RandomListNode newnode = new RandomListNode(curnode.label);
            
            // keep track of the old random of current node
            RandomListNode oldRandom = curnode.random;
            random.add(oldRandom);
            
            // assign new random = old random
            newnode.random = curnode.random;
            // assign old random = new node
            curnode.random = newnode;
            // link new node to previous node
            prev.next = newnode;
            // advance current node
            curnode = curnode.next;
            prev = prev.next;
        }
        
        curnode = head;
        while (curnode != null) {
            // assign random of the current node in the new linked list
            // to a node in the new list
            if (curnode.random.random != null) {
                curnode.random.random = curnode.random.random.random;
            }
            curnode = curnode.next;
        }
        
        curnode = head;
        int count = 0;
        while (curnode != null) {
            // assign old random back to the old node
            curnode.random = random.get(count);
            count++;
            curnode = curnode.next;
        }
        
        return dummy.next;
    }
}