package leetcode;

import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
public class WordLadder {
    boolean existLadder(String start, String end, Set<String> dict) {
        if (StringUtils.isEmpty(start) || StringUtils.isEmpty(end) || start.length() != end.length()) {
            return false;
        }
        return existLadderHelper(start, end, dict);
    }

    boolean existLadderHelper(String start, String end, Set<String> dict) {
        if (dict.size() <= 0) {
            return false;
        }

        boolean result = false;
        for (int i = 0; i < start.length(); i++) {
            StringBuilder stringBuilder=new StringBuilder(start);
            for (char curChar = 'a'; curChar <= 'z'; curChar++) {
                stringBuilder.setCharAt(i, curChar);
                final String curString = stringBuilder.toString();
                if (curString.equals(start)) continue;
                if (dict.contains(curString)) {
                    if (curString.equals(end)) {
                        return true;
                    }
                    dict.remove(start);
                    result = result | existLadderHelper(curString, end, dict);
                    dict.add(start);
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {

        //bad case
        String start = "abg";
        String badCaseEnd = "bef";
        String goodCaseEnd = "bed";
        Set<String> data = new HashSet<>();
        data.add("bbg");
        data.add("abg");
        data.add("bed");
        data.add("abd");
        data.add("aed");
        WordLadder sample = new WordLadder();

        System.out.println(sample.existLadder(start, badCaseEnd, data));
        System.out.println(sample.existLadder(start, goodCaseEnd, data));

    }

}
