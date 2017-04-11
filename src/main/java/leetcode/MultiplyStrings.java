package leetcode;

/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.


string multiply(string num1, string num2) {
        string result;
        if(num1.size()<=0 || num2.size()<=0) return result;
        result = "";
        if(num1.size()<num2.size()) swap(num1,num2);
        for(int i=0;i<num2.size();i++){
            result = add(result,multiplyNumber(num1,num2.size()-1-i,num2[i]-'0'));
        }
        return result;
    }

    string multiplyNumber(string& num,int move,int number){
        stringstream stream;
        int carry = 0,cur = 0;
        if(number == 0) return "0";
        for(int i=0;i<move;i++){
            stream<<0;
        }
        for(int i=num.size()-1;i>=0;i--){
            cur = number*(num[i]-'0') + carry;
            stream<<(cur%10);
            carry = cur/10;
        }
        if(carry != 0) stream<<carry;
        string result = stream.str();
        reverse(result.begin(),result.end());
        return result;

    }

    string add(string num1, string num2){
        int carry = 0;
        int cur1 = num1.size()-1,cur2 = num2.size()-1, x ,y,sum;
        stringstream stream;
        while(cur1>=0 || cur2 >=0){
            x = cur1>=0 ? num1[cur1] - '0' : 0;
            y = cur2>=0 ? num2[cur2] - '0' : 0;
            cur1 = cur1>=0 ? cur1-1 : cur1;
            cur2 = cur2>=0 ? cur2-1 : cur2;
            sum = x + y + carry;
            stream<<(sum%10);
            carry = sum/10;
        }
        if(carry!=0) stream<<carry;
        string result = stream.str();
        reverse(result.begin(),result.end());
        return result;
    }

 */
public class MultiplyStrings {
}
