//Author: Tushar Jaiswal
//Creation Date: 02/10/2018

/*Given a binary tree, return the preorder traversal of its nodes' values.
For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,2,3].

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
    public IList<int> PreorderTraversal(TreeNode root) {
        List<int> list = new List<int>();
        if(root != null)            
        {
            list.Add(root.val);
            list.AddRange(PreorderTraversal(root.left));
            list.AddRange(PreorderTraversal(root.right));
        }
        return list;
    }
}