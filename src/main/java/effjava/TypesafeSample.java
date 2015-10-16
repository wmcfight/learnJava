package effjava;

import com.typesafe.config.ConfigException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mwei on 15-10-8.
 */
public class TypesafeSample {
    private Map<Class<?>, Object> favorites = newHashMap();

    public <K extends Integer> void putFavorite(Class<K> type, K instance) {
        if (type == null) {
            throw new NullPointerException("Type is null");
        }
        favorites.put(type, instance);
    }

    public <K extends Integer> K getFavorite(Class<K> type) {
        return type.cast(favorites.get(type));
    }

    private static <K,V> Map<K,V> newHashMap() {
        return new HashMap<K, V>();
    }

    public static void main(String[] args) {
        TypesafeSample typesafeSample = new TypesafeSample();
        typesafeSample.putFavorite(Integer.class, 1);
        System.out.println(typesafeSample.getFavorite(Integer.class));
    }
}
