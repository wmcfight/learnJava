package leetcode;


/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

 * 解题思路：
 * 用两个字符数组控制，非常精妙
 * http://www.jianshu.com/p/ce80b4c07c22
 *
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        int[] srcHash = new int[255];
        int[] descHash = new int[255];
        for (int i = 0 ;i < t.length(); i++) {
            srcHash[t.charAt(i)]++;
        }

        int begin = -1, end = s.length(), minLen = s.length();
        int cur = 0;
        int foundNum = 0;
        for (int i = 0; i < s.length(); i++) {
            descHash[s.charAt(i)]++;
            if (descHash[s.charAt(i)] <= srcHash[s.charAt(i)]) {
                foundNum++;
            }
            if (foundNum == t.length()) {
                while (cur < i && (descHash[s.charAt(cur)] > srcHash[s.charAt(cur)])) {
                    descHash[s.charAt(cur)]--;
                    cur++;
                }
                if (i - cur < minLen) {
                    minLen = i - cur;
                    begin = cur;
                    end = i;
                }
                descHash[s.charAt(cur)]--;
                cur++;
                foundNum--;
            }

        }

        return begin == -1 ? "" : s.substring(begin, end + 1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring sample = new MinimumWindowSubstring();
        System.out.println(sample.minWindow("bdab", "ab"));
    }
}
