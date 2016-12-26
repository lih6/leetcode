/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        
        if (l2 == null) {
            return l1;
        }
        
        ListNode first = l1;
        ListNode second = l2;
        ListNode newList = new ListNode(-1);
        if (first.val < second.val) {
            newList.next = first;
            first = first.next;
        } else {
            newList.next = second;
            second = second.next;
        }
        ListNode newHead = newList.next;
        
        while ((first != null) && (second != null)) {
            if (first.val < second.val) {
                newHead.next = first;
                first = first.next;
            } else {
                newHead.next = second;
                second = second.next;
            }
            
            newHead = newHead.next;
        }
        
        if (first == null) {
            newHead.next = second;
        } else {
            newHead.next = first;
        }
        
        return newList.next;
     }
}