//Author: Tushar Jaiswal
//Creation Date: 07/07/2016
/*Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.*/
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
    public bool IsBalanced(TreeNode root) {
        if(root != null)
        {
            if(Math.Abs(GetHeight(root.left) - GetHeight(root.right)) > 1)
            { return false; }
            else
            {
                if(!IsBalanced(root.left)) { return false; };
                if(!IsBalanced(root.right)) { return false; };
            }
        }
        return true;
    }
    
    private int GetHeight(TreeNode root)
    {
        int h=0;
        Queue<TreeNode> queue = new Queue<TreeNode>();
        if(root != null) 
        { 
            queue.Enqueue(root); 
        }
        
        while(queue.Count > 0)
        {
            h += 1;
            int numLevNodes = queue.Count;
            for(int i = 0; i < numLevNodes; i++)
            {
                TreeNode node = queue.Dequeue();
                if(node.left != null) { queue.Enqueue(node.left); }
                if(node.right != null) { queue.Enqueue(node.right); }
            }
        }
        return h;
    }
}