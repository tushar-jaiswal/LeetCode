//Author: Tushar Jaiswal
//Creation Date: 10/13/2018

/*Implement a basic calculator to evaluate a simple expression string.
The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:
Input: "3+2*2"
Output: 7

Example 2:
Input: " 3/2 "
Output: 1

Example 3:
Input: " 3+5 / 2 "
Output: 5

Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.*/

//Good test case: "-3 + 2 * 4 "

using System.Text.RegularExpressions;

public class Solution {
    public int Calculate(string s) {
        s = Regex.Replace(s, "\\s", "");
        Stack<int> stack = new Stack<int>();
        char sign = '+';
        for(int i = 0; i < s.Length; i++)
        {
            int num = 0; 
            while(i < s.Length && s[i] >= '0' && s[i] <= '9')
            {
                num = num * 10 + s[i] - '0';
                i++;
            }
            switch(sign)
            {
                case '+': stack.Push(num);
                    break;
                case '-': stack.Push(-num);
                    break;
                case '*': stack.Push(stack.Pop() * num);
                    break;
                case '/': stack.Push(stack.Pop() / num);
                    break;
            }
            if(i < s.Length)
            {
                sign = s[i];
            }
        }
        int result = 0;
        while(stack.Count != 0)
        {
            result += stack.Pop();
        }
        return result;
    }
}