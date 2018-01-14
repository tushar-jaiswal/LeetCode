//Author: Tushar Jaiswal
//Creation Date: 01/14/2018

/*Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example: Given the sorted array: [-10,-3,0,5,9], one possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
      0
     / \
   -3   9
   /   /
 -10  5
 */

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
    public TreeNode SortedArrayToBST(int[] nums) {
        if(nums.Length == 0) 
        { return null; }
        TreeNode root = new TreeNode(nums[nums.Length / 2]);
        GenerateTree(root, nums, 0, (nums.Length / 2) - 1, (nums.Length / 2) + 1, nums.Length - 1);
        return root;
    }
    
    public void GenerateTree(TreeNode node, int[] nums, int leftStart, int leftEnd, int rightStart, int rightEnd)
    {
        int left = leftStart + (leftEnd - leftStart) / 2;
        int right = rightStart + (rightEnd - rightStart) / 2;
        if(leftEnd >= leftStart) { node.left = new TreeNode(nums[left]); }
        if(rightStart <= rightEnd) { node.right = new TreeNode(nums[right]); }
        
        if(left - 1 >= leftStart || left + 1 <= leftEnd) GenerateTree(node.left, nums, leftStart, left - 1, left + 1, leftEnd);
        if(right - 1 >= rightStart || right + 1 <= rightEnd) GenerateTree(node.right, nums, rightStart, right - 1, right + 1, rightEnd);
    }
}