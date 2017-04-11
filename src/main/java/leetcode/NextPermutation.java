package leetcode;

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        if(num.length <= 1) return;
        int i,j = 0,k;
        boolean find = false;
        for(i=num.length-2;i>=0;i--){
            if(num[i] < num[i+1]){
                j = i+1;
                find = true;
                break;
            }
        }

        if(!find){
            reverse(num,0,num.length-1);
        }else{
            for(k = num.length-1;k>=0;k--)
            {
                if(num[i] < num[k]){
                    break;
                }
            }
            int temp = num[i];
            num[i] = num[k];
            num[k] =temp;
            reverse(num,j,num.length-1);
        }

    }

    public void reverse(int[] num,int left,int right){
        while(left < right){
            int temp = num[left];
            num[left] = num[right];
            num[right] =temp;
            left++;
            right--;
        }
    }
}
