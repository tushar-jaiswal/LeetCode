//Author: Tushar Jaiswal
//Creation Date: 16/01/2021

/*Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (x, y), its left and right children will be at positions (x - 1, y - 1) and (x + 1, y - 1) respectively.

The vertical order traversal of a binary tree is a list of non-empty reports for each unique x-coordinate from left to right. Each report is a list of all nodes at a given x-coordinate. The report should be primarily sorted by y-coordinate from highest y-coordinate to lowest. If any two nodes have the same y-coordinate in the report, the node with the smaller value should appear earlier.

Return the vertical order traversal of the binary tree.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation: Without loss of generality, we can assume the root node is at position (0, 0):
The node with value 9 occurs at position (-1, -1).
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2).
The node with value 20 occurs at position (1, -1).
The node with value 7 occurs at position (2, -2).

Example 2:
Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation: The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report [1,5,6], the node with value 5 comes first since 5 is smaller than 6.

Constraints:
    The number of nodes in the tree is in the range [1, 1000].
    0 <= Node.val <= 1000
*/

/*Runtime Complexity: O(n) where n is the number of nodes in the tree as in BFS we traverse all nodes. For each level, we go through all the nodes and then through all the columns which in the worst case leads to twice the number of nodes in a row. The sort operation can be considered constant as sort only happens on array of size 2 leading to a cost of 2log(2).
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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
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
            var tempColArrayMap = new HashMap<Integer, List<Integer>>();

            for(int i = 0; i < levelSize; i++) {
                TreeNode node = levelNodesQueue.remove(); // Get current node
                int col = colQueue.remove(); // Get current node's column
                minCol = Math.min(minCol, col);
                maxCol = Math.max(maxCol, col);

                tempColArrayMap.putIfAbsent(col, new ArrayList<Integer>());
                tempColArrayMap.get(col).add(node.val); // Add current node's value to its column array

                if (node.left != null) {
                    levelNodesQueue.add(node.left);
                    colQueue.add(col - 1);
                }
                if (node.right != null) {
                    levelNodesQueue.add(node.right);
                    colQueue.add(col + 1);
                }
            }

            // Add current row's column arrays to the overall columnArrayMap's column arrays
            for (var entry : tempColArrayMap.entrySet()) {
                int col = entry.getKey();
                List<Integer> list = entry.getValue();
                colArrayMap.putIfAbsent(col, new ArrayList<Integer>());

                // At most 2 elements will be in this list as for a binary tree only 2 nodes can be in the same row and column.
                // The parent of overlapping nodes are always 2 columns apart in a binary tree.
                Collections.sort(list);
                colArrayMap.get(col).addAll(list);
            }
        }

        for (int col = minCol; col <= maxCol; col++) {
            result.add(colArrayMap.get(col));
        }

        return result;
    }
}
