//Author: Tushar Jaiswal
//Creation Date: 12/05/2020

/*Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any node sequence from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:
Input: root = [1,2,3]
Output: 6

Example 2:
Input: root = [-10,9,20,null,null,15,7]
Output: 42

Constraints:
    The number of nodes in the tree is in the range [0, 3 * 104].
    -1000 <= Node.val <= 1000
*/

/*Runtime Complexity: O(number of nodes in tree)
Space Complexity: O(height of tree) to keep the recursion stack*/

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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        Sum sum = helper(root);
        return sum.maxSum;
    }

    private Sum helper(TreeNode root) {
        Sum left = root.left == null ? null : helper(root.left);
        Sum right = root.right == null ? null : helper(root.right);
        int pathSum = 0;
        int maxSum = 0;

        if (left == null && right == null) {
            pathSum = root.val;
            maxSum = root.val;
        } else if (left == null) {
            pathSum = Math.max(root.val, root.val + right.pathSum);
            maxSum = Math.max(pathSum, right.maxSum);
        } else if (right == null) {
            pathSum = Math.max(root.val, root.val + left.pathSum);
            maxSum = Math.max(pathSum, left.maxSum);
        } else {
            int leftPathSum = Math.max(root.val, root.val + left.pathSum);
            int rightPathSum = Math.max(root.val, root.val + right.pathSum);
            pathSum = Math.max(leftPathSum, rightPathSum);

            int bothPathSum = root.val + left.pathSum + right.pathSum;
            int leftMaxSum = Math.max(leftPathSum, left.maxSum);
            int rightMaxSum = Math.max(rightPathSum, right.maxSum);
            maxSum = Math.max(Math.max(leftMaxSum, rightMaxSum), bothPathSum);
        }
        return new Sum(pathSum, maxSum);
    }
}

class Sum {
    int pathSum;
    int maxSum;

    public Sum(int pathSum, int maxSum) {
        this.pathSum = pathSum;
        this.maxSum = maxSum;
    }
}
