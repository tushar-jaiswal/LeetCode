//Author: Tushar Jaiswal
//Creation Date: 09/22/2018

/*A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
        { return null; }
        RandomListNode curr;
        curr = head;
        while(curr != null)
        {
            RandomListNode temp = new RandomListNode(curr.label);
            temp.next = curr.next;
            curr.next = temp;
            curr = curr.next.next;
        }
        
        curr = head;
        while(curr != null)
        {
            if(curr.random != null)
            { curr.next.random = curr.random.next; }
            curr = curr.next.next;
        }
        
        curr = head;
        RandomListNode copyHead = curr.next;
        RandomListNode copy = copyHead;
        while(curr != null)
        {
            curr.next = curr.next.next;
            if(curr.next != null)
            { copy.next = copy.next.next; }
            curr = curr.next;
            copy = copy.next;
        }
        
        return copyHead;
    }
}