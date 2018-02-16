//Author: Tushar Jaiswal
//Creation Date: 02/16/2018

/*Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]*/

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
    public IList<IList<int>> LevelOrder(TreeNode root) {
        List<IList<int>> result = new List<IList<int>>();
        Queue<TreeNode> q1 = new Queue<TreeNode>();
        
        if(root != null)
        { q1.Enqueue(root); }
        
        while(q1.Count != 0)
        {
            List<int> levelNodes = new List<int>();
            Queue<TreeNode> q2 = new Queue<TreeNode>();
            while(q1.Count != 0)
            {
                q2.Enqueue(q1.Dequeue());
            }
            
            while(q2.Count != 0)
            {
                TreeNode node = q2.Dequeue();
                levelNodes.Add(node.val);
                if(node.left != null)
                { q1.Enqueue(node.left); }
                if(node.right != null)
                { q1.Enqueue(node.right); }
            }
            result.Add(levelNodes);
        }
        return result;
    }
}