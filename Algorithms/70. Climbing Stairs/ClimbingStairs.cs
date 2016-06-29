//Author: Tushar Jaiswal
//Creation Date: 06/28/2016
/*You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/
public class Solution {
    private static readonly Dictionary<int, int> MAP = new Dictionary<int, int>();
    
    public int ClimbStairs(int n) {
        if(n <= 2)
        { return n; }
        
        if(!MAP.ContainsKey(n))
        {
            MAP.Add(n, ClimbStairs(n-1) + ClimbStairs(n-2));
        }
        
        return MAP[n];
    }
}