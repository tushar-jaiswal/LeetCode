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
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public IList<int> InorderTraversal(TreeNode root) {
        List<int> list = new List<int>();
        TraverseInorder(root, list);
        return list;
    }
    
    public void TraverseInorder(TreeNode node, List<int> list)
    {
        if(node != null)
        {
            if(node.left != null) 
            { TraverseInorder(node.left, list); }
            
            list.Add(node.val);
            
            if(node.right != null)
            { TraverseInorder(node.right, list); }
        }
    }
}