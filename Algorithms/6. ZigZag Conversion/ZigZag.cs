//Author: Tushar Jaiswal
//Creation Date: 06/05/2016

/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

Note: Since the question wasn't clear or had additional examples to demonstrate whether there will be just 1 column of single characters or multiple, this solution is for multiple characters in the column. So, it would work as shown for the following cases
convert("PAYPALISHIRING", 5) would return "PHASIYIRPLIGAN" 
P       H 
A     S I 
Y   I   R
P L     I G
A       N
and
convert("CANYOUSOLVETHISPROBLEM", 7) would return "CHATINESYVPMOLREUOOLSB".*/
public class Solution {
    public string Convert(string s, int numRows) {
        if(numRows <= 1) { return s; }
        
        StringBuilder[] rows = new StringBuilder[numRows];
        StringBuilder solution = new StringBuilder();
        
        int index=0, increment=1, i;
        
        for(i = 0; i < numRows; i++)
        {
            rows[i] = new StringBuilder();
        }
        
        for(i = 0; i < s.Length; i++)
        {
            rows[index].Append(s[i]);
            if(index == numRows - 1){ increment = -1; }
            else if(index == 0){ increment = 1; }
            index += increment;
        }
        
        for(i = 0; i < numRows; i++)
        {
            solution.Append(rows[i]);
        }
        
        return solution.ToString();
    }
}