//Author: Tushar Jaiswal
//Creation Date: 07/17/2016
/*Given numRows, generate the first numRows of Pascal's triangle.
For example, given numRows = 5,
Return
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/
public class Solution {
    public IList<IList<int>> Generate(int numRows) {
        List<IList<int>> result = new List<IList<int>>();
        List<int> previous = new List<int>(){1,1};
        
        if(numRows >= 1)
        { result.Add(new List<int>(){1}); }
        if(numRows >= 2)
        { result.Add(previous); }
        
        if(numRows >= 3)
        {
            for(int i = 2; i < numRows; i++)
            {
                List<int> current = new List<int>();
                current.Add(1);
                for(int j = 1; j < previous.Count; j++)
                {
                    current.Add(previous[j-1] + previous[j]);
                }
                current.Add(1);
                result.Add(current);
                previous = current;
            }
        }
        
        return result;
    }
}