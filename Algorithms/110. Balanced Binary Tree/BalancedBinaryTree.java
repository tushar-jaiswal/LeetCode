//Author: Tushar Jaiswal
//Creation Date: 07/07/2016
/*Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.*/
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
    public boolean isBalanced(TreeNode root) {
        
        if(root != null)
        {
            if(Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)
            { return false; }
            else
            {
                if(!isBalanced(root.left)) { return false; };
                if(!isBalanced(root.right)) { return false; };
            }
        }
        return true;
    }
    
    private int getHeight(TreeNode root)
    {
        int h=0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null) 
        { 
            queue.add(root); 
        }
        
        while(queue.size() > 0)
        {
            h += 1;
            int numLevNodes = queue.size();
            for(int i = 0; i < numLevNodes; i++)
            {
                TreeNode node = queue.remove();
                if(node.left != null) { queue.add(node.left); }
                if(node.right != null) { queue.add(node.right); }
            }
        }
        return h;
    }
}