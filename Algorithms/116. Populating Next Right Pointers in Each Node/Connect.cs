//Author: Tushar Jaiswal
//Creation Date: 03/11/2018

/*Given a binary tree
    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL. 
Initially, all next pointers are set to NULL.

Note:
You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void Connect(TreeLinkNode root) {
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