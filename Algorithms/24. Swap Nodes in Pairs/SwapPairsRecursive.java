//Author: Tushar Jaiswal
//Creation Date: 05/04/2019

/*Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes, only nodes itself may be changed.

Example: Given 1->2->3->4, you should return the list as 2->1->4->3.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head != null && head.next != null)
        {
            ListNode second = head.next;
            head.next = second.next;
            second.next = head;
            head = second;
            head.next.next = swapPairs(head.next.next);
        }
        return head;
    }
}
