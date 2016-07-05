package test;

import com.sun.tools.javac.util.List;
import lombok.Data;

/**
 * Created by mingchuw on 16/6/30.
 */
@Data
public class TestLombok {
    private List<String> data;

    public static void main(String[] args) {
        TestLombok sample = new TestLombok();
        sample.getData().add("1");
        sample.getData().add("2");

        sample.getData().forEach(
                item -> {
                    System.out.println(item);
                }
        );
    }
}
