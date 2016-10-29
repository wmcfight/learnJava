package lamada;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LearnStream {
    public static int addData(List<Integer> data) {
        return data.stream().reduce(0, Integer::sum).intValue();
        //return data.stream().reduce(0, (result, cur) -> result + cur);
    }

    public static int getLowLetterNum(String data) {
        return (int) data.chars().filter(Character::isLowerCase).count();
    }

    public static Optional<String> getMaxLowLetterString(List<String> data) {
        return data.stream().max(Comparator.comparing(LearnStream::getLowLetterNum));
    }

    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1, 2, 3);
        System.out.println(LearnStream.addData(data));

        List<String> dataStr = Arrays.asList("awerwsdsDDW", "12132Ddffe", "rwerAAA");
        dataStr.forEach(item -> {
            System.out.println(item + " " + LearnStream.getLowLetterNum(item));
        });
        System.out.println(LearnStream.getMaxLowLetterString(dataStr).orElse(""));
    }



}
