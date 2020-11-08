//Author: Tushar Jaiswal
//Creation Date: 11/08/2020

/*You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up: What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7*/

/*Runtime Complexity: O(len(l1) + log(len(l2)))
Space Complexity: O(1)*/

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
        // Compute the length of both lists
        int n1 = 0, n2 = 0;
        ListNode curr1 = l1, curr2 = l2;
        while (curr1 != null) {
            n1++;
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            n2++;
            curr2 = curr2.next;
        }

        // Add the corresponding positions of both lists in a new list
        ListNode sumList = null;
        curr1 = l1;
        curr2 = l2;
        while (n1 > 0 && n2 > 0) {
            int sum = 0;
            if (n1 >= n2) {
                sum += curr1.val;
                n1--;
                curr1 = curr1.next;
            }
            if (n1 < n2) {
                sum += curr2.val;
                n2--;
                curr2 = curr2.next;
            }

            // Add new node to the front of the list
            ListNode node = new ListNode(sum);
            node.next = sumList;
            sumList = node;
        }

        // Handle carry
        curr1 = sumList;
        sumList = null;
        int carry = 0;
        while (curr1 != null) {
            int val = (curr1.val + carry) % 10;
            carry = (curr1.val + carry) / 10;

            // Add the node to the front of the list
            ListNode node = new ListNode(val);
            node.next = sumList;
            sumList = node;

            // Move to the next element in the list
            curr1 = curr1.next;
        }

        if (carry == 1) {
            ListNode node = new ListNode(carry);
            node.next = sumList;
            sumList = node;
        }

        return sumList;
    }
}
