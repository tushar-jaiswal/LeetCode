//Author: Tushar Jaiswal
//Creation Date: 05/13/2019

/*Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:
Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]

Explanation: The above output corresponds to the 5 unique BST's shown below:
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3*/

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
    public IList<TreeNode> GenerateTrees(int n) {
        if(n == 0)
        { return new List<TreeNode>(); }
        return GenerateTrees(1, n);
    }

    public IList<TreeNode> GenerateTrees(int start, int end)
    {
        IList<TreeNode> result = new List<TreeNode>();

        if(end < start)
        {
            result.Add(null);
            return result;
        }

        for(int i = start; i <= end; i++)
        {
            IList<TreeNode> left = GenerateTrees(start, i - 1);
            IList<TreeNode> right = GenerateTrees(i + 1, end);

            for(int j = 0; j < left.Count; j++)
            {
                for(int k = 0; k < right.Count; k++)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = left[j];
                    root.right = right[k];
                    result.Add(root);
                }
            }
        }
        return result;
    }
}
