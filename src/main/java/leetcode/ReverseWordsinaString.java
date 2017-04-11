package leetcode;

/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".


public:
    void reverseWords(string &s) {
        int left = -1,right =-1,rleft = -1,rright = -1;
        for(int i=0;i<s.size();i++){
            if(s[i] != ' '){
                if(left<0){
                    left = i;
                }
                if(rleft<0) rleft = i;
                rright = i;
                right = i;
            }else{
                if(left>=0){
                    revserseString(s,left,right);
                    //printf("result is %s\n",s.c_str());
                }
                left = -1;
            }
        }
        if(left >=0){

            revserseString(s,left,right);
            //printf("result is %s\n",s.c_str());
        }
        if(rleft>=0){
            revserseString(s,rleft,rright);
            //printf("result is %s\n",s.c_str());
            s = s.substr(rleft,rright-rleft+1);
        }else{
            s = "";
        }

        //clear more empty symbol
        int index = 0,len=0;
        for(int i=0;i<s.size();i++){
            if(s[i] != ' '){
                s[index++] = s[i];
                len = 0;
            }else if((++len)<=1){
                s[index++] = s[i];
            }
        }
        s = s.substr(0,index);

        //printf("result is %s\n",s.c_str());
    }

    void revserseString(string& data,int left,int right){
        while(left<right){
            swap(data[left],data[right]);
            left++;
            right--;
        }
    }

 */
public class ReverseWordsinaString {

}
