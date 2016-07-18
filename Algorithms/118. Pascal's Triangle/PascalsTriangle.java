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
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> previous = new ArrayList<Integer>(){};
        previous.add(1);
        previous.add(1);
        
        if(numRows >= 1)
        { 
            List<Integer> first = new ArrayList<Integer>(){};
            first.add(1);
            result.add(first);
        }
        if(numRows >= 2)
        { 
            result.add(previous); 
        }
        
        if(numRows >= 3)
        {
            for(int i = 2; i < numRows; i++)
            {
                List<Integer> current = new ArrayList<Integer>();
                current.add(1);
                for(int j = 1; j < previous.size(); j++)
                {
                    current.add(previous.get(j-1) + previous.get(j));
                }
                current.add(1);
                result.add(current);
                previous = current;
            }
        }
        
        return result;
    }
}