//Author: Tushar Jaiswal
//Creation Date: 10/17/2018

/*You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Note: You may assume that you have an infinite number of each kind of coin.*/

public class Solution {
    public int CoinChange(int[] coins, int amount) {
        if(amount < 0 || coins.Length == 0)
        { return -1; }
        int[] coinsToAmount = new int[amount + 1];
        coinsToAmount[0] = 0;
        
        for(int i = 1; i <= amount; i++)
        {
            int min = Int32.MaxValue;
            foreach(int coin in coins)
            {
                if(coin <= i)
                {
                    int rem = i - coin;
                    int count = Int32.MaxValue;
                    if(coinsToAmount[rem] != -1)
                    {
                        count = coinsToAmount[rem] + 1;
                    }
                    min = Math.Min(min, count);
                }
            }
            coinsToAmount[i] = min == Int32.MaxValue ? -1 : min;
        }
        
        return coinsToAmount[amount];
    }
}