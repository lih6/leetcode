/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        
        if (head.next == null) {
            return head;
        }
        
        int count = 0;
        int overFlag = 0;
        ListNode fast = head;
        ListNode slow = head;
        
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                fast = head;
                overFlag = 1;
                break;
            }
            fast = fast.next;
            count++;
        }
        
        if (fast == null) {
            return head;
        }
        
        if (overFlag == 1) {
            int newK = k % count;
            if (newK == 0) {
                return head;
            }
            
            for (int i = 0; i < newK; i++) {
                fast = fast.next;
            }
        }
        
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        fast.next = head;
        head = slow.next;
        slow.next = null;
        
        return head;
    }
}