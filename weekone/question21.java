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
        ListNode newList = new ListNode(-1); // change newList to dummy
        if (first.val < second.val) {
            newList.next = first;
            first = first.next;
        } else {
            newList.next = second;
            second = second.next;
        }// duplicate logic as bellow.
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
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode l3 = dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                l3.next = l1;
                l3 = l3.next;
                l1 = l1.next;
            }else{
                l3.next = l2;
                l3 = l3.next;
                l2 = l2.next;
            }
        }

        if(l1!=null)
            l3.next = l1;
        if(l2!=null)
            l3.next = l2;
        return dummy.next;
    }
