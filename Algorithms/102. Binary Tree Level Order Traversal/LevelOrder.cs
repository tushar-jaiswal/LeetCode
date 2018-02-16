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
        Queue<TreeNode> queue = new Queue<TreeNode>();
        
        if(root != null)
        { queue.Enqueue(root); }
        
        while(queue.Count != 0)
        {
            List<int> levelNodes = new List<int>();
            int levelSize = queue.Count;
            for(int i = 0; i < levelSize; i++)
            {
                TreeNode node = queue.Dequeue();
                levelNodes.Add(node.val);
                if(node.left != null)
                { queue.Enqueue(node.left); }
                if(node.right != null)
                { queue.Enqueue(node.right); }
            }
            result.Add(levelNodes);
        }
        return result;
    }
}