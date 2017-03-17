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
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
        { return null; }
        root = invertChildren(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    
    private TreeNode invertChildren(TreeNode root)
    {
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        return root;
    }
}