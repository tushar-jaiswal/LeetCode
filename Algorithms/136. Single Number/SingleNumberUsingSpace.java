//Author: Tushar Jaiswal
//Creation Date: 03/15/2018

/*Given an array of integers, every element appears twice except for one. Find that single one.
Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/

class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i : nums)
        {
            if(hs.contains(i))
            { hs.remove(i); }
            else
            { hs.add(i); }
        }
        int result = 0;
        for(int i : hs)
        { result = i; }
        return result;
    }
}