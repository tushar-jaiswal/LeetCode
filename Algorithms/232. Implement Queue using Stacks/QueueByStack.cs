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

    Stack<int> st;
    /** Initialize your data structure here. */
    public MyQueue() {
        st = new Stack<int>();
    }
    
    /** Push element x to the back of queue. */
    public void Push(int x) {
        st.Push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int Pop() {
        Stack<int> st2 = new Stack<int>();
        foreach(int i in st)
        {
            st2.Push(i);
        }
        int value = st2.Pop();
        st.Clear();
        foreach(int i in st2)
        {
            st.Push(i);
        }
        return value;
    }
    
    /** Get the front element. */
    public int Peek() {
        Stack<int> st2 = new Stack<int>();
        foreach(int i in st)
        {
            st2.Push(i);
        }
        return st2.Peek();
    }
    
    /** Returns whether the queue is empty. */
    public bool Empty() {
        return st.Count == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.Push(x);
 * int param_2 = obj.Pop();
 * int param_3 = obj.Peek();
 * bool param_4 = obj.Empty();
 */