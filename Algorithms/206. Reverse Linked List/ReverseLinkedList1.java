//Author: Tushar Jaiswal
//Creation Date: 02/18/2017

/*Reverse a singly linked list.
Hint: A linked list can be reversed either iteratively or recursively. Could you implement both?*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode temp = null;
        
        while(head != null)
        {
            temp = new ListNode(head.val);
            temp.next = newHead;
            newHead = temp;
            head = head.next;
        }
        
        return newHead;
    }
}