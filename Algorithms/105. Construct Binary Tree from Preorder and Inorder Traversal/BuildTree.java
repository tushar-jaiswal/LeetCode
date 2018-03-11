//Author: Tushar Jaiswal
//Creation Date: 03/11/2018

/*Given preorder and inorder traversal of a tree, construct the binary tree.
Note: You may assume that duplicates do not exist in the tree.

For example, given
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode buildTreeHelper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd)
    {
        if(pStart > pEnd || iEnd < 0)
        { return null; }
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
            
        for(int i = iStart; i <= iEnd; i++)
        {
            if(inorder[i] == rootVal)
            {
                rootIndex = i;
                break;
            }
        }
        
        int leftLength = rootIndex - iStart;
        int rightLength = iEnd - rootIndex;
        
        root.left = buildTreeHelper(preorder, pStart + 1, pStart + leftLength, inorder, iStart, rootIndex - 1);
        root.right = buildTreeHelper(preorder, pEnd - (rightLength - 1), pEnd, inorder, rootIndex + 1, iEnd);
        
        return root;
    }
}