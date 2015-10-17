//Author: Tushar Jaiswal
//Creation Date: 10/17/2015

/*Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> temp = new LinkedList<TreeNode>();
        int depth = 0;
        
        if(root != null )
        { 
            queue.add(root); 
        }
        
        while(!queue.isEmpty())
        {
            depth++;
            while(!queue.isEmpty())
            {
                temp.add(queue.remove());
            }
            while(!temp.isEmpty())
            {
                TreeNode node = temp.remove();
                if(node.left != null)
                { queue.add(node.left); }
                if(node.right != null)
                { queue.add(node.right); }
            }
        }
        
        return depth;
    }
}