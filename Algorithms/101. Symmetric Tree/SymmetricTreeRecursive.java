//Author: Tushar Jaiswal
//Creation Date: 01/14/2018

/*Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note: Bonus points if you could solve it both recursively and iteratively.*/

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
    public boolean isSymmetric(TreeNode root) {
        if(root != null)
        {
            return compareNodes(root.left, root.right);
        }
        return true;
    }
    
    public boolean compareNodes(TreeNode a, TreeNode b)
    {
        if(a == null && b == null)
        {
            return true;
        }
        else if((a == null || b == null) || (a.val != b.val))
        {
            return false;
        }
        else
        {
            return compareNodes(a.left, b.right) && compareNodes(a.right, b.left);
        }
    }
}