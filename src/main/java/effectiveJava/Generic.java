package effectiveJava;

import java.util.*;

/**
 * Created by wmc on 2015/10/5.
 */
public class Generic {

    public static <K,V> HashMap<K,V> newHashMap() {
        return new HashMap<K, V>();
    }

    public static <K> HashSet<K> newHashSet() {return new HashSet<K>(); }

    public static void main(String[] args) {
        Map<String, List<String>> dataStrMap = newHashMap();

        Set<String> dataStrSet = newHashSet();


    }
}
