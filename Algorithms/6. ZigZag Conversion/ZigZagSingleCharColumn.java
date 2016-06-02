//Author: Tushar Jaiswal
//Creation Date: 06/01/2016

/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

Note: Since the question wasn't clear or had additional examples to demonstrate whether there will be just 1 column of single characters or multiple, this solution is for single characters in the column. So, it would work for the following cases
convert("PAYPALISHIRING", 5) would return "PINASGYLHIPIAR" 
P   I   N
A   S   G
Y L H I 
P   I  
A   R  
and
convert("CANYOUSOLVETHISPROBLEM", 7) would return "CLRAVONEBYOTPLOHEUIMSS".*/
public class Solution {
    public String convert(String s, int numRows) {
        String solution = "";
        int middleRow = (int) Math.ceil(numRows/2);
        for (int i = 0; i < numRows; i++)
        {
            if(i != middleRow)
            {
                for(int j = i; j < s.length(); j=j+numRows+1)
                { solution += s.charAt(j); }
            }
            else
            {
                for(int j = i; j < s.length(); j=j+((int) Math.floor(numRows/2))+1)
                { solution += s.charAt(j); }
            }
        }
        return solution;
    }
}