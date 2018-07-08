//Author: Tushar Jaiswal
//Creation Date: 07/08/2018

/*Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.
Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<TreeNode>();
        
    public BSTIterator(TreeNode root) {
        PushAllLeft(root);
    }

    /** @return whether we have a next smallest number */
    public bool HasNext() {
        return stack.Count != 0;
    }

    /** @return the next smallest number */
    public int Next() {
        TreeNode node = stack.Pop();
        if(node.right != null)
        { PushAllLeft(node.right); }
        return node.val;
    }
    
    private void PushAllLeft(TreeNode node)
    {
        while(node != null)
        {
            stack.Push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.HasNext()) v[f()] = i.Next();
 */