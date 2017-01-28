/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Solution 1:
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Corner case:
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        
        // Core logic:
        ListNode cur = head;
        int count = k;
        
        while (count > 0 && cur != null) {
            cur = cur.next;
            count--;
        }
        
        if (count > 0) {
            return head;
        }
        
        cur = head;
        ListNode prev = null;
        count = k;
        while (count > 0) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count--;
        }
        
        head.next = reverseKGroup(cur, k);
        
        return prev;
    }
}

// Solution 2:
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Corner case:
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        
        // Core logic:
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode start = head;
        ListNode end = head;
        int count = 1;
        
        while (end != null) {
            if (count == k) {
                ListNode next = end.next;
                prev.next = reverseRange(start, next);
                start.next = next;
                prev = start;
                start = start.next;
                end = next;
                count = 1;
            } else {
                end = end.next;
                count++;
            }
        }
        
        return dummy.next;
    }
    
    private ListNode reverseRange(ListNode head, ListNode tail) {
        ListNode cur = head;
        ListNode prev = null;
        
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
}