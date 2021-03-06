//Author: Tushar Jaiswal
//Creation Date: 05/08/2019

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
        if(head == null)
        { return null; }
        return ReverseListHelper(head, null);
    }

    private ListNode ReverseListHelper(ListNode curr, ListNode parent)
    {
        if(curr.next == null)
        {
            curr.next = parent;
            return curr;
        }
        ListNode head = ReverseListHelper(curr.next, curr);
        curr.next = parent;
        return head;
    }
}
