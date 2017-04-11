package leetcode;
/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
 */
//**
public class ReverseString {
    public String reverseString(String s) {
        if (s == null || s.length() <= 1) return s;

        int begin = 0, end = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (begin < end) {
            char bc = charArray[begin];
            charArray[begin] = charArray[end];
            charArray[end] = bc;
            begin++;
            end--;
        }
        return String.valueOf(charArray);
    }
}
