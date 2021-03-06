//Author: Tushar Jaiswal
//Creation Date: 03/11/2018

/*Follow up for problem "Populating Next Right Pointers in Each Node".
What if the given tree could be any binary tree? Would your previous solution still work?

Note:
You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new Queue<TreeLinkNode>();
        if(root != null)
        { queue.Enqueue(root); }
        
        while(queue.Count != 0)
        {
            int levelSize = queue.Count;
            for(int i = 0; i < levelSize; i++)
            {
                TreeLinkNode node = queue.Dequeue();
                if(i == levelSize - 1)
                { node.next = null; }
                else
                { node.next = queue.Peek(); }
                
                if(node.left != null) 
                { queue.Enqueue(node.left); }
                if(node.right != null) 
                { queue.Enqueue(node.right); }
            }
        }
    }
}