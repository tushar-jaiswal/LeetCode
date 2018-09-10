//Author: Tushar Jaiswal
//Creation Date: 01/14/2018

/*Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).*/

public class Solution {
    public int MaxProfit(int[] prices) {
        int totalProfit = 0, min = -1, currentProfit = -1;
        if(prices.Length != 0)
        {
            min = 0; 
        }
        for(int i = 1; i < prices.Length; i++)
        {
            int profit = prices[i] - prices[min];
            
            if(profit > 0 && profit >= currentProfit)
            { 
                currentProfit = profit; 
                if(i == prices.Length - 1)
                {
                    totalProfit += currentProfit;
                }
            }
            else 
            {
                min = i;
                if(currentProfit != -1)
                {
                    totalProfit += currentProfit;
                    currentProfit = -1;
                }
            }
        }
        return totalProfit;
    }
}