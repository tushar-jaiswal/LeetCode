//Author: Tushar Jaiswal
//Creation Date: 07/17/2016
/*Given an index k, return the kth row of the Pascal's triangle.
For example, given k = 3,
Return [1,3,3,1].
Note: Could you optimize your algorithm to use only O(k) extra space?*/
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        
        for(int i = 1; i <= rowIndex; i++)
        {
            for(int j = result.size(); j > 1; j--)
            {
                result.set(j-1, result.get(j-1) + result.get(j-2));
            }
            result.add(1);
        }
        
        return result;
    }
}