//Author: Tushar Jaiswal
//Creation Date: 11/07/2020

/*You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up: What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7*/

/*Runtime Complexity: O(len(l1) + log(len(l2)))
Space Complexity: O(len(l1) + log(len(l2)))*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var l1Stack = getStackFromList(l1);
        var l2Stack = getStackFromList(l2);

        var sumStack = addStacks(l1Stack, l2Stack);

        return getSumList(sumStack);
    }

    private ArrayDeque<Integer> getStackFromList(ListNode node) {
        var stack = new ArrayDeque<Integer>();
        while (node != null) {
            stack.addFirst(node.val);
            node = node.next;
        }
        return stack;
    }

    private ArrayDeque<Integer> addStacks(ArrayDeque<Integer> stack1, ArrayDeque<Integer> stack2) {
        int sum = 0;
        int carry = 0;
        var sumStack = new ArrayDeque<Integer>();

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            sum = stack1.isEmpty() ? sum : sum + stack1.removeFirst();
            sum = stack2.isEmpty() ? sum : sum + stack2.removeFirst();
            sum += carry;
            carry = sum / 10;
            sumStack.addFirst(sum % 10);
            sum = 0;
        }

        if (carry == 1) {
            sumStack.addFirst(carry);
        }
        return sumStack;
    }

    private ListNode getSumList(ArrayDeque<Integer> stack) {
        if (stack.isEmpty()) {
            return null;
        }
        ListNode node = new ListNode(0);
        ListNode current = node;

        while (!stack.isEmpty()) {
            current.next = new ListNode(stack.removeFirst());
            current = current.next;
        }

        return node.next;
    }
}
