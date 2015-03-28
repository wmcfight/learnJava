package learnJava;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wmc on 2014/10/19.
 */
public class Test{
    private String a;
    private String b;

    public Test(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("A=").append(a)
                    .append("B=").append(b);
        return stringBuilder.toString();
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public static void main(String[] args) {
        List<Test> tests = new ArrayList<Test>(){{add(new Test("1"));add(new Test("2"));}};

        for (Test test : tests) {
            test.setB("11");
        }

        for (Test test : tests) {
            System.out.println(test.toString());
        }
    }
}
