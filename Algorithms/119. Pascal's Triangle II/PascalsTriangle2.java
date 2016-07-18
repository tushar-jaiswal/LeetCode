//Author: Tushar Jaiswal
//Creation Date: 07/17/2016
/*Given an index k, return the kth row of the Pascal's triangle.
For example, given k = 3,
Return [1,3,3,1].
Note: Could you optimize your algorithm to use only O(k) extra space?*/
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> previous = new ArrayList<Integer>();
        
        previous.add(1);
        if(rowIndex == 0)
        {
            return previous;
        }
        
        previous.add(1);
        if(rowIndex == 1)
        {
            return previous;
        }
        
        for(int i = 2; i <= rowIndex; i++)
        {
            List<Integer> current = new ArrayList<Integer>();
            current.add(1);
            for(int j = 1; j < previous.size(); j++)
            {
                current.add(previous.get(j-1) + previous.get(j));
            }
            current.add(1);
            previous = current;
        }
        return previous;
    }
}