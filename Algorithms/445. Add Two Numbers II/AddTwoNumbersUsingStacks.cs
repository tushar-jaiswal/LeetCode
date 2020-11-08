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
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
        var l1Stack = GetStackFromList(l1);
        var l2Stack = GetStackFromList(l2);

        var sumStack = AddStacks(l1Stack, l2Stack);

        return GetSumList(sumStack);
    }

    private Stack<int> GetStackFromList(ListNode node) {
        var stack = new Stack<int>();
        while (node != null) {
            stack.Push(node.val);
            node = node.next;
        }
        return stack;
    }

    private Stack<int> AddStacks(Stack<int> stack1, Stack<int> stack2) {
        int sum = 0;
        int carry = 0;
        var sumStack = new Stack<int>();

        while (stack1.Count != 0 || stack2.Count != 0) {
            sum = stack1.Count == 0 ? sum : sum + stack1.Pop();
            sum = stack2.Count == 0 ? sum : sum + stack2.Pop();
            sum += carry;
            carry = sum / 10;
            sumStack.Push(sum % 10);
            sum = 0;
        }

        if (carry == 1) {
            sumStack.Push(carry);
        }
        return sumStack;
    }

    private ListNode GetSumList(Stack<int> stack) {
        if (stack.Count == 0) {
            return null;
        }
        ListNode node = new ListNode(0);
        ListNode current = node;

        while (stack.Count != 0) {
            current.next = new ListNode(stack.Pop());
            current = current.next;
        }

        return node.next;
    }
}
