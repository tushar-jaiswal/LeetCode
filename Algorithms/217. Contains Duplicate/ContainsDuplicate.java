//Author: Tushar Jaiswal
//Creation Date: 02/24/2017

/*Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.*/
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> elements = new HashMap<Integer, Boolean>();
        
        for(int i: nums)
        {
            if(elements.containsKey(i))
            { return true; } 
            elements.put(i,true);
        }
        return false;
    }
}