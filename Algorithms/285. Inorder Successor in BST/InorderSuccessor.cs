//Author: Tushar Jaiswal
//Creation Date: 07/07/2018

/*Given a binary search tree and a node in it, find the in-order successor of that node in the BST.*/

public class Solution
{
	public TreeNode InorderSuccessor(TreeNode root, TreeNode node)
	{
		TreeNode prevNode = null;
		return InorderTraversal(root, node, ref prevNode);
	}
	
	private TreeNode InorderTraversal(TreeNode root, TreeNode node, ref TreeNode prevNode)
	{
		if(root != null)
		{
			TreeNode result = InorderTraversal(root.left, node, ref prevNode);
			if(result != null)
			{ return result; }
			
			if(prevNode != null && prevNode.val == node.val)
			{ return root; }
			else
			{ prevNode = root; }
			
			result = InorderTraversal(root.right, node, ref prevNode);
			if(result != null)
			{ return result; }
		}
		return null;
	}
}