//Author: Tushar Jaiswal
//Creation Date: 09/22/2018

/*A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.*/

/**
 * Definition for singly-linked list with a random pointer.
 * public class RandomListNode {
 *     public int label;
 *     public RandomListNode next, random;
 *     public RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode CopyRandomList(RandomListNode head) {
        if(head == null)
        { return null; }
        RandomListNode curr;
        curr = head;
        Dictionary<RandomListNode, RandomListNode> dict = new Dictionary<RandomListNode, RandomListNode>();
        while(curr != null)
        {
            dict[curr] = new RandomListNode(curr.label);
            curr = curr.next;
        }
        
        curr = head;
        while(curr != null)
        {
            if(curr.next != null)
            { dict[curr].next = dict[curr.next]; }
            if(curr.random != null)
            { dict[curr].random = dict[curr.random]; }
            curr = curr.next;
        }        
        return dict[head];
    }
}