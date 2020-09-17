package dll;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
	private Node head; // Node at index 0
	private int size;
	
	public DoublyLinkedList() {}
	
	public DoublyLinkedList(Object obj) {
		prepend(obj);
	}
	
	public void prepend(Object obj) {
		if (head == null) {
			// List is empty, create new node
			head = new Node(obj, null, null);	
		}
		
		else if (head.next == null) {
			// List only has head, create second node and interlink
			Node temp = new Node(obj, head, head);
			head.next = head.prev = temp;
			head = temp;
			}
		
		else {
			// List has multiple links, insert new node using links of head
			Node temp = new Node(obj, head, head.prev);
			head.prev.next = temp;
			head.prev = temp;
			head = temp;
		}
		
		size++;
	}
	
	public void append(Object obj) {
		// Identical implementation of prepend, just without moving head
		if (head == null)
			head = new Node(obj, null, null);
		
		else if (head.prev == null ) {
			Node temp = new Node (obj, head, head);
			head.next = head.prev = temp;	
		}
		
		else {
			Node temp = new Node(obj, head, head.prev);
			head.prev.next = temp;
			head.prev = temp;
		}
		
		size++;
	}
	
	public void addAt(int index, Object obj) {
		if (index != 0)
			verifyNotEmpty();
		
	}
	
	public boolean remove(Object obj) {
		Node curr = head;
		Node toDelete = null;
		
		// Find the note toDelete by Object
		for (int i = 0; i < size; i++) {
			if (curr.obj == obj)
				toDelete = curr;
			curr = curr.next;
		}
		
		// If not found, return false
		if (toDelete == null)
			return false;
		
		deleteNode(toDelete);

		return true;
	}
	
	public void removeFrom(int index) {
		verifyNotEmpty();
		int parsedIndex = parseIndex(index);
		
		// Find the node toDelete by index
		Node toDelete = head;
		for (int i = 0; i < parsedIndex; i++)
			toDelete = toDelete.next;
		
		deleteNode(toDelete);
	}
	
	public Object getFrom(int index) {
		verifyNotEmpty();
		int parsedIndex = parseIndex(index);
		
		if (parsedIndex == 0)
			return head.obj;
		
		Node curr = head;
		
		if (parsedIndex <= size/2)	// If in front half of list
			for (int i = 0; i < parsedIndex; i++)
				curr = curr.next;
		else						// If in rear half of list
			for (int i = size; i > parsedIndex; i--)
				curr = curr.prev;
		
		return curr.obj;
	}
	
	public int getIndex(Object obj) {
		Node curr = head;
		int index = -1;
		
		for (int i = 0; i < size; i++) {
			if (curr.obj == obj) {
				index = i;
				break;
			}
			curr = curr.next;
		}
		return index;
	}
	
	public boolean contains(Object obj) {
		return false;
	}
	
	public int size() {
		return size;
	}
	
	/* Allows use of given indices out of range, as the LinkedList loops anyway
	* For example, if list is of size 10, an index of 15 will retrieve index 5
	* Also allows negatives, for size 10, -3 will retrieve item at index 7 */
	private int parseIndex(int index) {
		boolean negative = index < 0;
		int temp = Math.abs(index);
		
		while(temp > size)
			temp -= size;
		
		if (negative)
			temp = size - temp;
		
		return temp;
	}
	
	private void verifyNotEmpty() throws NoSuchElementException {
		if (size == 0)
			throw new NoSuchElementException("Cannot perform operation on empty DoublyLinkedList");
	}
	
	private void deleteNode(Node toDelete) {
		boolean isHead = toDelete == head;
		
		// If size is one, toDelete is head, and no other nodes exist.
		if (size == 1)
			head = null;
		
		// If size is two, we'll be left with one element.
		// Move to next node head if toDelete is head.
		else if (size == 2) {
			if (isHead)
				head = head.next;
			head.next = head.prev = null;
		}
		
		// If here, size is greater than 2
		// Can use Next and Prev nodes of toDelete as they will not be null
		else {
			if (isHead)
				head = head.next;
			toDelete.prev.next = toDelete.next;
			toDelete.next.prev = toDelete.prev;
		}
		
		size--;
	}
}
