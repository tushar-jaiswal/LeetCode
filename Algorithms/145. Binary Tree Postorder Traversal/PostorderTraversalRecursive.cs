//Author: Tushar Jaiswal
//Creation Date: 02/12/2018

/*Given a binary tree, return the postorder traversal of its nodes' values.
For example:
Given binary tree [1,null,2,3],

   1
    \
     2
    /
   3
 

return [3,2,1].

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
    public IList<int> PostorderTraversal(TreeNode root) {
        List<int> list = new List<int>();
        if(root != null)
        {
            list.AddRange(PostorderTraversal(root.left));
            list.AddRange(PostorderTraversal(root.right));
            list.Add(root.val);
        }
        return list;
    }
}