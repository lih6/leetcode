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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode tracker = dummy;
        ListNode curnode = head;
        
        int flag = 0;
        while (curnode.next != null) {
            if (curnode.val == curnode.next.val) {
                flag = 1;
            } else {
                if (flag == 1) {
                    flag = 0;
                    tracker.next = curnode.next;
                } else {
                    tracker = tracker.next;
                }
            }
            curnode = curnode.next;
        }
        
        if (flag == 1) {
            tracker.next = curnode.next;
        }
        
        return dummy.next;
    }
}