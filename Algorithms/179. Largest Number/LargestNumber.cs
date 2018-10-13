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
        SortedList<int, int> heap = new SortedList<int, int>(new NumberComparer());
        foreach(int i in nums)
        {
            heap.Add(i, 0);
        }
        if(heap.Keys[0] == 0)
        { return "0"; }
        StringBuilder sb = new StringBuilder();
        while(heap.Count != 0)
        {
            int num = heap.Keys[0];
            sb.Append(num);
            heap.RemoveAt(0);
        }
        return sb.ToString();
    }
}

public class NumberComparer : IComparer<int>
{
    public int Compare(int n1, int n2)
    {
        string s1 = n1.ToString();
        string s2 = n2.ToString();
        long num1 = Convert.ToInt64(s1 + s2);
        long num2 = Convert.ToInt64(s2 + s1);
        return num2 - num1 > 0 ? 1 : -1;
    }
}