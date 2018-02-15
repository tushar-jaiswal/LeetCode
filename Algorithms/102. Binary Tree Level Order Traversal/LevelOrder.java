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
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        
        if(root != null)
        { q1.add(root); }
        
        while(!q1.isEmpty())
        {
            List<Integer> levelNodes = new LinkedList<Integer>();
            Queue<TreeNode> q2 = new LinkedList<TreeNode>();
            while(!q1.isEmpty())
            {
                q2.add(q1.remove());
            }
            
            while(!q2.isEmpty())
            {
                TreeNode node = q2.remove();
                levelNodes.add(node.val);
                if(node.left != null)
                { q1.add(node.left); }
                if(node.right != null)
                { q1.add(node.right); }
            }
            result.add(levelNodes);
        }
        return result;
    }
}