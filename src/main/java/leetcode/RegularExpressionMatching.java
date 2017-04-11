package leetcode;
/*
Implement regular expression matching with support for '.' and '*'.

bool isMatch(const char *s, const char *p) {
        while(*p!='\0'){
            if(*(p+1) != '*'){
                if(*s == *p || (*p =='.' && *s!='\0')){
                    s++;p++;
                }else{
                    return false;
                }
            }else{
                while(*s == *p || (*p =='.' && *s!='\0')){
                    if(isMatch(s,p+2)) return true;
                    s++;
                }

                return isMatch(s,p+2);
            }
        }
        if(*p == '\0') return *s == '\0';
    }

 */

public class RegularExpressionMatching {
}
