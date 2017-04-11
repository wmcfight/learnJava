package leetcode;

/*
int divide(int dividend, int divisor) {
        long long  result = 0;
        long long iter = 1;
        int symbol = (dividend>=0 && divisor>=0) || (dividend < 0 && divisor<0) ? 1 : -1;
        if(divisor == 0) return 0;
        long long ndividend = dividend>=0 ? dividend : -(long long)dividend;
        long long ndivisor = divisor>=0 ? divisor : -(long long)divisor;
        while(ndividend>=ndivisor || iter>1){
            if(ndividend>=ndivisor){
                ndividend -= ndivisor;
                result += iter;
                ndivisor *= 2;
                iter *= 2;
            }else{
                ndivisor /=2;
                iter /=2;
            }
        }

        return (int)(result*symbol);

    }
 */
public class DivideTwoIntegers {
}
