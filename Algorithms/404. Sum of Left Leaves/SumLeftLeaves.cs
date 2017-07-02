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
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int SumOfLeftLeaves(TreeNode root) 
    {
        return (root == null) ? 0 : Traverse(root, 0);        
    }
    
    public int Traverse(TreeNode node, int sum)
    {
        if(node.left != null && node.left.left == null && node.left.right == null)
        { 
            sum += node.left.val;
        }
        if(node.left != null) 
        { 
            sum = Traverse(node.left, sum);
        }
        if(node.right != null)
        {
            sum = Traverse(node.right, sum);
        }
        return sum;
    }
}