package leetcode;

/**
 * Given an integer, return its base 7 string representation.

 Example 1:
 Input: 100
 Output: "202"
 Example 2:
 Input: -7
 Output: "-10"
 Note: The input will be in range of [-1e7, 1e7].


 */

/**
 * 解题思路： 注意0，
 * 注意负号
 */
public class Base7 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuffer resultBuffer = new StringBuffer();
        boolean negative = num < 0;
        num = Math.abs(num);
        while(num != 0) {
            resultBuffer.append(num % 7);
            num = num / 7;
        }
        if (negative) {
            resultBuffer.append("-");
        }
        return resultBuffer.reverse().toString();

    }

    //
    public String convertToBase10(int num) {
        return null;
    }
}
