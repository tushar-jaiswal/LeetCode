//Author: Tushar Jaiswal
//Creation Date: 07/07/2018

/*Given a binary search tree and a node in it, find the in-order successor of that node in the BST.*/

class Solution {
    private TreeNode prevNode;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode node)
    {
        if(root != null)
		{
			TreeNode result = inorderSuccessor(root.left, node);
			if(result != null)
			{ return result; }
			
			if(prevNode != null && prevNode.val == node.val)
			{ return root; }
			else
			{ prevNode = root; }
			
			result = inorderSuccessor(root.right, node);
			if(result != null)
			{ return result; }
		}
		return null;
    }
}