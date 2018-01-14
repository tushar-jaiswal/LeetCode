//Author: Tushar Jaiswal
//Creation Date: 01/13/2018

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
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        
        if(root != null)
        {
            q1.add(root.left);
            q1.add(root.right);
        }
        while(q1.size() != 0)
        {
            for(TreeNode n : q1) 
            { q2.add(n); }
            q1.clear();          
            List<String> row = new ArrayList<String>();
            
            while(q2.size() != 0)
            {
                TreeNode node = q2.remove();
                if(node != null) 
                {
                    q1.add(node.left);
                    q1.add(node.right);
                }
                row.add(getNodeVal(node));
            }
            
            for(int i = 0, j = row.size() - 1; i < row.size() / 2; i++, j--)
            {
                if(!row.get(i).equals(row.get(j)))
                { return false; }
            }
        }
        return true;
    }
    
    public String getNodeVal(TreeNode node)
    {
        if(node == null)
        {
            return "n";
        }
        else
        {
            return Integer.toString(node.val);
        }
    }
}