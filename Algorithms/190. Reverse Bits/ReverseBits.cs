//Author: Tushar Jaiswal
//Creation Date: 08/05/2016

/*Reverse bits of a given 32 bits unsigned integer.
For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
Follow up: If this function is called many times, how would you optimize it?*/

public class Solution {
    public uint reverseBits(uint n) {
        List<uint> binaryNumbers = new List<uint>();
        
        do
        {
            binaryNumbers.Add(n % 2);
            n = n/2;
        }while(n != 0);
        
        while(binaryNumbers.Count != 32)
        {
            binaryNumbers.Add(0);
        }
        
        double multiplier = (Math.Pow(2, binaryNumbers.Count));
        
        for(int i = 0; i < binaryNumbers.Count; i++)
        {
            multiplier /= 2;
            n += binaryNumbers[i] * (uint)(multiplier);
        }
        return n;
    }
}