package leetcode;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 Example 1:
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */

import java.util.Stack;

/**
 * use stack
 */
public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        Stack<String> resultStack = new Stack<>();
        String temp = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (temp.length() >= 1) {
                    resultStack.add(temp);
                    temp = "";
                }
                resultStack.add(" ");
            } else {
                temp += s.charAt(i);
            }
        }
        if (temp.length() >= 1) {
            resultStack.add(temp);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!resultStack.empty()) {
            stringBuilder.append(resultStack.pop());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ReverseWordsinaStringIII sample = new ReverseWordsinaStringIII();
        System.out.println(sample.reverseWords("I am happy"));
    }
}
