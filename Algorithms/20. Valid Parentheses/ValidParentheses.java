//Author: Tushar Jaiswal
//Creation Date: 06/11/2016

/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.*/
public class Solution {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        for(char c: s.toCharArray())
        {
            char peek = '0';
            if(!stack.empty())
            {
                peek = (char) stack.peek();
            }
            if(stack.empty() || c != peek)
            {
                stack.push(getCounterBracket(c));
            }
            else
            {
                stack.pop();
            }
        }
        if(stack.empty())
        { return true; }
        else
        { return false; }
    }
    
    private char getCounterBracket(char c)
    {
        switch (c)
        {
            case '{': return '}';
            case '}': return '{';
            case '[': return ']';
            case ']': return '[';
            case '(': return ')';
            case ')': return '(';
            default: return '0';
        }
    }
}