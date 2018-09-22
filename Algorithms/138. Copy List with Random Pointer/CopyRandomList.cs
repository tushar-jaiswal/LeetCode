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
        RandomListNode copyHead, copy, curr;
        curr = head;
        copyHead = new RandomListNode(0);
        copy = copyHead;
        Dictionary<int, RandomListNode> dict = new Dictionary<int, RandomListNode>();
        while(curr != null)
        {
            copy.next = new RandomListNode(curr.label);
            dict[curr.label] = copy.next;
            curr = curr.next;
            copy = copy.next;
        }
        
        curr = head;
        copy = copyHead;
        while(curr != null)
        {
            copy = copy.next;
            if(curr.random != null)
            { copy.random = dict[curr.random.label]; }
            curr = curr.next;
        }        
        return copyHead.next;
    }
}