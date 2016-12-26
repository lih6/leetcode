/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // corner case
        if (head == null || head.next == null) {
            return head;
        }
        
        // core logic
        ListNode tracker = head;
        ListNode curnode = head.next;
        
        while (curnode != null) {
            if (curnode.val == tracker.val) {
                tracker.next = curnode.next;
                curnode = curnode.next;
            } else {
                curnode = curnode.next;
                tracker = tracker.next;
            }
        }
        
        return head;
    }
}