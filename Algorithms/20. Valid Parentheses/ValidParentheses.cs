//Author: Tushar Jaiswal
//Creation Date: 06/11/2016

/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.*/
public class Solution {
    public bool IsValid(string s) {
        Stack stack = new Stack();
        foreach(char c in s)
        {
            char peek = '0';
            if(stack.Count != 0)
            { peek = (char)stack.Peek(); }
            if(stack.Count != 0 && peek == c)
            {
                stack.Pop();
            }
            else
            {
                stack.Push(getCounterBracket(c));
            }
        }
        if(stack.Count == 0)
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