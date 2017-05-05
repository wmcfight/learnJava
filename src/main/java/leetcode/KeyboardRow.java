package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Given a List of words, return the words that can be typed using letters of alphabet
 * on only one row's of American keyboard like the image below.
 */
public class KeyboardRow {
    private static Map<Character, Integer> data = new HashMap<>();
    static {
        data.put('a', 2); data.put('l', 2); data.put('m', 3); data.put('x', 3); data.put('y', 1);
        data.put('b', 3); data.put('k', 2); data.put('n', 3); data.put('w', 1); data.put('z', 3);
        data.put('c', 3); data.put('j', 2); data.put('o', 1); data.put('v', 3);
        data.put('d', 2); data.put('i', 1); data.put('p', 1); data.put('u', 1);
        data.put('e', 1); data.put('h', 2); data.put('q', 1); data.put('t', 1);
        data.put('f', 2); data.put('g', 2); data.put('r', 1); data.put('s', 2);
    }
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (!searchWord(word)) {
                result.add(word);
            }
        }
        return (String[]) result.toArray();
    }
    private boolean searchWord(String word) {
        if (word == null || word.length() <= 0) return false;
        if (!Character.isAlphabetic(word.charAt(0))) return false;
        int curBegin = data.get(Character.toLowerCase(word.charAt(0)));
        for (int i = 1; i < word.length(); i++) {
            if (!Character.isAlphabetic(word.charAt(i))
                    || curBegin != data.get(Character.toLowerCase(word.charAt(i)))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] input = {"Hello","Alaska","Dad","Peace"};
        KeyboardRow sample = new KeyboardRow();
        System.out.println(sample.findWords(input));
    }
}
