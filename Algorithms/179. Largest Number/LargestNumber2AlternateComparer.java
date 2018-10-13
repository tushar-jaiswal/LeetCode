//Author: Tushar Jaiswal
//Creation Date: 10/13/2018

/*Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:
Input: [10,2]
Output: "210"

Example 2:
Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.*/

class Solution {
    public String largestNumber(int[] nums) {
        Integer[] sorted = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            sorted[i] = nums[i];
        }
        Arrays.sort(sorted, new NumberComparer());
                
        if(sorted[0] == 0)
        { return "0"; }
        StringBuilder sb = new StringBuilder();
        for(int num : sorted)
        {
            sb.append(num);
        }
        return sb.toString();
    }
    
    private class NumberComparer implements Comparator<Integer> {
        @Override
        public int compare(Integer n1, Integer n2)
        {
            String s1 = n1.toString();
            String s2 = n2.toString();
            long num1 = Long.parseLong(s1 + s2);
            long num2 = Long.parseLong(s2 + s1);
            return num2 - num1 > 0 ? 1 : -1;
        }
    }
}