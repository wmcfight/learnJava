package leetcode;

/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 */
/**
 * 非常类似MinimumWindowSubstring 题目
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransom = new char[256];
        char[] maga = new char[256];
        for (int i = 0; i < magazine.length(); i++) {
            maga[magazine.charAt(i)]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int cur = ransomNote.charAt(i);
            ransom[cur]++;
            if (ransom[cur] > maga[cur]) {
                return false;
            }
        }
        return true;
    }
}
