//Author: Tushar Jaiswal
//Creation Date: 12/20/2020

/*You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

Example 1:
Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.

Example 2:
Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.

Constraints:
    The number of nodes in the tree is in the range [2, 1000].
    -231 <= Node.val <= 231 - 1
*/

/*Runtime Complexity: O(n)
Space Complexity: O(height of tree) which in worst case of a tree with each node only having left node is the size of tree*/

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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode predecessor = null;

    public void recoverTree(TreeNode root) {
        foundSwappedNodes(root);
        swap(first, second);
    }

    private boolean foundSwappedNodes(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (foundSwappedNodes(root.left)) {
            return true;
        }

        //Process Node
        if (predecessor != null && root.val < predecessor.val) {
            second = root;

            if (first == null) {
                first = predecessor;
            } else {
                return true;
            }
        }
        predecessor = root;

        if (foundSwappedNodes(root.right)) {
            return true;
        } else {
            return false;
        }
    }

    private void swap(TreeNode first, TreeNode second) {
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
