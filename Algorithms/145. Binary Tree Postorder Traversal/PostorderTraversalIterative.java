//Author: Tushar Jaiswal
//Creation Date: 02/12/2018

/*Given a binary tree, return the postorder traversal of its nodes' values.
For example:
Given binary tree [1,null,2,3],

   1
    \
     2
    /
   3
 

return [3,2,1].

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Deque<TreeNode> nodes = new ArrayDeque<TreeNode>();
        HashSet<TreeNode> visited = new HashSet<TreeNode>();
        
        if(root != null)
        { nodes.add(root); }
        
        while(!nodes.isEmpty())
        {
            TreeNode curr = nodes.removeFirst();
            
            if(visited.contains(curr))
            {
                list.add(curr.val);
                visited.remove(curr);
            }
            else
            {
                nodes.addFirst(curr);
                if(curr.right != null)
                { nodes.addFirst(curr.right); }
                if(curr.left != null)
                { nodes.addFirst(curr.left); }
                visited.add(curr);
            }
        }
        return list;
    }
}