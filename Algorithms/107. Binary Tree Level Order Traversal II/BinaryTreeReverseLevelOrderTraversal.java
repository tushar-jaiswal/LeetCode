//Author: Tushar Jaiswal
//Creation Date: 07/07/2016
/*Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
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
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        
        if( root != null )
        { 
            q1.add(root);
        }
        
        while(q1.size() > 0)
        {
            List<Integer> row = new ArrayList<Integer>();
            while(q1.size() > 0)
            {
                q2.add(q1.remove());
            }
            while(q2.size() > 0)
            {
                
                TreeNode node = q2.remove();
                row.add(node.val);
                if(node.left != null) { q1.add(node.left); }
                if(node.right != null) { q1.add(node.right); }
            }
            result.add(0, row);
        }
        return result;
    }
}