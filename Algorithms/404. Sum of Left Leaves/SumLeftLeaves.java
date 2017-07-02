//Author: Tushar Jaiswal
//Creation Date: 07/01/2017

/*Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.*/
    
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
    public int sumOfLeftLeaves(TreeNode root) {
        return traverse(root, 0);
    }
    
    public int traverse(TreeNode node, int sum)
    {
        if(node.left != null && node.left.left == null && node.left.right == null)
        { 
            sum += node.left.val;
        }
        if(node.left != null) 
        { 
            sum = traverse(node.left, sum);
        }
        if(node.right != null)
        {
            sum = traverse(node.right, sum);
        }
        return sum;
    }
}