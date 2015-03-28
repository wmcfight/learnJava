/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learnJava;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Descriptions of the class MyConcurrentStack.java's implementation：TODO
 * described the implementation of class
 * 
 * @author wmc 2014年1月12日 下午8:48:31
 * @param <E>
 */
public class MyConcurrentStack<E> {
	// AtomicReference<Node<E>> top = new AtomicReference<Node<E>>();

	AtomicReference<Node<E>> top = new AtomicReference<MyConcurrentStack.Node<E>>();

	public void push(E item) {
		Node<E> newHeadNode = new Node<E>(item);
		Node<E> oldNode;
		do {
			oldNode = top.get();
			newHeadNode.next = oldNode;
		} while (!top.compareAndSet(oldNode, newHeadNode));
	}

	public E pop() {
		Node<E> oldNode;
		Node<E> newNode;
		do {
			oldNode = top.get();
			if (oldNode == null) {
				return null;
			}
			newNode = oldNode.next;
		} while (!top.compareAndSet(oldNode, newNode));
		return oldNode.item;
	}

	private static class Node<E> {
		public final E item;
		public Node<E> next;

		public Node(E item) {
			this.item = item;
		}
	}
}
