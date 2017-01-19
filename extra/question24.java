/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // corner case
        if (head == null || head.next == null) {
            return head;
        }
        
        // core logic
        // dummy -> 1(head) -> 2 -> 3 -> 4 -> null
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // dummy(prev) -> 1(head) -> 2 -> 3 -> 4 -> null
        ListNode prev = dummy;
        
        while (head != null && head.next != null) {
            // 3(rest) -> 4 -> null
            ListNode rest = head.next.next;
            // 2 -> 1(head)
            head.next.next = head;
            // dummy(prev) -> 2 -> 1(head)
            prev.next = head.next;
            // 1(head) -> 3(rest) -> 4 -> null => dummy(prev) -> 2 -> 1(head) -> 3(rest) -> 4 -> null
            head.next = rest;
            // dummy -> 2 -> 1(prev, head) -> 3(rest) -> 4 -> null
            prev = head;
            // dummy -> 2 -> 1(prev) -> 3(head, rest) -> 4 -> null
            head = rest;
        }
        
        return dummy.next;
    }
}