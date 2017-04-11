package leetcode;

/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

string countAndSay(int n) {
        if(n==0) return "1";
        string result = "1";
        int sum = 1;
        while(sum < n){
            result = helper(result);
            sum++;
        }
        return result;
    }

    private:
    string helper(string s){
        int prev = 0,cur = 0;
        stringstream temp;
        for(int i=0;i!=s.size();++i){
            if(cur == s[i]-'0'){
            	prev++;
            }else{
            	if(cur != 0){
            		temp<<prev<<cur;
            	}
            	cur = s[i] - '0';
            	prev = 1;
            }
        }
        if(cur>0)
        	temp<<prev<<cur;
        return temp.str();
    }
 */
public class CountandSay {
}
