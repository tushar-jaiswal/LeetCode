//Author: Tushar Jaiswal
//Creation Date: 04/02/2017

/*Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.*/

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
    
    public enum FoundNode{
        P,
        Q,
        PQ,
        Default
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q)
        { return root; }
        FoundNode node;
        TreeNode current = root;
        do{ 
            node = FoundNode.Default;
            if(current.left != null)
            {
                TreeNode temp = current.left;
                node = traverse(temp, p, q, node);
                if(node == FoundNode.PQ)
                {
                    current = temp;
                }
            }
            if(node != FoundNode.PQ && current.right != null)
            {
                node = FoundNode.Default;
                TreeNode temp = current.right;
                node = traverse(temp, p, q, node);
                if(node == FoundNode.PQ)
                {
                    current = temp;
                }
            }
        }while(node == FoundNode.PQ);
    
        return current;
    }
    
    public FoundNode traverse(TreeNode root, TreeNode p, TreeNode q, FoundNode node){
        if(root == p || root == q)
        {
            if(node == FoundNode.P || node == FoundNode.Q)
            { 
                node = FoundNode.PQ;
                return node;
            }
            else
            {
                node = root == p ? FoundNode.P : FoundNode.Q;
            }
        }
        
        if(root.left != null)
        {
            node = traverse(root.left, p, q, node);
        }
        if(root.right != null)
        {
            node = traverse(root.right, p, q, node);
        }
        
        return node;
    }
}