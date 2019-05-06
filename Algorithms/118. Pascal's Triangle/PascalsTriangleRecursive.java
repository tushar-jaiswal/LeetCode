//Author: Tushar Jaiswal
//Creation Date: 05/06/2019

/*Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/

import java.util.*;

class Solution {
    HashMap<AbstractMap.SimpleEntry<Integer, Integer>, Integer> hashMap = new HashMap<AbstractMap.SimpleEntry<Integer, Integer>, Integer>();

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < numRows; i++)
        {
            List<Integer> row = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++)
            {
                row.add(getPascals(i, j));
            }
            result.add(row);
        }
        return result;
    }

    private int getPascals(int i, int j)
    {
        if(j == 0 || i == j)
        { return 1; }
        AbstractMap.SimpleEntry<Integer, Integer> key = new AbstractMap.SimpleEntry<Integer, Integer>(i, j);
        if(!hashMap.containsKey(key))
        { hashMap.put(key, getPascals(i - 1, j - 1) + getPascals(i - 1, j)); }
        return hashMap.get(key);
    }
}
