package LLD.DesignPatterns.Iterator;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();

		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);

		for (int val : list) {
			System.out.print(val + " -> ");
		}
		System.out.println(".");

		// the above code is syntactical sugar for the following code.

		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " -> ");
		}
		System.out.println(".");
	}

	static class MyLinkedList implements Iterable<Integer> {
		static class Node {
			int data;
			Node next;
		}

		Node head;
		Node tail;
		int size;

		void addLast(int data) {
			Node node = new Node();
			node.data = data;

			if (size == 0) {
				head = tail = node;
			} else {
				tail.next = node;
				tail = node;
			}
			size++;
		}

		int size() {
			return size;
		}

		@Override
		public Iterator<Integer> iterator() {
			return new LinkedListIterator(head);
		}

		static class LinkedListIterator implements Iterator<Integer> {

			Node temp = null;

			LinkedListIterator(Node temp) {
				this.temp = temp;
			}

			@Override
			public boolean hasNext() { // this method tells next value exist or not.
				if (temp != null) {
					return true;
				} else {
					return false;
				}
			}

			@Override
			public Integer next() { // this method return the current value and move to next value.
				int rv = temp.data;
				temp = temp.next;
				return rv;
			}

		}

	}

}
