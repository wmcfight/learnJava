package interview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Pylo {


    public static void main(String[] args2) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> data= new ArrayList<>();
        String input;
        while ((input = br.readLine()) != null ) {
            if (input.split(" ").length != 4) {
                break;
            }
            data.add(input);
        }
        solution(data);
    }

    private static void solution(List<String> args) {
        if (args == null || args.size() <= 0) {
            return;
        }
        int[] result = new int[3];
        for (int i = 0; i < args.size(); i++) {
            String line = args.get(i);
            String[] data = line.split(" ");
            if (data.length != 4) {
                result[2]++;
                continue;
            }
            int A = Integer.valueOf(data[0]);
            int B = Integer.valueOf(data[1]);
            int C = Integer.valueOf(data[2]);
            int D = Integer.valueOf(data[3]);

            if (A < 0 || B < 0 || C < 0 || D < 0) {
                result[2]++;
                continue;
            }
            if (A == B && B == C && C == D) {
                result[0]++;
                continue;
            }
            if (A == C && B == D) {
                result[1]++;
                continue;
            }
            result[2]++;
            continue;
        }
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }


}
