package arrays;



import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wmc on 2015/1/24.
 */
public class ArraysAndCollectionsLearn {
    public static void main(String[] args) {
        Integer[] arrays1 = new Integer[5];
        Integer[] arrays2 = new Integer[5];

        Arrays.fill(arrays1,1);
        Arrays.fill(arrays2,1);


        // deepequal or equal

        System.out.println(Arrays.equals(arrays1, arrays2) ? "yes" : "no");
        System.out.println(Arrays.deepEquals(arrays1, arrays2) ? "yes" : "no");

        Object[] objects1 = {new String("hello"), new String[]{new String("hello")}};
        Object[] objects2 = {new String("hello"), new String[]{new String("hello")}};

        System.out.println(Arrays.equals(objects1, objects2) ? "yes" : "no");
        System.out.println(Arrays.deepEquals(objects1, objects2) ? "yes" : "no");

        Object[] objects3 = {new String("hello"), new Object[]{new String("hello")}};
        Object[] objects4 = {new String("hello"), new Object[]{new String("hello")}};

        System.out.println(Arrays.equals(objects3, objects4) ? "yes" : "no");
        System.out.println(Arrays.deepEquals(objects3, objects4) ? "yes" : "no");

        // copy_of

        Integer[] arrays3 = Arrays.copyOf(arrays1,2);
        Integer[] arrays4 = Arrays.copyOf(arrays1,10);


        System.out.println(StringUtils.join(Arrays.asList(arrays3),","));
        System.out.println(StringUtils.join(Arrays.asList(arrays4),","));  // fill with null

        // sort
        Integer[] arrays6 = {3,2,5,8,1};
        Arrays.sort(arrays6);
        System.out.println(StringUtils.join(Arrays.asList(arrays6),","));
        Arrays.sort(arrays6, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer integer2) {
                return integer <= integer2 ? 1 : -1;
            }
        });
        System.out.println(StringUtils.join(Arrays.asList(arrays6),","));

        // collections
        Collections.shuffle(Arrays.asList(arrays6));
        System.out.println(StringUtils.join(Arrays.asList(arrays6),","));
        Arrays.sort(arrays6, Collections.reverseOrder());
        System.out.println(StringUtils.join(Arrays.asList(arrays6),","));

        // unmodified
        List<Integer> list1 = Collections.unmodifiableList(Arrays.asList(arrays6));
        List<Integer> list2 = Arrays.asList(arrays6);
        try {
            list1.set(1,2);
        } catch (Exception e) {
            System.out.println(e);
        }

        list2.set(1,2);



    }


}
