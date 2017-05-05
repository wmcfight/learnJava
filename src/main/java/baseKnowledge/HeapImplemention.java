package baseKnowledge;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * java 中堆的实现可以用 PriorityQueue，
 * 但是默认PriorityQueue 是最小堆，即每次poll 得到当前堆最小值
 * 如果要讲PriorityQueue 改造成最大堆，可以传入特定的Comparator

 */
public class HeapImplemention {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(3);

        System.out.println(minHeap.poll());
        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.add(3);

        System.out.println(maxHeap.poll());
    }
}
