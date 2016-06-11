//Author: Tushar Jaiswal
//Creation Date: 06/11/2016

/*Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy, first, second;
        dummy = new ListNode(0);
        dummy.next = head;
        first = dummy;
        second = dummy;
        
        int i;
        for(i = 0; i <= n; i++)
        {
            second = second.next;
        }
        
        while(second != null)
        {
            first = first.next;
            second = second.next;
        }
        
        first.next = first.next.next;
        return dummy.next;
    }
}