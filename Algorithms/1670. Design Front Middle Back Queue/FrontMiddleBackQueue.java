//Author: Tushar Jaiswal
//Creation Date: 11/28/2020

/*Design a queue that supports push and pop operations in the front, middle, and back.

Implement the FrontMiddleBack class:
    FrontMiddleBack() Initializes the queue.
    void pushFront(int val) Adds val to the front of the queue.
    void pushMiddle(int val) Adds val to the middle of the queue.
    void pushBack(int val) Adds val to the back of the queue.
    int popFront() Removes the front element of the queue and returns it. If the queue is empty, return -1.
    int popMiddle() Removes the middle element of the queue and returns it. If the queue is empty, return -1.
    int popBack() Removes the back element of the queue and returns it. If the queue is empty, return -1.

Notice that when there are two middle position choices, the operation is performed on the frontmost middle position choice. For example:
    Pushing 6 into the middle of [1, 2, 3, 4, 5] results in [1, 2, 6, 3, 4, 5].
    Popping the middle from [1, 2, 3, 4, 5, 6] returns 3 and results in [1, 2, 4, 5, 6].

Example 1:
Input:
["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", "popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
[[], [1], [2], [3], [4], [], [], [], [], []]
Output:
[null, null, null, null, null, 1, 3, 4, 2, -1]

Explanation:
FrontMiddleBackQueue q = new FrontMiddleBackQueue();
q.pushFront(1);   // [1]
q.pushBack(2);    // [1, 2]
q.pushMiddle(3);  // [1, 3, 2]
q.pushMiddle(4);  // [1, 4, 3, 2]
q.popFront();     // return 1 -> [4, 3, 2]
q.popMiddle();    // return 3 -> [4, 2]
q.popMiddle();    // return 4 -> [2]
q.popBack();      // return 2 -> []
q.popFront();     // return -1 -> [] (The queue is empty)

Constraints:
    1 <= val <= 109
    At most 1000 calls will be made to pushFront, pushMiddle, pushBack, popFront, popMiddle, and popBack.*/

/*Runtime Complexity: O(1)
Space Complexity: O(n)*/

class FrontMiddleBackQueue {
    DoublyLinkedList head;
    DoublyLinkedList middle;
    DoublyLinkedList tail;
    boolean isTwoMiddles;

    public FrontMiddleBackQueue() {
        head = new DoublyLinkedList(0);
        tail = new DoublyLinkedList(0);
        head.next = tail;
        tail.prev = head;
        isTwoMiddles = true;
    }

    public void pushFront(int val) {
        DoublyLinkedList node = new DoublyLinkedList(val);
        DoublyLinkedList next = head.next;
        insertBetweenNodes(node, head, next);

        setMiddleNodeOnPush(node, true);
        isTwoMiddles = !isTwoMiddles;
    }

    public void pushMiddle(int val) {
        DoublyLinkedList node = new DoublyLinkedList(val);
        if (middle == null) {
            insertBetweenNodes(node, head, tail);
        } else if (isTwoMiddles) {
            DoublyLinkedList next = middle.next;
            insertBetweenNodes(node, middle, next);
        } else {
            DoublyLinkedList prev = middle.prev;
            insertBetweenNodes(node, prev, middle);
        }
        middle = node;
        isTwoMiddles = !isTwoMiddles;
    }

    public void pushBack(int val) {
        DoublyLinkedList node = new DoublyLinkedList(val);
        DoublyLinkedList prev = tail.prev;
        insertBetweenNodes(node, prev, tail);

        setMiddleNodeOnPush(node, false);
        isTwoMiddles = !isTwoMiddles;
    }

    public int popFront() {
        if (middle == null) {
            return -1;
        } else {
            DoublyLinkedList removedNode = removeBetweenNodes(head, head.next.next);
            setMiddleNodeOnPop(true, false);
            isTwoMiddles = !isTwoMiddles;
            return removedNode.val;
        }
    }

    public int popMiddle() {
        if (middle == null) {
            return -1;
        } else {
            DoublyLinkedList removedNode = removeBetweenNodes(middle.prev, middle.next);
            setMiddleNodeOnPop(false, true);
            isTwoMiddles = !isTwoMiddles;
            return removedNode.val;
        }
    }

    public int popBack() {
        if (middle == null) {
            return -1;
        } else {
            DoublyLinkedList removedNode = removeBetweenNodes(tail.prev.prev, tail);
            setMiddleNodeOnPop(false, false);
            isTwoMiddles = !isTwoMiddles;
            return removedNode.val;
        }
    }

    private void insertBetweenNodes(DoublyLinkedList node, DoublyLinkedList front, DoublyLinkedList back) {
        front.next = node;
        node.next = back;
        back.prev = node;
        node.prev = front;
    }

    private void setMiddleNodeOnPush(DoublyLinkedList node, boolean pushFront) {
        if (middle == null) {
            middle = node;
        } else if (pushFront) {
            if (!isTwoMiddles) {
                middle = middle.prev;
            }
        } else {
            if (isTwoMiddles) {
                middle = middle.next;
            }
        }
    }

    private DoublyLinkedList removeBetweenNodes(DoublyLinkedList front, DoublyLinkedList back) {
        DoublyLinkedList removedNode = front.next;
        front.next = back;
        back.prev = front;
        return removedNode;
    }

    private void setMiddleNodeOnPop(boolean popFront, boolean popMiddle) {
        if ((popFront || popMiddle) && isTwoMiddles) {
                middle = middle.next;
        } else if (!popFront && !isTwoMiddles) {
                middle = middle.prev;
        }
        if (head.next == tail) {
            middle = null;
        }
    }
}

class DoublyLinkedList {
    int val;
    DoublyLinkedList next;
    DoublyLinkedList prev;

    public DoublyLinkedList(int val) {
        this.val = val;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
