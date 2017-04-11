package leetcode;

/*
Given a non-empty string check if it can be constructed by taking a substring
of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String str) {
        for (int i = 1; i <= str.length() / 2; i++) {
            if (str.length() % i != 0) continue;
            if (isRepeatedSubString(str, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isRepeatedSubString(String str, int i) {
        String subItem = str.substring(0, i);
        for (int cur = i; cur < str.length(); cur +=i ) {
            if (!subItem.equals(str.substring(cur, cur + i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern sample = new RepeatedSubstringPattern();
        System.out.println(sample.repeatedSubstringPattern("abab"));
    }
}
