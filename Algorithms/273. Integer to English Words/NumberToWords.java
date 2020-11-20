//Author: Tushar Jaiswal
//Creation Date: 11/20/2020

/*Convert a non-negative integer num to its English words representation.

Example 1:
Input: num = 123
Output: "One Hundred Twenty Three"

Example 2:
Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:
Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

Example 4:
Input: num = 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"

Constraints:0 <= num <= 231 - 1
*/

/*Runtime Complexity: O(Number of digits)
Space Complexity: O(1)*/

class Solution {

    Map<Integer, String> DIGITS_MAP = new HashMap<Integer, String>() {{
        put(0, "Zero");
        put(1, "One");
        put(2, "Two");
        put(3, "Three");
        put(4, "Four");
        put(5, "Five");
        put(6, "Six");
        put(7, "Seven");
        put(8, "Eight");
        put(9, "Nine");
    }};

    Map<Integer, String> TEENS_MAP = new HashMap<Integer, String>() {{
        put(11, "Eleven");
        put(12, "Twelve");
        put(13, "Thirteen");
        put(14, "Fourteen");
        put(15, "Fifteen");
        put(16, "Sixteen");
        put(17, "Seventeen");
        put(18, "Eighteen");
        put(19, "Nineteen");
    }};

    Map<Integer, String> TENS_MAP = new HashMap<Integer, String>() {{
        put(1, "Ten");
        put(2, "Twenty");
        put(3, "Thirty");
        put(4, "Forty");
        put(5, "Fifty");
        put(6, "Sixty");
        put(7, "Seventy");
        put(8, "Eighty");
        put( 9, "Ninety");
    }};

    Map<Integer, String> SUFFIX_MAP = new HashMap<Integer, String>() {{
        put(1, "");
        put(1000, "Thousand");
        put(1000000, "Million");
        put(1000000000, "Billion");
    }};

    public String numberToWords(int num) {
        StringBuilder result = new StringBuilder();

        int suffixNum = 1;
        do {
            StringBuilder currentNum = new StringBuilder();
            int remainder = num % 1000;
            num /= 1000;
            if (remainder != 0 || num == 0) {
                currentNum.append(getHundredsNumberInWords(remainder));
            }
            if (suffixNum != 1 && remainder != 0) {
                currentNum.append(" ");
                currentNum.append(SUFFIX_MAP.get(suffixNum));
            }

            if (suffixNum > 1 && remainder != 0) {
                result.insert(0, " ");
            }

            result.insert(0, currentNum);
            suffixNum *= 1000;
        } while (num != 0);

        return result.toString().trim();
    }

    private StringBuilder getHundredsNumberInWords(int num) {
        StringBuilder result = new StringBuilder();
        int remainder = num % 100;
        if (num >= 100) {
            result.append(DIGITS_MAP.get(num/100));
            result.append(" ");
            result.append("Hundred");
            if (remainder == 0) {
                return result;
            }
            result.append(" ");
        }

        result.append(getTensNumberInWords(remainder));

        return result;
    }

    private StringBuilder getTensNumberInWords(int num) {
        StringBuilder result = new StringBuilder();
        if (num > 10 && num < 20) {
            result.append(TEENS_MAP.get(num));
        } else {
            int remainder = num % 10;
            int quotient = num / 10;
            if (quotient != 0) {
                result.append(TENS_MAP.get(quotient));
                if (remainder != 0) {
                    result.append(" ");
                }
            }
            if (remainder != 0 || quotient == 0) {
                result.append(DIGITS_MAP.get(remainder));
            }


        }
        return result;
    }
}
