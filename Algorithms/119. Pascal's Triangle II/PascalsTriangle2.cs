//Author: Tushar Jaiswal
//Creation Date: 07/17/2016
/*Given an index k, return the kth row of the Pascal's triangle.
For example, given k = 3,
Return [1,3,3,1].
Note: Could you optimize your algorithm to use only O(k) extra space?*/
public class Solution {
    public IList<int> GetRow(int rowIndex) {
        IList<int> previous = new List<int>(){1};
        
        if(rowIndex == 0)
        {
            return previous;
        }
        
        previous.Add(1);
        if(rowIndex == 1)
        {
            return previous;
        }
        
        for(int i = 2; i <= rowIndex; i++)
        {
            IList<int> current = new List<int>(){1};
            for(int j = 1; j < previous.Count; j++)
            {
                current.Add(previous[j-1] + previous[j]);
            }
            current.Add(1);
            previous = current;
        }
        return previous;
    }
}