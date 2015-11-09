package functionCoding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mwei on 15-11-9.
 */
public class WordCount {
    private Set<String> NON_WORDS = new HashSet<String>() {{
        add("the");add("and");
    }};

    private List<String> regexToList(String words, String regex) {
        List wordList = new ArrayList();

        Matcher m = Pattern.compile(regex).matcher(words);
        while (m.find())
            wordList.add(m.group());
        return wordList;
    }

    public Map wordFreg(String words) {
        final TreeMap<String, Integer> wordMap = new TreeMap<String, Integer>();
        regexToList(words, "\\w+").stream().map(w -> w.toLowerCase())
                .filter(w -> !NON_WORDS.contains(w))
                .forEach(w -> wordMap.put(w, wordMap.getOrDefault(w, 0) + 1));
        return wordMap;
    }


    public static void main(String[] args) {
        WordCount wordCount = new WordCount();
        String words = "Hello world, I am hello world";
        Map data = wordCount.wordFreg(words);

        System.out.println(data);
    }
}
