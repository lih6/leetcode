/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // corner case
        if (l1 == null) {
            return l2;
        }
        
        if (l2 == null) {
            return l1;
        }
        
        // core logic
        ListNode head = null;
        Deque<Integer> first = getStack(l1);
        Deque<Integer> second = getStack(l2);
        int carry = 0;
        
        while (!first.isEmpty() || !second.isEmpty()) {
            int firstVal = 0;
            if (!first.isEmpty()) {
                firstVal = first.removeLast();
            }
            
            int secondVal = 0;
            if (!second.isEmpty()) {
                secondVal = second.removeLast();
            }
            
            int cur = firstVal + secondVal + carry;
            if (cur > 9) {
                cur -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            
            ListNode curDigit = new ListNode(cur);
            curDigit.next = head;
            head = curDigit;
        }
        
        if (carry == 1) {
            ListNode highCarry = new ListNode(1);
            highCarry.next = head;
            head = highCarry;
        }
        
        return head;
    }
    
    private Deque<Integer> getStack(ListNode list) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        ListNode cur = list;
        
        while (cur != null) {
            stack.addLast(cur.val);
            cur = cur.next;
        }
        
        return stack;
    }
}