package leetcode;

import java.util.Stack;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {

        Stack<Integer> num = new Stack<Integer>();
        for(String item: tokens){
            if(isNumber(item)){
                num.push(toNumber(item));
            }else{
                int temp1 = num.pop();
                int temp2 = num.pop();
                if(item.equals("+")){
                    num.push(temp1+temp2);
                }else if(item.equals("-")){
                    num.push(temp2 - temp1);
                }else if(item.equals("*")){
                    num.push(temp1*temp2);
                }else{
                    num.push(temp2/temp1);
                }
            }
        }

        return num.pop();
    }

    private boolean isNumber(String data){
        if(data.length()==1 && (data.charAt(0) > '9' || data.charAt(0) < '0')) return false;
        return true;
    }

    private int toNumber(String data){
        int result = 0;
        int symbol = 1;
        if(data.charAt(0) == '-') symbol = -1;
        for(int i=0;i<data.length();i++){
            if(data.charAt(i)<'0' || data.charAt(i) >'9'){
                continue;
            }
            result = result * 10 + data.charAt(i) - '0';
        }
        return result*symbol;
    }
}
