//Author: Tushar Jaiswal
//Creation Date: 06/11/2016
/*Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode dummy = l3;
        
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            { 
                l3.next = new ListNode(l1.val); 
                l1 = l1.next;
            }
            else
            {
                l3.next = new ListNode(l2.val); 
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        while(l1 != null)
        {
            l3.next = new ListNode(l1.val); 
            l3 = l3.next;
            l1 = l1.next;
        }
        while(l2 != null)
        {
            l3.next = new ListNode(l2.val); 
            l3 = l3.next;
            l2 = l2.next;
        }
        
        return dummy.next;
    }
}