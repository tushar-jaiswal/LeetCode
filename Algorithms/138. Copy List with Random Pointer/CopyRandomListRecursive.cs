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
    Dictionary<RandomListNode, RandomListNode> dict = new Dictionary<RandomListNode, RandomListNode>();
    
    public RandomListNode CopyRandomList(RandomListNode head) {
        if(head == null)
        { return null; }
        RandomListNode curr;
        curr = head;
        if(head == null)
        { return null; }
        if(dict.ContainsKey(head))
        { return dict[head]; }
        
        RandomListNode node = new RandomListNode(head.label);
        dict[head] = node;
        node.next = CopyRandomList(head.next);
        node.random = CopyRandomList(head.random);
        return node;
    }
}