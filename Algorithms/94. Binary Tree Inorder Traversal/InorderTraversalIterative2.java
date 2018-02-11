//Author: Tushar Jaiswal
//Creation Date: 02/11/2018

/*Given a binary tree, return the inorder traversal of its nodes' values.
For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Deque<TreeNode> nodes = new ArrayDeque<TreeNode>();
        
        TreeNode curr = root;
        
        while(curr != null || !nodes.isEmpty())
        {
            while(curr != null)
            {
                nodes.addFirst(curr);
                curr = curr.left;
            }
            
            curr = nodes.removeFirst();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
}