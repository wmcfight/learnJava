package leetcode;

/*
Given n pairs of parentheses, write a function to
generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

vector<string> generateParenthesis(int n) {
        vector<string>result;
        string data;
        getSubParentheses(result,data,0,0,n);
        return result;
    }

    void getSubParentheses(vector<string>&result,string &data,int left,int right,int n){
        if(left == n && right == n){
            result.push_back(data);
            return;
        }
        //if(left > n || right > n) return;

        if(left < n){
            data.push_back('(');
            getSubParentheses(result,data,left+1,right,n);
            data.erase(data.size()-1);
        }

        if(right<left){
            data.push_back(')');
            getSubParentheses(result,data,left,right+1,n);
            data.erase(data.size()-1);
        }
    }

 */
public class GenerateParentheses {
}
