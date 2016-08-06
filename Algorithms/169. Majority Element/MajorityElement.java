//Author: Tushar Jaiswal
//Creation Date: 08/02/2016

/*Given an array of size n, find the majority element. The majority element is the element that appears more than ? n/2 ? times.
You may assume that the array is non-empty and the majority element always exist in the array.*/

public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int majority =  nums.length / 2;
        
        for(int n : nums)
        {
            int count;
            if(map.containsKey(n))
            {
                count = map.get(n) + 1;
                map.put(n, count);
            }
            else
            {
                map.put(n, 1);
                count = 1;
            }
            if(count > majority)
            {
                return n;
            }
        }
        return 0;
    }
}