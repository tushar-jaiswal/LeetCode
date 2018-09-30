//Author: Tushar Jaiswal
//Creation Date: 09/30/2018

/*Sort a linked list in O(n log n) time using constant space complexity.

Example 1:
Input: 4->2->1->3
Output: 1->2->3->4

Example 2:
Input: -1->5->3->4->0
Output: -1->0->3->4->5*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
        { return head; }
        ListNode prev = null, slow = head, fast = head;
        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }
    
    public ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode temp = new ListNode(0);
        ListNode curr = temp;
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                curr.next = l1;
                l1 = l1.next;
            }
            else
            {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        while(l1 != null)
        {
            curr.next = l1;
            l1 = l1.next;
            curr = curr.next;
        }
        while(l2 != null)
        {
            curr.next = l2;
            l2 = l2.next;
            curr = curr.next;
        }
        return temp.next;
    }
}