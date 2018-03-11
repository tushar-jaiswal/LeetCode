//Author: Tushar Jaiswal
//Creation Date: 03/10/2018

/*Given inorder and postorder traversal of a tree, construct the binary tree.
Note: You may assume that duplicates do not exist in the tree.

For example, given
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7*/

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
    public TreeNode BuildTree(int[] inorder, int[] postorder) {
        int length =  postorder.Length;
        if (length == 0)
        { return null; }
        
        int rootVal = postorder[length - 1];
        TreeNode root = new TreeNode(rootVal);
        
        int leftLength = 0, rightLength = 0;
        for(int i = 0; i < length; i++)
        {
            if(inorder[i] == rootVal)
            {
                leftLength = i;
                rightLength = length - (i + 1);
            }
        }
        
        int[] rightInorder = new int[rightLength];
        int[] rightPostorder = new int[rightLength];
        int[] leftInorder = new int[leftLength];
        int[] leftPostorder = new int[leftLength];
        for(int i = 0; i < leftLength || i < rightLength; i++)
        {
            if(i < leftLength)
            {
                leftInorder[i] = inorder[i];
                leftPostorder[i] = postorder[i];
            }
            if(i < rightLength)
            {
                rightInorder[i] = inorder[leftLength + 1 + i];
                rightPostorder[i] = postorder[leftLength + i];
            }
        }
        
        root.right = BuildTree(rightInorder, rightPostorder);
        root.left = BuildTree(leftInorder, leftPostorder);
        
        return root;
    }
}