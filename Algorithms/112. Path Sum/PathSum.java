//Author: Tushar Jaiswal
//Creation Date: 07/17/2016
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
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return pathTraversal(root, sum, 0);
    }
    
    private boolean pathTraversal(TreeNode node, int target, int sum)
    {
        if(node == null)
        {
            return false;
        }
        sum += node.val;
        if(node.left == null && node.right == null && sum == target)
        { 
            return true;
        }
        if(node.left != null)
        { 
            if(pathTraversal(node.left, target, sum)) { return true; }
        }
        if(node.right != null)
        {
            if(pathTraversal(node.right, target, sum)) { return true; }
        }
        return false;
    }
}