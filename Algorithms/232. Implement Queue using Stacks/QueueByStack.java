//Author: Tushar Jaiswal
//Creation Date: 03/21/2017

/*Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).*/

public class MyQueue {

    Deque<Integer> st;
    /** Initialize your data structure here. */
    public MyQueue() {
        st = new ArrayDeque<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        st.addFirst(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Deque<Integer> st2 = new ArrayDeque<Integer>();
        for(Integer i: st)
        {
            st2.addFirst(i);
            st.removeFirst();
        }
        int value = st2.removeFirst();
        for(Integer i: st2)
        {
            st.addFirst(i);
        }
        return value;
    }
    
    /** Get the front element. */
    public int peek() {
        Deque<Integer> st2 = new ArrayDeque<Integer>();
        for(Integer i: st)
        {
            st2.addFirst(i);
        }
        return st2.peekFirst();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */