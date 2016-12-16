/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        int nineFlag = 0;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode tmp = head;
        ListNode position = dummy;
        
        // Corner case: empty list
        if (head == null) {
            return head;
        }
        
        // Corner case: list with only one node
        if (head.next == null) {
            if (head.val == 9) {
                head.val = 0;
                ListNode newHead = new ListNode(1);
                newHead.next = head;
                head = newHead;
            } else {
                head.val++;
            }
            return head;
        }
        
        // General case
        while(tmp.next != null) {
            if (tmp.next.val != 9) {
                nineFlag = 0;
                position = dummy;
            } else {
                if ((tmp.val != 9) && (tmp.next.next == null)) {
                    tmp.val++;
                    tmp.next.val = 0;
                    return head;
                }
                
                if (nineFlag == 0) {
                    nineFlag = 1;
                    position = tmp;
                }
            }
            tmp = tmp.next;
        }
        
        if (tmp.val == 9) {
            if ((position == head) && (head.val == 9)) {
                ListNode newHead = new ListNode(1);
                newHead.next = head;
                head = newHead;
            } 
            
            while (position != null) {
                if (position.val == 9) {
                    position.val = 0;
                } else {
                    position.val++;
                }
                position = position.next;
            }
        } else {
            tmp.val++;
        }
        
        return head;
    }
}