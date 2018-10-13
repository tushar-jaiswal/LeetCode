//Author: Tushar Jaiswal
//Creation Date: 10/12/2018

/*Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:
Input: [10,2]
Output: "210"

Example 2:
Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.*/

public class Solution {
    public string LargestNumber(int[] nums) {
        Array.Sort(nums, CompareNumbers);
        
        if(nums[0] == 0)
        { return "0"; }
        StringBuilder sb = new StringBuilder();
        foreach(int num in nums)
        {
            sb.Append(num);
        }
        return sb.ToString();
    }
    
    public int CompareNumbers(int n1, int n2)
    {
        string s1 = n1.ToString();
        string s2 = n2.ToString();
        long num1 = Convert.ToInt64(s1 + s2);
        long num2 = Convert.ToInt64(s2 + s1);
        int result = (int)(num2 - num1);
        return result == 0 ? 1 : result;
    }
}