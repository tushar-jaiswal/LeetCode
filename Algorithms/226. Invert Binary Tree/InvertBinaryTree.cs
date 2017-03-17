//Author: Tushar Jaiswal
//Creation Date: 03/16/2017

/*Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1*/

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
    public TreeNode InvertTree(TreeNode root) {
        if(root == null)
        { return null; }
        root = InvertChildren(root);
        InvertTree(root.left);
        InvertTree(root.right);
        return root;
    }
    
    private TreeNode InvertChildren(TreeNode root)
    {
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        return root;
    }
}