package leetcode;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Subscribe to see which companies asked this question.

 bool isValid(string s) {
        string left = "{[(";
        string right = "}])";
        stack<char> cstack;
        for(int i=0;i!=s.size();++i){
            if(left.find(s[i]) != string::npos){
                cstack.push(s[i]);
            }else{
                if(cstack.empty() || left[right.find(s[i])] != cstack.top())
                    return false;
                else
                    cstack.pop();
            }
        }

        return cstack.empty();
    }

 */
public class ValidParentheses {
}
