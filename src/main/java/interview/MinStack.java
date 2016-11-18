package interview;

import java.util.Stack;

//provide a stack with a API provide a min data
public class MinStack {
    private Stack<Long> dataStack = new Stack<>();
    private Stack<Long> minStack = new Stack<>();

    public Long pop() {
        if (dataStack.empty()) {
            return null;
        }
        Long item = dataStack.pop();
        // Notice!!!
        if (!minStack.empty() && item == minStack.peek()) {
            minStack.pop();
        }

        return item;
    }


    public void push(Long item) {
        if (item == null) {
            return;
        }
        dataStack.push(item);
        if (minStack.empty()) {
            minStack.push(item);
        } else {
            if (item <= minStack.peek()) {
                minStack.push(item);
            }
        }
    }

    public Long getMin() {
        return minStack.empty() ? null : minStack.peek();
    }

    public static void main(String[] args) {
        MinStack sample = new MinStack();
        sample.push(1l);
        sample.push(2l);
        sample.push(3l);
        System.out.println(sample.getMin());
        sample.pop();
        sample.push(1l);
        sample.push(4l);
        sample.push(7l);
        sample.push(0l);
        System.out.println(sample.getMin());
        sample.pop();
        System.out.println(sample.getMin());
        sample.pop();
        System.out.println(sample.getMin());
        sample.pop();
        System.out.println(sample.getMin());
        sample.pop();
        System.out.println(sample.getMin());
        sample.pop();
        System.out.println(sample.getMin());
        sample.pop();
        System.out.println(sample.getMin());
        sample.pop();
        System.out.println(sample.getMin());
        sample.pop();
        System.out.println(sample.getMin());
    }



}
