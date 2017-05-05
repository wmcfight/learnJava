package leetcode;

/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 Example:
 Input: s = "abcdefg", k = 2
 Output: "bacdfeg"
 Restrictions:
 The string consists of lower English letters only.
 Length of the given string and k will in the range [1, 10000]
 */

/**
 * 解题思路：
 * String to char[]
 * char[] to String
 *
 * char[] data = s.toCharArray();
 * s = String.valueOf(data);
 */
public class ReverseStringII {

    public String reverseStr(String s, int k) {
        int cur = 0;
        int end = cur + k -1;
        char[] data = s.toCharArray();
        for (cur = 0 ; cur < data.length ;) {
            end = (end < data.length ) ? end : data.length - 1;
            for(int i = cur, j = end; i< j; i++, j--) {
                char temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
            if (end < data.length) {
                cur = end + k + 1;
                end = cur + k - 1;
            }
        }
        return String.valueOf(data);
    }
}
