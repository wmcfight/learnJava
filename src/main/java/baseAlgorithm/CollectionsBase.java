package baseAlgorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 用linkedList 作为Queue，
 * linkedList 本身也可以作为stack
 */
public class CollectionsBase {
    public static void main(String[] args) {
        Queue<Integer> data = new LinkedList<>();
        data.add(1);
        data.poll();
        data.peek();
        data.isEmpty();

        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.peek();
        stack.pop();
        stack.empty();
    }
}
