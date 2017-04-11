package leetcode;

/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

int longestValidParentheses(string s) {
        int prev = -1,depth = 0,result = 0;
        stack<int> dstack;
        for(int i=0;i<s.size();i++){
            if(s[i] == '('){
                dstack.push(i);
            }else{
                if(dstack.empty()){
                    prev = i;
                }else{
                    dstack.pop();
                    if(dstack.empty()){
                        result = max(result,i-prev);
                    }else{
                        result = max(result,i-dstack.top());
                    }
                }
            }
        }

        return result;


    }

 */
public class LongestValidParentheses {
}
