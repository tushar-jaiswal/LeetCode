//Author: Tushar Jaiswal
//Creation Date: 06/28/2016
/*You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/
public class Solution {
    private static final HashMap<Integer, Integer> MAP = new HashMap<Integer, Integer>();
    
    public int climbStairs(int n) {
        if(n <= 2)
        { return n; }
        
        if(MAP.get(n) == null)
        { 
            MAP.put(n, climbStairs(n-1) + climbStairs(n-2));
        }
        return MAP.get(n);
    }
}