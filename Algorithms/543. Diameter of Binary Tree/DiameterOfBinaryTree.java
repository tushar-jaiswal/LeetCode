//Author: Tushar Jaiswal
//Creation Date: 12/14/2020

/* Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them. */

/*Runtime Complexity: O(number of nodes in tree)
Space Complexity: O(height of tree) which in worst case is O(number of nodes in tree)*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[]{0};
        maxDepth(root, diameter);
        return diameter[0];
    }

    private int maxDepth(TreeNode root, int[] diameter) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left, diameter);
            int right = maxDepth(root.right, diameter);
            diameter[0] = Math.max(diameter[0], left + right);
            return 1 + Math.max(left, right);
        }
    }
}
