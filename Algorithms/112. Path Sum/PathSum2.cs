//Author: Tushar Jaiswal
//Creation Date: 02/21/2018

/*Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.*/
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
    public bool HasPathSum(TreeNode root, int sum) {
        if(root == null)
        {
            return false;
        }
        return PreOrderTraversal(root, sum, 0);
    }
    
    private bool PreOrderTraversal(TreeNode node, int target, int sum)
    {
        sum += node.val;
        if(node.left == null && node.right == null && sum == target)
        { 
            return true;
        }
        bool left = false, right = false;
        if(node.left != null)
        { 
            left = PreOrderTraversal(node.left, target, sum);
        }
        if(node.right != null)
        {
            right = PreOrderTraversal(node.right, target, sum);
        }
        return left || right;
    }
}