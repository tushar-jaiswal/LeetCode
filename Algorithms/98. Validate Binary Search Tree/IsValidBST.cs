//Author: Tushar Jaiswal
//Creation Date: 07/06/2018

/*Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input:
    2
   / \
  1   3
Output: true

Example 2:
    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.*/

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
    public bool IsValidBST(TreeNode root) {    
        TreeNode lastNode = null;
        return InorderTraversal(root, ref lastNode);
    }
    
    private bool InorderTraversal(TreeNode root, ref TreeNode lastNode)
    {
        if(root != null)
        {
            if(!InorderTraversal(root.left, ref lastNode))
            { return false; }
            
            if(lastNode != null && root.val <= lastNode.val)
            { return false; }
            lastNode = root;
            
            if(!InorderTraversal(root.right, ref lastNode))
            { return false; }
        }
        return true;
    }
}