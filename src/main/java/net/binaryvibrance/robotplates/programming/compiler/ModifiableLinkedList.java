package net.binaryvibrance.robotplates.programming.compiler;

//Based on http://crunchify.com/how-to-implement-a-linkedlist-class-from-scratch-in-java/
class ModifiableLinkedList<T> {
	// reference to the head node.
	private Node head;
	private int listCount;

	// LinkedList constructor
	public ModifiableLinkedList() {
		// this is an empty list, so the reference to the head node
		// is set to a new node with no data
		head = new Node(null);
		listCount = 0;
	}

	public void add(T data)
	// appends the specified element to the end of this list.
	{
		Node newNode = new Node(data);
		Node current = head;
		// starting at the head node, crawl to the end of the list
		while (current.getNext() != null) {
			current = current.getNext();
		}
		// the last node's "next" reference set to our new node
		current.setNext(newNode);
		listCount++;// increment the number of elements variable
	}

	public void add(T data, int index)
	// inserts the specified element at the specified position in this list
	{
		Node newNode = new Node(data);
		Node current = head;
		// crawl to the requested index or the last element in the list,
		// whichever comes first
		for (int i = 1; i < index && current.getNext() != null; i++) {
			current = current.getNext();
		}
		// set the new node's next-node reference to this node's next-node
		// reference
		newNode.setNext(current.getNext());
		// now set this node's next-node reference to the new node
		current.setNext(newNode);
		listCount++;// increment the number of elements variable
	}

	public T get(int index)
	// returns the element at the specified position in this list.
	{
		// index must be 1 or higher
		if (index <= 0)
			return null;

		Node current = head.getNext();
		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				return null;

			current = current.getNext();
		}
		return current.getData();
	}

	public boolean remove(int index)
	// removes the element at the specified position in this list.
	{
		// if the index is out of range, exit
		if (index < 1 || index > size())
			return false;

		Node current = head;
		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				return false;

			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		listCount--; // decrement the number of elements variable
		return true;
	}

	public int size()
	// returns the number of elements in this list.
	{
		return listCount;
	}

	public String toString() {
		Node current = head.getNext();
		String output = "";
		while (current != null) {
			output += "[" + current.getData().toString() + "]";
			current = current.getNext();
		}
		return output;
	}

	public Node beforeFirstNode() {
		return head;
	}

	public class Node {
		// reference to the next node in the chain,
		// or null if there isn't one.
		Node next;
		// data carried by this node.
		// could be of any type you need.
		T data;

		// Node constructor
		public Node(T dataValue) {
			next = null;
			data = dataValue;
		}

		// another Node constructor if we want to
		// specify the node to point to.
		public Node(T dataValue, Node nextValue) {
			next = nextValue;
			data = dataValue;
		}

		// these methods should be self-explanatory
		public T getData() {
			return data;
		}

		public void setData(T dataValue) {
			data = dataValue;
		}

		public Node getNext() {
			return next;
		}
		public boolean hasNext() { return next != null; }
		private void setNext(Node nextValue) {
			next = nextValue;
		}

		public void addNext(T dataValue) {
			Node newNode = new Node(dataValue);
			newNode.setNext(this.getNext());
			this.setNext(newNode);
			listCount++;
		}

		public void addLast(T dataValue) {
			add(dataValue);
		}
	}
}
