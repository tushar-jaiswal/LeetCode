//Author: Tushar Jaiswal
//Creation Date: 09/23/2018

/*Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
Note:  You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:
Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?*/

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
    public int KthSmallest(TreeNode root, int k) {
        int count = CountNodes(root.left);
        if(k <= count)
        { return KthSmallest(root.left, k); }
        else if(k > count + 1)
        { return KthSmallest(root.right, k - 1 - count); }
        return root.val;
    }
    
    private int CountNodes(TreeNode node)
    {
        if(node == null)
        { return 0; }
        return 1 + CountNodes(node.left) + CountNodes(node.right);
    }
}