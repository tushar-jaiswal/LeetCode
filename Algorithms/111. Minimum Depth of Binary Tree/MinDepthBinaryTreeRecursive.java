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
        if (root == null)
        {
            return 0;
        }

        if (root.left != null && root.right != null)
        {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;                
        }
        else if(root.left != null)
        {
            return minDepth(root.left) + 1;
        }
        else
        {
            return minDepth(root.right) + 1;
        }
    }
}