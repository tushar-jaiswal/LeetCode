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
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null)
        {
            queue.offer(root);
            boolean leftToRight = true;
            while(!queue.isEmpty())
            {
                List<Integer> list = new ArrayList<Integer>();
                int numLevelNodes = queue.size();
                for(int i = 0; i < numLevelNodes; i++)
                {
                    TreeNode node = queue.poll();
                    if(leftToRight)
                    { list.add(node.val); }
                    else
                    { list.add(0, node.val); }
                    if(node.left != null )
                    { queue.offer(node.left); }
                    if(node.right != null )
                    { queue.offer(node.right); }
                }
                result.add(list);
                leftToRight = !leftToRight;
            }
        }
        return result;
    }
}