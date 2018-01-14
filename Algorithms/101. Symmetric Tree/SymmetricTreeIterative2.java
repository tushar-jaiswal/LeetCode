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
            Queue<TreeNode> row = new LinkedList<TreeNode>();
            row.add(root.left);
            row.add(root.right);
            while(row.size() != 0)
            {
                TreeNode a = row.remove();
                TreeNode b = row.remove();
                if(a == null && b == null)
                { continue; }
                if((a == null || b == null) || (a.val != b.val))
                { return false; }
                else
                {
                    row.add(a.left);
                    row.add(b.right);
                    row.add(a.right);
                    row.add(b.left);
                }
            }
        }
        return true;
    }
}