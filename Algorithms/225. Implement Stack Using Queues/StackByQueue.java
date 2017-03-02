//Author: Tushar Jaiswal
//Creation Date: 03/01/2017

/*Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).*/

public class MyStack {

    Queue<Integer> Head;

    /** Initialize your data structure here. */
    public MyStack() {
        Head = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        Head.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> temp = new LinkedList<Integer>();
        int i = 0;
        int value = 0;
        for(Integer val: Head)
        {
            if(i != Head.size() - 1)
            {
                temp.add(val);
            }
            else
            {
                value = val;
            }
            i++;
        }
        Head = temp;
        return value;
    }
    
    /** Get the top element. */
    public int top() {
        int val = 0;
        for(int i: Head)
        {
            val = i;
        }
        return val;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return Head.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */