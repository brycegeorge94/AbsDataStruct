package struct.sll;

/**
 * <h3>Singly Linked List Implementation</h3> This class is a simple
 * implementation of a Singly Linked List, with error handling by thrown
 * exceptions.
 * 
 * @author Bryce George
 * @since 10-09-2020
 */
public class SinglyLinkedList {
    private Node head;
    private int size = 0;

    public SinglyLinkedList() {
    }

    /**
     * Constructor to create a new list with an Object already added.
     * 
     * @param data The Object to add to initialize the list with.
     */
    public SinglyLinkedList(Object data) {
        add(data);
    }

    /**
     * Adds an Object to the end of the list
     * 
     * @param data The Object to be added
     */
    public void add(Object data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node curr = head;
            while (curr.next != null)
                curr = curr.next;
            curr.next = new Node(data);
        }
        size++;
    }

    /**
     * Adds an object at a specific index in the list, moving the other objects
     * along the list by one position
     * 
     * @param index The index to add the Object at
     * @param data  The Object to be added
     */
    public void add(int index, Object data) {
        verifyIndexInRange(index);

        if (index == 0) {
            Node temp = new Node(data, head);
            head = temp;
        } else {
            Node prev = head;
            Node curr = head.next;
            for (int i = 1; i < index; i++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = new Node(data, curr);
        }
        size++;
    }

    /**
     * Removes an element from the list at the specified index. The following
     * elements will be shifted towards the front of the list by one position.
     * 
     * @param index The index to be removed
     */
    public void remove(int index) {
        verifyNotEmpty();
        verifyIndexInRange(index);

        if (index == 0) {
            head = head.next;
        } else {
            Node prev = head;
            Node curr = head.next;
            for (int i = 1; i < index; i++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
        }
        size--;
    }

    /**
     * Removes the first matching Object from the list, if it exists.
     * 
     * @param data The Object to be removed.
     * @return Returns true if Object is found and removed, otherwise false.
     */
    public boolean removeData(Object data) {
        boolean removed = false;
        if (head.data == data) {
            head = head.next;
            removed = true;
        } else {
            Node curr = head.next;
            Node prev = head;
            boolean found = false;
            for (int i = 1; i < size; i++) {
                if (curr.data == data) {
                    found = true;
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
            if (found) {
                prev.next = curr.next;
                removed = true;
            }
        }
        if (removed)
            size--;
        return removed;
    }

    /**
     * Returns an Object at a particular index.
     * 
     * @param index The index of the Object to be returned.
     * @return The Object at the given index.
     */
    public Object get(int index) {
        verifyNotEmpty();
        verifyIndexInRange(index);

        Node curr = head;
        for (int i = 0; i < index; i++)
            curr = curr.next;
        return curr.data;
    }

    /**
     * Returns the index of a given Object if found.
     * 
     * @param data The Object to be found.
     * @return The index of the Object if found, otherwise -1.
     */
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

    /**
     * Sets the data of an existing element in the list at the passed index.
     * 
     * @param index The index of the element to set.
     * @param data  The Object to set.
     */
    public void set(int index, Object data) {
        verifyNotEmpty();
        verifyIndexInRange(index);

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.data = data;
    }

    /**
     * Checks in an Object exists in the list.
     * 
     * @param data The Object to be found.
     * @return Returns true if Object exists in list, otherwise false.
     */
    public boolean contains(Object data) {
        Node curr = head;
        boolean found = false;
        while (curr != null && found == false) {
            if (curr.data == data)
                found = true;
            curr = curr.next;
        }
        return found;
    }

    /**
     * Gets the size of the list.
     * 
     * @return Size of the list.
     */
    public int size() {
        return size;
    }

    /**
     * Verifies the list is not empty. Required for certain functions.
     * 
     * @throws IndexOutOfBoundsException When list is empty.
     */
    private void verifyNotEmpty() throws IndexOutOfBoundsException {
        if (size == 0)
            throw new IndexOutOfBoundsException("Cannot run operation on empty LinkedList");
    }

    /**
     * Verifies the index is in range.
     * 
     * @param index The index to verify.
     * @throws IndexOutOfBoundsException When index is less than 0 or larger than
     *                                   list size.
     */
    private void verifyIndexInRange(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index must be within size of Linked List");
    }
}
