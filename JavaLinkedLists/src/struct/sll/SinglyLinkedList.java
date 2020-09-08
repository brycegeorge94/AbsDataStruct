package struct.sll;

public class SinglyLinkedList {
    private Node head;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(Object data) {
        add(data);
    }

    public void add(Object data) {
        if (head == null) {
            head = new Node(data);
            size++;
        } else {
            Node curr = head;
            while (curr.next != null)
                curr = curr.next;
            curr.next = new Node(data);
            size++;
        }
    }

    public void add(int index, Object data) {
        if (index == 0) {
            Node temp = new Node(data, head);
            head = temp;
        } else {
            Node curr = head;
            for (int i = 0; i < index; i++)
                curr = curr.next;
            Node temp = new Node(data, curr);
            curr = temp;
        }
    }

    public void remove(int index) {

    }

    public void removeData(Object data) {

    }

    public Object get(int index) {
        Node curr = head;
        for (int i = 0; i < index; i++)
            curr = curr.next;
        return curr.data;
    }

    public int getIndex(Object data) {
        Node curr = head;
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (data == curr.data) {
                result = i;
                break;
            }
            curr = curr.next;
        }
        return result;
    }

    public int size() {
        return size;
    }
}
