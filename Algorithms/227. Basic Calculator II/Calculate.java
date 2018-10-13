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

class Solution {
    public int calculate(String s) {
        s = s.replaceAll("\\s", "");
        Deque<Integer> stack = new ArrayDeque<Integer>();
        char sign = '+';
        for(int i = 0; i < s.length(); i++)
        {
            int num = 0; 
            while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9')
            {
                num = num * 10 + s.charAt(i) - '0';
                i++;
            }
            switch(sign)
            {
                case '+': stack.addFirst(num);
                    break;
                case '-': stack.addFirst(-num);
                    break;
                case '*': stack.addFirst(stack.removeFirst() * num);
                    break;
                case '/': stack.addFirst(stack.removeFirst() / num);
                    break;
            }
            if(i < s.length())
            {
                sign = s.charAt(i);
            }
        }
        int result = 0;
        while(!stack.isEmpty())
        {
            result += stack.removeFirst();
        }
        return result;
    }
}