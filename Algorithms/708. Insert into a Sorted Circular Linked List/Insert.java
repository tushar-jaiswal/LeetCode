//Author: Tushar Jaiswal
//Creation Date: 01/16/2021

/*Given a node from a Circular Linked List which is sorted in ascending order, write a function to insert a value insertVal into the list such that it remains a sorted circular list. The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the circular list.

If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the circular list should remain sorted.

If the list is empty (i.e., given node is null), you should create a new single circular list and return the reference to that single node. Otherwise, you should return the original given node.

Example 1:
Input: head = [3,4,1], insertVal = 2
Output: [3,4,1,2]
Explanation: In the figure above, there is a sorted circular list of three elements. You are given a reference to the node with value 3, and we need to insert 2 into the list. The new node should be inserted between node 1 and node 3. After the insertion, the list should look like this, and we should still return node 3.

Example 2:
Input: head = [], insertVal = 1
Output: [1]
Explanation: The list is empty (given head is null). We create a new single circular list and return the reference to that single node.

Example 3:
Input: head = [1], insertVal = 0
Output: [1,0]

Constraints:
    0 <= Number of Nodes <= 5 * 10^4
    -10^6 <= Node.val <= 10^6
    -10^6 <= insertVal <= 10^6
*/

/*Runtime Complexity: O(n)
Space Complexity: O(1)*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal, null);
            head.next = head;
        } else {
            Node curr = head;

            while (true) {
                // If the value is in between two nodes.
                // e.g. 1->3, insert 2
                if (curr.val <= insertVal && insertVal <= curr.next.val) {
                    break;
                } else if (curr.val > curr.next.val && (insertVal >= curr.val || insertVal <= curr.next.val)) {
                // If the value is greater than the largest node or smaller than the smallest node
                //  e.g. 1->2->4, insert 5, or 1->2->4, insert 0
                    break;
                } else if (curr.next == head) {
                // If all values are the same
                // e.g. 3->3->3, insert 5
                    break;
                }
                curr = curr.next;
            }
            curr.next = new Node(insertVal, curr.next);
        }

        return head;
    }
}
