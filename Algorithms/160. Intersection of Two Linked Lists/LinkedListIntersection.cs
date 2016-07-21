//Author: Tushar Jaiswal
//Creation Date: 07/21/2016
/*Write a program to find the node at which the intersection of two singly linked lists begins.
For example, the following two linked lists:
A:          a1 ? a2
                   ?
                     c1 ? c2 ? c3
                   ?            
B:     b1 ? b2 ? b3
begin to intersect at node c1.
Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode GetIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        bool isP1Reset = false;
        bool isP2Reset = false;
        
        while(p1 != null && p2 != null)
        {
            if(p1 == p2)
            {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
            
            if(p1 == null && p2 == null)
            {
                return null;
            }
            if(p1 == null && !isP1Reset)
            {
                p1 = headB;
                isP1Reset = true;
            }
            if(p2 == null && !isP2Reset)
            {
                p2 = headA;
                isP2Reset = true;
            }
        }
        
        return null;
    }
}