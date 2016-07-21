//Author: Tushar Jaiswal
//Creation Date: 07/20/2016
/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.*/
class Node{
    public int value;
    public int min;
    public Node next;
    
    public Node(int val)
    {
        value = val;
    }
}

public class MinStack {

    /** initialize your data structure here. */
    public Node head;
    
    public MinStack() {
    }
    
    public void push(int x) {
        Node temp = new Node(x);
        temp.next = head;
        
        if(head != null && x > head.min)
        {
            temp.min = head.min;
        }
        else
        {
            temp.min = x;
        }
        
        head = temp;
    }
    
    public void pop() {
        if( head != null)
        {
            head = head.next;
        }
    }
    
    public int top() {
        if(head == null)
        {
            return -1;
        }
        return head.value;
    }
    
    public int getMin() {
        if(head == null)
        {
            return -1;
        }
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */