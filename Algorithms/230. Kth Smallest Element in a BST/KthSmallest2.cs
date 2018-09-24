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
        List<int> list = new List<int>();
        Traverse(root, k, list);
        return list[k - 1];
    }
    
    private void Traverse(TreeNode node, int k, List<int> list)
    {
        if(node.left != null)
        { Traverse(node.left, k, list); }
        list.Add(node.val);
        if(node.right != null)
        { Traverse(node.right, k, list); }
    }
}