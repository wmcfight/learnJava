package baseAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wmc on 2015/2/11.
 * 最基本的堆实现
 */

public class Heap {
    private List<Integer> heapData = new ArrayList<Integer>();
    private int len = 0;

    public void insert(Integer data) {
        Integer temp = data;
        int i = len ;
        while (i !=0 ) {
            int j = (i - 1) /2;
            if (temp >= heapData.get(j)) break;
            heapData.set(i,heapData.get(j));
            i = j;
        }
        heapData.set(i,temp);
        len++;
    }

    Integer getHead() throws Exception {
        if (len <= 0) throw new Exception("No data");
        Integer temp = heapData.get(0);
        Integer last = heapData.get(len-1);
        len--;
        if (len <= 0) return temp;
        int i = 0 , j = 2 * i + 1;
        while (j <= len - 1) {
            if (j < len - 1 && heapData.get(j) > heapData.get(j+1)) j++;
            if (last <= heapData.get(j)) break;
            heapData.set(i, heapData.get(j));
            i = j;
            j = 2 * i + 1;
        }
        heapData.set(i,last);
        return temp;
    }

    void shirtHeap(int n, int i) {
        Integer temp = heapData.get(i);

    }

}
