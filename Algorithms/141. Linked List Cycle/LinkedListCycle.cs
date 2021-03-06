//Author: Tushar Jaiswal
//Creation Date: 07/20/2016
/*Given a linked list, determine if it has a cycle in it.
Follow up:
Can you solve it without using extra space?*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public bool HasCycle(ListNode head) {
        ListNode slow, fast;
        
        if(head == null)
        { return false; }
        
        slow = head;
        fast = head.next;
        
        while(slow != null && fast != null)
        {
            if(slow == fast)
            {
                return true;
            }
            slow = slow.next;
            if(fast.next != null)
            {
                fast = fast.next.next;
            }
            else
            {
                return false; 
            }
        }
        
        return false;
    }
}