//Author: Tushar Jaiswal
//Creation Date: 07/28/2016

/*Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.*/

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
    public boolean isBalanced(TreeNode root) {
        if(getHeight(root) == -1)
        { return false; }
        else
        { return true; }
    }
    
    private int getHeight(TreeNode root)
    {
        if(root == null)
        { return 0; }
        
        int leftHeight = getHeight(root.left);
        if(leftHeight == -1)
        { return -1; }
        int rightHeight = getHeight(root.right);
        if(rightHeight == -1)
        { return -1; }
        
        if(Math.abs(leftHeight - rightHeight) > 1)
        { return -1; }
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}