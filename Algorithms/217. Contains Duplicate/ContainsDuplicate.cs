//Author: Tushar Jaiswal
//Creation Date: 02/24/2017

/*Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.*/
public class Solution {
    public bool ContainsDuplicate(int[] nums) {
        Dictionary<int, bool> elements = new Dictionary<int, bool>();
        
        foreach(int i in nums)
        {
            if(elements.ContainsKey(i))
            { return true; } 
            elements.Add(i,true);
        }
        return false;
    }
}