//Author: Tushar Jaiswal
//Creation Date: 08/02/2016

/*Given an array of size n, find the majority element. The majority element is the element that appears more than ? n/2 ? times.
You may assume that the array is non-empty and the majority element always exist in the array.*/

public class Solution {
    public int MajorityElement(int[] nums) {
        Dictionary<int, int> dict = new Dictionary<int, int>();
        int majority =  nums.Length / 2;
        
        foreach(int n in nums)
        {
            int count;
            if(dict.TryGetValue(n, out count))
            {
                count++;
                dict[n] = count;
            }
            else
            {
                dict.Add(n, 1);
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