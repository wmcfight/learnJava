package leetcode;

/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
/**
 * 得考虑CCCC 之类的条件，每次是加对应最小偶数
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] tar = new int[256];
        for (int i = 0; i < s.length(); i++) {
            tar[s.charAt(i)]++;
        }
        boolean hasOdd = false;
        int result = 0;
        for (int i= 0; i < tar.length; i++) {
            if (tar[i] > 0) {
                result += (tar[i]/2) * 2;
                if (tar[i] % 2 != 0) {
                    hasOdd = true;
                }
            }
        }

        return hasOdd ? result + 1 : result;
    }
}
