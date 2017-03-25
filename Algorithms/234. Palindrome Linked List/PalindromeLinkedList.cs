//Author: Tushar Jaiswal
//Creation Date: 03/25/2017

/*Given a singly linked list, determine if it is a palindrome.
Follow up: Could you do it in O(n) time and O(1) space?*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public bool IsPalindrome(ListNode head) {
        int a = 0, b = 0, i = 0;
        while(head != null)
        {
            a = 10 * a + head.val;
            if(i == 0)
            {
                b = head.val + b;
                i = 1; 
            }
            else
            {
                i *= 10;
                b = i * head.val + b;
            }
            head = head.next;
        }
        return a == b;
    }
}