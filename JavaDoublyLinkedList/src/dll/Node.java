package dll;

class Node {
	Object obj;
	Node next;
	Node prev;
	
	Node(Object obj, Node next, Node prev) {
		this.obj = obj;
		this.next = next;
		this.prev = prev;
	}
}
