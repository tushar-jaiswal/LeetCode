//Author: Tushar Jaiswal
//Creation Date: 05/09/2019

/*Reverse a singly linked list.

Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null)
        { return head; }
        ListNode result = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
}
