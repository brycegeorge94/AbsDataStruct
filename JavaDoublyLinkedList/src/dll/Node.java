package dll;

public class Node {
	Object obj;
	Node next;
	Node prev;
	
	public Node(Object obj, Node next, Node prev) {
		this.obj = obj;
		this.next = next;
		this.prev = prev;
	}
}
