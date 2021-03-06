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
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public bool IsSymmetric(TreeNode root) {
        if(root != null)
        {
            Queue<TreeNode> row = new Queue<TreeNode>();
            row.Enqueue(root.left);
            row.Enqueue(root.right);
            while(row.Count != 0)
            {
                TreeNode a = row.Dequeue();
                TreeNode b = row.Dequeue();
                if(a == null && b == null)
                { continue; }
                if((a == null || b == null) || (a.val != b.val))
                { return false; }
                else
                {
                    row.Enqueue(a.left);
                    row.Enqueue(b.right);
                    row.Enqueue(a.right);
                    row.Enqueue(b.left);
                }
            }
        }
        return true;
    }
}