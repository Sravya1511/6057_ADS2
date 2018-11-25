public class LinkedList<E> {
	private class Node {
		E data;
		Node next;

		Node() {}
		Node(E data) {
			this(data, null);
		}
		Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	private Node head, tail;
	int size;

	public void addAtHead(E data) {

		Node node = new Node();
		node.data = data;
		node.next = head;
		head = node;
		size++;
	}

	public E get(int i) {
		Node node = head;
		for(int k = 0; k<i; k++) {
			node = node.next;
		}
		return node.data;
	}

	public E popAtHead() {
		E data = head.data;
		head = head.next;
		return data;
	}

	public void addAtTail(E data) {
		Node newhead = head;
		while (newhead != null && newhead.next != null) {
			newhead = newhead.next;
		}
		newhead.next = new Node(data);
	}

	public E popAtTail() {
		E data = tail.data;
		Node newhead = head;
		while (newhead.next != tail) {
			newhead = newhead.next;
		}
		newhead.next = null;
		return data;
	}

	public void insertAfter(int index, E data) {
		Node newhead = head;
		for (int i = 0; i < index && newhead != null; i++) {
			newhead = newhead.next;
		}
		Node node = new Node(data, newhead.next);
		newhead.next = node;
	}

	public void removeAfter(int index) {
		Node newhead = head;
		for (int i = 0; i < index && newhead != null; i++) {
			newhead = newhead.next;
		}
		newhead.next = newhead.next.next;
		size--;
	}

	public int size() {
		return size;
	}

	void print() {
		Node newhead = head;
		while (newhead != null) {
			System.out.println(newhead.data);
			newhead = newhead.next;
		}
	}

	// public static void main(String[] args) {
	// 	LinkedList<Integer> l = new LinkedList<>();
	// 	l.addAtHead(1);
	// 	l.addAtHead(2);
	// 	l.addAtHead(3);
	// 	l.addAtTail(65);

	// 	l.print();
	// 	System.out.println("--------");
	// 	// System.out.println(l.popAtHead());
	// 	System.out.println("--------");

	// 	l.print();
	// 	System.out.println("--------");

	// 	// System.out.println(l.popAtTail());
	// 	System.out.println("--------");
	// 	l.print();
	// 	System.out.println("--------");
	// 	// System.out.println(l.popAtTail());
	// 	System.out.println("--------");
	// 	l.print();
	// 	System.out.println("---------");
	// 	l.insertAfter(0, 5);
	// 	l.print();
	// 	l.insertAfter(2, 6);
	// 	l.print();
	// }
}