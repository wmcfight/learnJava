package leetcode;

/*
Given a digit string, return all possible letter combinations that the number could represent.
const vector<string> keyboard { " ", "", "abc", "def", // '0','1','2',...
"ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    vector<string> letterCombinations(string digits) {
        vector<string> result;
        string data;
        getSubString(result,data,0,digits);
        return result;
    }

    void getSubString(vector<string>&result,string&data,int clen,string& digits){
        if(clen == digits.size()){
            result.push_back(data);
            return;
        }
        string curstring = keyboard[digits[clen]-'0'];
        for(int j=0;j<curstring.size();++j){
            data.push_back(curstring[j]);
            getSubString(result,data,clen+1,digits);
            data.pop_back();
        }

    }
 */
public class LetterCombinationsofaPhoneNumber {
}
