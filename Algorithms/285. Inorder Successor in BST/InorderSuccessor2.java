//Author: Tushar Jaiswal
//Creation Date: 07/07/2018

/*Given a binary search tree and a node in it, find the in-order successor of that node in the BST.*/

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode node)
    {
        if(root != null)
		{
			if(node.right != null)
			{
				node = node.right;
				while(node.left != null)
				{ node = node.left; }
				return node;
			}
			
			TreeNode result = null;
			while(root != null && node.val != root.val)
			{
				if(node.val < root.val)
				{
					result = root;
					root = root.left;
				}
				else
				{ root = root.right; }
			}
			return result;
		}
		return null;
    }
}