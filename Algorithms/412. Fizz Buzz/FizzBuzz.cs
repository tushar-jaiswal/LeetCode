//Author: Tushar Jaiswal
//Creation Date: 07/10/2017

/*Write a program that outputs the string representation of numbers from 1 to n. But for multiples of three it should output �Fizz� instead of the number and for the multiples of five output �Buzz�. For numbers which are multiples of both three and five output �FizzBuzz�.

Example:
n = 15,
Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]*/

public class Solution {
    public IList<string> FizzBuzz(int n) {
        List<string> result = new List<string>();
        
        for(int i = 1; i <= n; i++)
        {
            String s;
            if(i % 3 == 0)
            {
                if(i % 5 == 0)
                {
                    s = "FizzBuzz";
                }
                else
                {
                    s = "Fizz";
                }
            }
            else if(i % 5 == 0)
            {
                s = "Buzz";                
            }
            else
            {
                s = i.ToString();
            }
            result.Add(s);
        }
        return result;        
    }
}