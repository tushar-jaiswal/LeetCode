//Author: Tushar Jaiswal
//Creation Date: 02/17/2015

/*Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.*/

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
    public int MaxDepth(TreeNode root) {
        return FindDepth(root, 0);
    }
    
    public int FindDepth(TreeNode node, int depth)
    {
        if(node == null)
        { return depth; }
        int leftDepth = FindDepth(node.left, depth + 1);
        int rightDepth = FindDepth(node.right, depth + 1);
        return Math.Max(leftDepth, rightDepth);
    }
}