package leetcode;

/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] data = new int[26];
        for (int i = 0 ; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            data[cur]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int cur = t.charAt(i) - 'a';
            data[cur]--;
        }

        for (int i = 0; i < data.length; i++) {
            if (data[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
