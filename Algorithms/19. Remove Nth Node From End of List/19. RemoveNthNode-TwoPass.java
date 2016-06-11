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
        int length = 0;
        ListNode current = head;
        
        while(current != null)
        {
            current = current.next;
            length++;
        }
        
        if(length-n == 0)
        {
            return head.next;
        }
        current = head;
        for(int i = 0; i < length-n-1; i++)
        {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }
}