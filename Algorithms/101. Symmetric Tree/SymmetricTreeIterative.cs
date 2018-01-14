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
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public bool IsSymmetric(TreeNode root) {
        Queue<TreeNode> q1 = new Queue<TreeNode>();
        Queue<TreeNode> q2 = new Queue<TreeNode>();
        
        if(root != null)
        {
            q1.Enqueue(root.left);
            q1.Enqueue(root.right);
        }
        while(q1.Count != 0)
        {
            foreach(TreeNode n in q1) 
            { q2.Enqueue(n); }
            q1.Clear();          
            List<string> row = new List<string>();
            
            while(q2.Count != 0)
            {
                TreeNode node = q2.Dequeue();
                if(node != null) 
                {
                    q1.Enqueue(node.left);
                    q1.Enqueue(node.right);
                }
                row.Add(GetNodeVal(node));
            }
            
            for(int i = 0, j = row.Count - 1; i < row.Count / 2; i++, j--)
            {
                if(row[i] != row[j])
                { return false; }
            }
        }
        return true;
    }
    
    public string GetNodeVal(TreeNode node)
    {
        if(node == null)
        {
            return "n";
        }
        else
        {
            return node.val.ToString();
        }
    }
}