//Author: Tushar Jaiswal
//Creation Date: 09/19/2018

/*Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
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
    public IList<IList<int>> ZigzagLevelOrder(TreeNode root) {
        IList<IList<int>> result = new List<IList<int>>();
        Queue<TreeNode> queue = new Queue<TreeNode>();
        if(root != null)
        {
            queue.Enqueue(root);
            bool leftToRight = true;
            while(queue.Count != 0)
            {
                List<int> list = new List<int>();
                int numLevelNodes = queue.Count;
                for(int i = 0; i < numLevelNodes; i++)
                {
                    TreeNode node = queue.Dequeue();
                    if(leftToRight)
                    { list.Add(node.val); }
                    else
                    { list.Insert(0, node.val); }
                    if(node.left != null )
                    { queue.Enqueue(node.left); }
                    if(node.right != null )
                    { queue.Enqueue(node.right); }
                }
                result.Add(list);
                leftToRight = !leftToRight;
            }
        }
        return result;
    }
}