//Author: Tushar Jaiswal
//Creation Date: 01/17/2021

/*Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples 1:
Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7

Output:
[
  [9],
  [3,15],
  [20],
  [7]
]

Examples 2:
Input: [3,9,8,4,0,1,7]

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7

Output:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]

Examples 3:
Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2

Output:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
*/

/*Runtime Complexity: O(n) where n is the number of nodes in the tree as in BFS we traverse all nodes.
Space Complexity: O(n) as we store all the nodes in the result and in the HashMap*/

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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        var result = new ArrayList<List<Integer>>();

        var colArrayMap = new HashMap<Integer, List<Integer>>();
        int minCol = 1; // In case root is null, this ensures we don't get inside the loop in the end
        int maxCol = 0;

        var levelNodesQueue = new ArrayDeque<TreeNode>();
        var colQueue = new ArrayDeque<Integer>();

        if (root != null) {
            levelNodesQueue.add(root);
            colQueue.add(0);
        }

        while (!levelNodesQueue.isEmpty()) {
            int levelSize = levelNodesQueue.size();

            for(int i = 0; i < levelSize; i++) {
                TreeNode node = levelNodesQueue.remove(); // Get current node
                int col = colQueue.remove(); // Get current node's column
                minCol = Math.min(minCol, col);
                maxCol = Math.max(maxCol, col);

                colArrayMap.putIfAbsent(col, new ArrayList<Integer>());
                colArrayMap.get(col).add(node.val); // Add current node's value to its column array

                if (node.left != null) {
                    levelNodesQueue.add(node.left);
                    colQueue.add(col - 1);
                }
                if (node.right != null) {
                    levelNodesQueue.add(node.right);
                    colQueue.add(col + 1);
                }
            }
        }

        for (int col = minCol; col <= maxCol; col++) {
            result.add(colArrayMap.get(col));
        }

        return result;
    }
}
