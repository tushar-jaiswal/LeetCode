//Author: Tushar Jaiswal
//Creation Date: 07/17/2016
/*Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.*/
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
    public int minDepth(TreeNode root) {
        int noNodesInLevel, noNodesInNextLevel, depth = 0;
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        
        if(root == null)
        { return 0; }
        
        nodes.add(root);
        noNodesInLevel = 1;
        
        while(!nodes.isEmpty())
        {
            depth++;
            noNodesInNextLevel = 0;
            for(int i = 0; i < noNodesInLevel; i++)
            {
                TreeNode node = nodes.remove();
                if(node.left == null && node.right == null)
                {
                    return depth;
                }
                if(node.left != null)
                { 
                    nodes.add(node.left);
                    noNodesInNextLevel++; 
                }
                if(node.right != null)
                {
                    nodes.add(node.right);
                    noNodesInNextLevel++;
                }
            }
            noNodesInLevel = noNodesInNextLevel;
        }
        
        return depth;
    }
}