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
    HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
        { return null; }
        if(map.containsKey(head))
        { return map.get(head); }
        
        RandomListNode node = new RandomListNode(head.label);
        map.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }
}