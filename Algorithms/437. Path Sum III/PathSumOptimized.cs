//Author: Tushar Jaiswal
//Creation Date: 11/11/2020

/*You are given a binary tree in which each node contains an integer value.
Find the number of paths that sum to a given value.
The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example: root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:
1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11*/

/*Runtime Complexity: O(number of nodes in the tree)
Space Complexity: O(number of nodes in the tree)*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public int PathSum(TreeNode root, int sum) {
        return PreorderTraversal(root, sum, 0, new Dictionary<int, int>());
    }

    public int PreorderTraversal(TreeNode node, int target, int currSum, Dictionary<int, int> prefixSumFreqDict) {
        int count = 0;

        if (node != null) {
            currSum += node.val;

            if (currSum == target) {
                count++;
            }

            // If (currSum - target) existed earlier in path, target is present upto this node in path from an earlier
            // node. Getting the count of occurrence of (currSum - target), we get the times target is present
            // including current node's value.
            if (prefixSumFreqDict.ContainsKey(currSum - target)) {
                count += prefixSumFreqDict[currSum - target];
            }

            if (prefixSumFreqDict.ContainsKey(currSum)) {
                prefixSumFreqDict[currSum]++;
            } else {
                prefixSumFreqDict[currSum] = 1;
            }

            count += PreorderTraversal(node.left, target, currSum, prefixSumFreqDict);
            count += PreorderTraversal(node.right, target, currSum, prefixSumFreqDict);

            prefixSumFreqDict[currSum]--;
        }

        return count;
    }
}
