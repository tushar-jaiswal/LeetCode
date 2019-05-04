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
      for(int i = 0; i < numRows; i++)
      {
          List<int> curr = new List<int>();
          for(int j = 0; j <= i; j++)
          {
              if(j == 0 || j == i)
              { curr.Add(1); }
              else
              {
                  List<int> prev = (List<int>)result[i - 1];
                  curr.Add(prev[j - 1] + prev[j]);
              }
          }
          result.Add(curr);
      }
      return result;
    }
}
