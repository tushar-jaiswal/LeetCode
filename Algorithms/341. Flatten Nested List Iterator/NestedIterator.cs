//Author: Tushar Jaiswal
//Creation Date: 11/01/2018

/*Given a nested list of integers, implement an iterator to flatten it.
Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,4,6].*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     bool IsInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     int GetInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     IList<NestedInteger> GetList();
 * }
 */
public class NestedIterator {
    Stack<NestedInteger> stack;

    public NestedIterator(IList<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        for(int i = nestedList.Count - 1; i >= 0; i--)
        {
            stack.Push(nestedList[i]);
        }
    }

    public bool HasNext() {
        while(stack.Count != 0 && !stack.Peek().IsInteger())
        {
            IList<NestedInteger> list = stack.Pop().GetList();
            for(int i = list.Count - 1; i >= 0; i--)
            {
                stack.Push(list[i]);
            }
        }
        return stack.Count != 0;
    }

    public int Next() {
        return stack.Pop().GetInteger();
    }
}

/**
 * Your NestedIterator will be called like this:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.HasNext()) v[f()] = i.Next();
 */