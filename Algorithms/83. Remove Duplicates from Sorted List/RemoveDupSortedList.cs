//Author: Tushar Jaiswal
//Creation Date: 06/28/2016
/*Given a sorted linked list, delete all duplicates such that each element appear only once.
For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode DeleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr!= null && curr.next != null)
        {
            bool isDuplicate = false;
            do{
                if(curr.next != null && curr.val == curr.next.val)
                {
                    curr.next = curr.next.next;
                    isDuplicate = true;
                }
                else
                {
                    isDuplicate = false;
                }
            }while(isDuplicate);
            if(curr.next != null)
            { 
                curr = curr.next;
            }
        }
        return head;
    }
}