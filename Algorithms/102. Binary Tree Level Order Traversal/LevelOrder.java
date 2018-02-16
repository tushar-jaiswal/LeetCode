//Author: Tushar Jaiswal
//Creation Date: 02/15/2018

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
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if(root != null)
        { queue.add(root); }
        
        while(!queue.isEmpty())
        {
            List<Integer> levelNodes = new LinkedList<Integer>();
            int levelSize = queue.size();
            
            for(int i = 0; i < levelSize; i++)
            {
                TreeNode node = queue.remove();
                levelNodes.add(node.val);
                if(node.left != null)
                { queue.add(node.left); }
                if(node.right != null)
                { queue.add(node.right); }
            }
            result.add(levelNodes);
        }
        return result;
    }
}