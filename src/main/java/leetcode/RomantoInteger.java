package leetcode;
/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomantoInteger {
        public int romanToInt(String s) {
            int result = 0;
            for(int i=0;i<s.length();i++){
                if(i>0 && map(s.charAt(i)) > map(s.charAt(i-1)) ){
                    result += map(s.charAt(i)) - map(s.charAt(i-1)) * 2;
                }else{
                    result += map(s.charAt(i));
                }
            }
            return result;
        }

        private int map(char c){
            switch(c){
                case 'I': return 1;
                case 'V': return 5;
                case 'X': return 10;
                case 'L': return 50;
                case 'C': return 100;
                case 'D': return 500;
                case 'M': return 1000;
                default: return 0;
            }
        }
}
