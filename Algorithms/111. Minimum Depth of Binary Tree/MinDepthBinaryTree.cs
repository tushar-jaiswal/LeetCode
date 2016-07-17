//Author: Tushar Jaiswal
//Creation Date: 07/17/2016
/*Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int MinDepth(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> nodes = new Queue<TreeNode>();
        
        if(root != null)
        { 
            nodes.Enqueue(root); 
        }
        
        while(nodes.Count != 0)
        {
            depth++;
            int noNodesInLevel = nodes.Count;
            for(int i = 0; i < noNodesInLevel; i++)
            {
                TreeNode node = nodes.Dequeue();
                if(node.left == null && node.right == null)
                {
                    return depth;
                }
                if(node.left != null)
                { 
                    nodes.Enqueue(node.left);
                }
                if(node.right != null)
                {
                    nodes.Enqueue(node.right);
                }
            }
        }
        
        return depth;
    }
}