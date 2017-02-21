//Author: Tushar Jaiswal
//Creation Date: 02/19/2017

/*Reverse a singly linked list.
Hint: A linked list can be reversed either iteratively or recursively. Could you implement both?*/

//O(n) runtime complxity and O(1) space complexity, iterative solution

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
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}