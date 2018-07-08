//Author: Tushar Jaiswal
//Creation Date: 07/08/2018

/*Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

For example, 
Given the tree:
        4
       / \
      2   7
     / \
    1   3
    
And the value to search: 2
You should return this subtree:
      2     
     / \   
    1   3
In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.*/

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
    public TreeNode SearchBST(TreeNode root, int val) {
        while(root !=  null)
        {
            if(root.val == val)
            { return root; }
            if(val < root.val)
            { root = root.left; }
            else
            { root = root.right; }
        }
        return null;
    }
}