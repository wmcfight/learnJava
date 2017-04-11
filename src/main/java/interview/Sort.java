package interview;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Sort {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String review = br.readLine();
//        String[] word = review.split(" ");
//        int num = Integer.valueOf(br.readLine());
//        Map<Integer, List<String>> words = new HashMap<>();
//
//        int cur = 0;
//        while (cur < num) {
//            int id = Integer.valueOf(br.readLine());
//            String[] reviews = br.readLine().split(" ");
//            List<String> data = words.getOrDefault(id, new ArrayList<>());
//            data.addAll(Arrays.asList(reviews));
//            words.put(id, data);
//            cur++;
//        }

        Map<Integer, List<String>> data = new HashMap<>();
        data.put(2, Arrays.asList("a", "b", "c"));
        data.put(1, Arrays.asList("d", "b", "c"));
        data.put(3, Arrays.asList("e", "b", "c", "f"));
        Set<String> word = new HashSet<>(Arrays.asList("b", "c", "f"));
        solution(data, word);

    }

    public static void solution(Map<Integer, List<String>> data, Set<String> word) {
        List<Pair<Integer, Integer>> dataList = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : data.entrySet()) {
            int id = (int) entry.getKey();
            int sum = 0;
            for (String item : entry.getValue()) {
                if (word.contains(item)) {
                    sum++;
                }
            }
            dataList.add(new Pair<>(sum, id));
        }
        dataList.sort(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                int result = 0;
                if (o1.getKey() < o2.getKey()) {
                    result = 1;
                } else if (o1.getKey() > o2.getKey()) {
                    result = -1;
                } else {
                    result = o1.getValue() <= o2.getValue() ? -1 : 1;
                }
                return result;
            }
        });
        for (int i = 0; i < dataList.size(); i++) {
            System.out.println(dataList.get(i).getValue() + " ");
        }
    }



}
