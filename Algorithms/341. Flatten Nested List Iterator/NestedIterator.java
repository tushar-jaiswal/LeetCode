//Author: Tushar Jaiswal
//Creation Date: 10/29/2018

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
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Deque<NestedInteger> dq;
        
    public NestedIterator(List<NestedInteger> nestedList) {
        dq = new ArrayDeque<NestedInteger>();
        for(NestedInteger e : nestedList)
        {
            dq.offerLast(e);
        }
        removeEmptyLists();
    }

    @Override
    public Integer next() {
        removeEmptyLists();
        int val = dq.pollFirst().getInteger();
        removeEmptyLists();
        return val;
    }

    @Override
    public boolean hasNext() {
        return !dq.isEmpty();
    }
    
    private void removeEmptyLists()
    {
        while(!dq.isEmpty() && !dq.peekFirst().isInteger())
        {
            List<NestedInteger> curr = dq.pollFirst().getList();
            Deque<NestedInteger> stack = new ArrayDeque<NestedInteger>();
            for(NestedInteger e : curr)
            {
                stack.offerFirst(e);
            }
            while(!stack.isEmpty())
            {
                dq.offerFirst(stack.pollFirst());
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */