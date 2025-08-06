# Author: Tushar Jaiswal
# Creation Date: 2025-08-05

# Problem Source: https://leetcode.com/problems/diameter-of-binary-tree

# Given the root of a binary tree, return the length of the diameter of the tree.

# The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

# The length of a path between two nodes is represented by the number of edges between them.

# Example 1:
# Input: root = [1,2,3,4,5]
# Output: 3
# Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

# Example 2:
# Input: root = [1,2]
# Output: 1
 
# Constraints:
# The number of nodes in the tree is in the range [1, 10^4].
# -100 <= Node.val <= 100

# Let N be the number of nodes in the tree.
# Runtime complexity: O(N). This is because in our recursion function longestPath, we only enter and exit from each node once. We know this because each node is entered from its parent, and in a tree, nodes only have one parent.
# Space complexity: O(N). The space complexity depends on the size of our implicit call stack during our DFS, which relates to the height of the tree. In the worst case, the tree is skewed so the height of the tree is O(N). If the tree is balanced, it'd be O(logN).

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        left_depth, left_diameter = self.depth(root.left) if root.left else (0, 0)
        right_depth, right_diameter = self.depth(root.right) if root.right else (0, 0)
        diameter = left_depth + right_depth
        return max(diameter, left_diameter, right_diameter)

    def depth(self, root: TreeNode) -> (int, int):
        left_depth, left_diameter = self.depth(root.left) if root.left else (0, 0)
        right_depth, right_diameter = self.depth(root.right) if root.right else (0, 0)
        diameter = left_depth + right_depth
        max_diameter = max(diameter, left_diameter, right_diameter)
        return (max(left_depth + 1, right_depth + 1), max_diameter)
