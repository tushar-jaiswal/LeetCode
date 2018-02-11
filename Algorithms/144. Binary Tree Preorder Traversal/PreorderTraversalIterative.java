//Author: Tushar Jaiswal
//Creation Date: 02/10/2018

/*Given a binary tree, return the preorder traversal of its nodes' values.
For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?*/

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Deque<TreeNode> nodes = new ArrayDeque<TreeNode>();
        
        if(root != null)
        { nodes.addFirst(root); }
        
        while(!nodes.isEmpty())
        {
            TreeNode curr = nodes.removeFirst();
            list.add(curr.val);
            
            if(curr.right != null)
            { nodes.addFirst(curr.right); }
            if(curr.left != null)
            { nodes.addFirst(curr.left); }
        }
        return list;
    }
}