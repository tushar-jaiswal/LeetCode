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

class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
          @Override
            public int compare(Integer n1, Integer n2)
            {
                String s1 = n1.toString();
                String s2 = n2.toString();
                long num1 = Long.parseLong(s1 + s2);
                long num2 = Long.parseLong(s2 + s1);
                return num2 - num1 > 0 ? 1 : -1;
            }
        });
        for(int i : nums)
        {
            pq.offer(i);
        }
        if(pq.peek() == 0)
        { return "0"; }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty())
        {
            sb.append(pq.poll());
        }
        return sb.toString();
    }
}