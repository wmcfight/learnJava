package effjava;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by mwei on 15-10-8.
 */
public enum  EnumSetSample {
    V1(1),
    V2(2),
    V3(4);
    private int value;

    EnumSetSample(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        Set<EnumSetSample> data = EnumSet.allOf(EnumSetSample.class);

        for (EnumSetSample sample : data) {
            System.out.println(sample.getValue());
        }

    }
}
