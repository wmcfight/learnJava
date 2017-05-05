package leetcode;

import org.apache.commons.lang.StringUtils;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.

 We define the usage of capitals in a word to be right when one of the following cases holds:

 All letters in this word are capitals, like "USA".
 All letters in this word are not capitals, like "leetcode".
 Only the first letter in this word is capital if it has more than one letter, like "Google".
 Otherwise, we define that this word doesn't use capitals in a right way.
 Example 1:
 Input: "USA"
 Output: True
 Example 2:
 Input: "FlaG"
 Output: False
 */

/**
 * 分开区别
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if(word.length() <= 1) return true;
        if(Character.isLowerCase(word.charAt(0)) ||
                (Character.isUpperCase(word.charAt(0)) && Character.isLowerCase(word.charAt(1)))) {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isLowerCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        DetectCapital sample = new DetectCapital();
        System.out.println(sample.detectCapitalUse("FlaG"));

    }


}
