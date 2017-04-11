package leetcode;

import java.util.ArrayList;
import java.util.Collections;

/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<String> curS = new ArrayList<String>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(n<=0) {
            result.add(0);
        }else{
            curS.add("0");curS.add("1");
            int cur = 1;
            while(cur<n){
                ArrayList<String> prevS = new ArrayList<String>();
                for(int i=0;i<2;i++){
                    if( i == 1) Collections.reverse(curS);
                    for(String item: curS){
                        StringBuffer sBuffer = new StringBuffer(item).reverse();
                        sBuffer.append(i);
                        prevS.add(sBuffer.reverse().toString());
                    }
                }
                curS.clear();
                curS = prevS;
                cur++;
            }

            for(String item:curS){
                result.add(convertStoInt(item));
            }

        }


        return result;
    }

    private int convertStoInt(String data){
        int result = 0;
        for(int i=0;i<data.length();i++){
            result = result*2 + data.charAt(i) - '0';
        }
        return result;
    }
}
