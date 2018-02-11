//Author: Tushar Jaiswal
//Creation Date: 02/11/2018

/*Given a binary tree, return the inorder traversal of its nodes' values.
For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?*/

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        traverseInorder(root, list);
        return list;
    }
    
    public void traverseInorder(TreeNode node, List<Integer> list)
    {
        if(node != null)
        {
            if(node.left != null) 
            { traverseInorder(node.left, list); }
            
            list.add(node.val);
            
            if(node.right != null)
            { traverseInorder(node.right, list); }
        }
    }
}