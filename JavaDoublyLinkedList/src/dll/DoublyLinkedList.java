package dll;

public class DoublyLinkedList {
	private Node head; // Node at index 0
	private int size;
	
	public DoublyLinkedList() {}
	
	public DoublyLinkedList(Object obj) {
		addFront(obj);
	}
	
	public void addFront(Object obj) {
		if (head == null) {
			// List is empty, create new node
			head = new Node(obj, null, null);
		} else if (head.next == null) {
			// List only has head, create second node and link list
			Node temp = new Node(obj, head, head);
			head.next = head.prev = temp;
			head = temp;
		} else {
			//make new node, next = head, prev = head.prev
			Node temp = new Node(obj, head, head.prev);
			head.prev.next = temp;
			head.prev = temp;
			head = temp;
		}
		size++;
	}
	
	public void addBack(Object obj) {
		
	}
	
	public void addAt(int index, Object obj) {
		
	}
	
	public boolean remove(Object obj) {
		return false;
	}
	
	public void removeFrom(int index) {
		
	}
	
	public Object getFrom(int index) {
		return null;
	}
	
	public int getIndex(Object obj) {
		return 0;
	}
	
	public boolean contains(Object obj) {
		return false;
	}
	
	public int size() {
		return size;
	}
}
