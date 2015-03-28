package lockFree;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by wmc on 2015/2/4.
 */
public class LockFreeStack<E> {

    AtomicReference<Node<E>> head = new AtomicReference<Node<E>>();

    public void push(E data) {
        Node<E> newHead = new Node<E>(data);
        Node<E> oldHead;
        do {
            oldHead = head.get();
            newHead.next = oldHead;
        } while (!head.compareAndSet(oldHead, newHead));
    }

    public E pop() {
        Node<E> oldHead, newHead;
        do {
            oldHead = head.get();
            if (oldHead == null) {
                return null;
            }
            newHead = oldHead.next;
        } while (!head.compareAndSet(oldHead,newHead));
        return oldHead.item;
    }

    class Node<E> {
        E item;
        Node next;
        public Node(E data) {
            this.item = data;
        }
    }
}
