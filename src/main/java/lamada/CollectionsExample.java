package lamada;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.Getter;

public class CollectionsExample {

    @Builder
    @Getter
    static class Artist {
        Long value;
        String name;
    }

    public static void main(String[] args) {
        //数据过滤， 可以直接用linkedHashSet，或者用distinct
        Integer[] datas = {1,2,2,3,3,5, 4,6,6,7};
        Arrays.stream(datas).distinct().parallel().collect(Collectors.toList()).forEach(item -> System.out.print(item + " "));
        Arrays.stream(datas).distinct().collect(Collectors.toList()).forEach(item -> System.out.print(item + " "));
        Arrays.stream(datas).collect(Collectors.toCollection(LinkedHashSet::new)).forEach(item -> System.out.print(item + " "));

        System.out.println();
        Artist[] artists = {
            Artist.builder().name("1").value(1l).build(),
            Artist.builder().name("7").value(7l).build(),
            Artist.builder().name("9").value(9l).build(),
            Artist.builder().name("2").value(2l).build(),
        };

        Artist item = Arrays.stream(artists).max(Comparator.comparing(artist -> artist.getValue())).get();
        System.out.println(item.getName());

        item  = Arrays.stream(artists).collect(Collectors.maxBy(
                Comparator.comparing(data -> data.getValue()))).get();
        System.out.println(item.getName());
        System.out.println(Arrays.stream(artists).collect(Collectors.averagingDouble(data -> data.getValue())));

        Arrays.stream(artists).collect(Collectors.partitioningBy(data -> data.getValue() > 4));

        System.out.println(Arrays.stream(artists).map(Artist::getName).collect(Collectors.joining(",","[","]")));



    }
}
