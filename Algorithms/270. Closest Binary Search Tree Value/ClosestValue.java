//Author: Tushar Jaiswal
//Creation Date: 01/16/2021

/*Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
    Given target value is a floating point.
    You are guaranteed to have only one unique value in the BST that is closest to the target.

Example:
Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4
*/

/*Runtime Complexity: O(height of tree)
Space Complexity: O(1)*/

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
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            throw new IllegalArgumentException("Tree must not be empty.");
        }

        int closestVal = root.val;

        while(root != null) {
            closestVal = Math.abs(root.val - target) < Math.abs(closestVal - target) ? root.val : closestVal;
            root = target < root.val ? root.left : root.right;
        }

        return closestVal;
    }
}
