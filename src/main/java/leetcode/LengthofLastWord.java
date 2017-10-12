package leetcode;

/**
Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example,
Given s = "Hello World",
return 5.
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        int result = 0, temp = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                if(temp !=0){
                    result = temp;
                }

                temp = 0;
            }else{
                temp++;
            }
        }
        return temp == 0? result : temp;

    }
}
