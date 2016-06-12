//Author: Tushar Jaiswal
//Creation Date: 06/12/2016
/*Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode current, resultHead;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        current = head;
        
        if(head != null && head.next != null)
        { resultHead = head.next;}
        else
        { resultHead = head; }
        
        while(current != null && current.next != null)
        {
            ListNode temp = current.next.next;
            
            dummy.next = current.next;
            current.next.next = current;
            current.next = temp;
            
            dummy = current;
            current = current.next;
        }
        return resultHead;
    }
}