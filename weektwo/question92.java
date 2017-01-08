/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // corner case
        if (head == null || head.next == null || m == n) {
            return head;
        }
        
        // core logic
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode cur = dummy;
        int count = 0;
        
        while (count < m - 1) {
            count++;
            cur = cur.next;
        }
        
        ListNode newMiddleHead = reverseList(cur.next, n - m);
        cur.next = newMiddleHead;
        
        return dummy.next;
    }
    
    private ListNode reverseList(ListNode head, int length) {
        // corner case
        if (head == null || head.next == null) {
            return head;
        }
        
        // core logic
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = head;
        int count = 0;
        
        while (count < length) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }
        
        head.next = cur.next;
        cur.next = prev;
        
        return cur;
    }
}