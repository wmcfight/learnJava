package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] strArray = new int[256];
        int[] comArray = new int[256];

        for (int i = 0; i < p.length(); i++) {
            comArray[p.charAt(i)]++;
        }

        int begin = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i);
            strArray[cur]++;
            if (strArray[cur] > comArray[cur]) {
                continue;
            }

        }

        return null;
    }
}
