//Author: Tushar Jaiswal
//Creation Date: 02/01/2017

/*Remove all elements from a linked list of integers that have value val.
Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode RemoveElements(ListNode head, int val) {
        while(head != null && head.val == val)
        { head = head.next; }
        
        ListNode curr = head;
        
        while(curr != null && curr.next != null)
        {
            if(curr.next.val == val)
            {
                curr.next = curr.next.next;
            }
            else
            { curr = curr.next; }
        }
        
        return head;
    }
}