//Author: Tushar Jaiswal
//Creation Date: 02/25/2017

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

    Queue<int> Head;
    
    /** Initialize your data structure here. */
    public MyStack() {
        Head = new Queue<int>();
    }
    
    /** Push element x onto stack. */
    public void Push(int x) {
        Head.Enqueue(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int Pop() {
        Queue<int> temp = new Queue<int>();
        int i = 0;
        int value = 0;
        foreach(int val in Head)
        {
            if(i != Head.Count - 1)
            {
                temp.Enqueue(val);
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
    public int Top() {
        int val = 0;
        foreach(int i in Head)
        {
            val = i;
        }
        return val;
    }
    
    /** Returns whether the stack is empty. */
    public bool Empty() {
        return Head.Count == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.Push(x);
 * int param_2 = obj.Pop();
 * int param_3 = obj.Top();
 * bool param_4 = obj.Empty();
 */