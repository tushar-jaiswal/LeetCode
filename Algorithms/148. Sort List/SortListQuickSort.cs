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
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode SortList(ListNode head) {
        if(head == null || head.next == null)
        { return head; }
        ListNode smallHead = new ListNode(0);
        ListNode equalHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode equal = equalHead;
        ListNode large = largeHead;
        ListNode pivot = head;
        while(head != null)
        {
            if(head.val < pivot.val)
            {
                small.next = head;
                small = small.next;
            }
            else if(head.val == pivot.val)
            {
                equal.next = head;
                equal = equal.next;
            }
            else
            {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        small.next = equal.next = large.next = null;
        ListNode l1 = SortList(smallHead.next);
        ListNode l3 = SortList(largeHead.next);
        return Merge(l1, equalHead.next, l3);
    }
    
    public ListNode Merge(ListNode small, ListNode equal, ListNode large)
    {
        ListNode temp = new ListNode(0);
        ListNode curr = temp;
        while(small != null)
        {
            curr.next = small;
            small = small.next;
            curr = curr.next;
        }
        while(equal != null)
        {
            curr.next = equal;
            equal = equal.next;
            curr = curr.next;
        }
        curr.next = large;
        return temp.next;
    }
}