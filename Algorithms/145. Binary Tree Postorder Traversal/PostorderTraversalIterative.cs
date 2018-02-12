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
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public IList<int> PostorderTraversal(TreeNode root) {
        List<int> list = new List<int>();
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        HashSet<TreeNode> visited = new HashSet<TreeNode>();
        
        if(root != null)
        { nodes.Push(root); }
        
        while(nodes.Count != 0)
        {
            TreeNode curr = nodes.Pop();
            
            if(visited.Contains(curr))
            {
                list.Add(curr.val);
                visited.Remove(curr);
            }
            else
            {
                nodes.Push(curr);
                if(curr.right != null)
                { nodes.Push(curr.right); }
                if(curr.left != null)
                { nodes.Push(curr.left); }
                visited.Add(curr);
            }
        }
        return list;
    }
}