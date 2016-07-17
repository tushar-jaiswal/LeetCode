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
        if (root == null)
        {
            return 0;
        }

        if (root.left != null && root.right != null)
        {
            return Math.Min(MinDepth(root.left), MinDepth(root.right)) + 1;                
        }
        else if(root.left != null)
        {
            return MinDepth(root.left) + 1;
        }
        else
        {
            return MinDepth(root.right) + 1;
        }
    }
}