//Author: Tushar Jaiswal
//Creation Date: 10/03/2015

/*You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8*/

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
        ListNode sum = new ListNode(0);
        ListNode head = sum;
        int quotient = 0;
        int remainder = 0;
        int total = 0;
        while(l1 != null && l2 != null)
        {
            total = l1.val + l2.val + quotient;
            remainder = total % 10;
            quotient = total / 10;
            sum.next = new ListNode(remainder);
            sum = sum.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null)
        {
            total = l1.val + quotient;
            remainder = total % 10;
            quotient = total / 10;
            sum.next = new ListNode(remainder);
            sum = sum.next;
            l1 = l1.next;
        }
        while(l2 !=null)
        {
            total = l2.val + quotient;
            remainder = total % 10;
            quotient = total / 10;
            sum.next = new ListNode(remainder);
            sum = sum.next;
            l2 = l2.next;
        }
        if(quotient != 0)
        {
            sum.next = new ListNode(quotient);
        }
        return head.next;
    }
}