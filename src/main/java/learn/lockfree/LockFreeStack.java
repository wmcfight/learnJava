package learn.lockfree;

/**
 * Created by wmc on 2015/2/2.
 */
public class LockFreeStack<E> {

    class Node<E> {
        E data;
        Node<E> next;
        public Node(E item) {
            this.data = item;
        }
    }
}
