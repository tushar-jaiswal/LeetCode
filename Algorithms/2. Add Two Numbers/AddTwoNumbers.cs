//Author: Tushar Jaiswal
//Creation Date: 07/09/2018

/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode node = result;
        int sum = 0;
        int remainder = 0;
        int carry = 0;
        
        while(l1 != null && l2 != null)
        {
            sum = l1.val + l2.val + carry;
            node.next = new ListNode(sum % 10);
            carry = sum / 10;
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null)
        {
            sum = l1.val + carry;
            node.next = new ListNode(sum % 10);
            carry = sum / 10;
            node = node.next;
            l1 = l1.next;
        }
        
        while(l2 != null)
        {
            sum = l2.val + carry;
            node.next = new ListNode(sum % 10);
            carry = sum / 10;
            node = node.next;
            l2 = l2.next;
        }
        
        if(carry != 0)
        {
            node.next = new ListNode(1);
            node = node.next;
        }
        
        return result.next;
    }
}