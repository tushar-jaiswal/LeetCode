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
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        while(curr != null)
        {
            map.put(curr, new RandomListNode(curr.label));
            curr = curr.next;
        }
        
        curr = head;
        while(curr != null)
        {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }        
        return map.get(head);
    }
}