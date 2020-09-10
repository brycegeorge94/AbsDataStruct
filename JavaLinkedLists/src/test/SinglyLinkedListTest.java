package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import struct.sll.SinglyLinkedList;

public class SinglyLinkedListTest {

    @Test
    public void addAndGetDataTest() {
        SinglyLinkedList sll = new SinglyLinkedList();
        int i = 1;
        sll.add(i);
        assertEquals(i, sll.get(0), "Value i should match");
        assertEquals(1, sll.size(), "Size should be one");
    }

    @Test
    public void addAndGetMultiTest() {
        SinglyLinkedList sll = new SinglyLinkedList();
        int i = 1;
        int j = 2;
        int k = 3;
        sll.add(i);
        sll.add(j);
        sll.add(k);
        assertEquals(i, sll.get(0), "Value i should match");
        assertEquals(j, sll.get(1), "Value j should match");
        assertEquals(k, sll.get(2), "Value k should match");
        assertEquals(3, sll.size(), "Size should be three");
    }

    @Test
    public void addIndexTest() {
        SinglyLinkedList sll = new SinglyLinkedList();
        int i = 1;
        int j = 2;
        int k = 3;
        sll.add(i);
        sll.add(j);
        sll.add(1, k);
        assertEquals(true, sll.contains(k), "List should contain k");
        assertEquals(2, sll.getIndex(j), "Element j should be at position two");
        assertEquals(3, sll.size(), "Size should equal three");
    }

    @Test
    public void addIndexEndTest() {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(1);
        sll.add(2);
        sll.add(2, 3);
        assertEquals(3, sll.size(), "Element should be added to list");
        assertEquals(3, sll.get(2), "Element at position two should be shree");
    }

    @Test
    public void getIndexTest() {
        SinglyLinkedList sll = new SinglyLinkedList();
        int i = 1;
        sll.add(i);
        assertEquals(0, sll.getIndex(i), "Index should equal 0");
    }

    @Test
    public void removeIndexTest() {
        SinglyLinkedList sll = new SinglyLinkedList();
        int i = 1;
        int j = 2;
        int k = 3;
        sll.add(i);
        sll.add(j);
        sll.add(k);
        sll.remove(1);
        assertEquals(i, sll.get(0), "First element should still be in place");
        assertEquals(k, sll.get(1), "Third element should now be at second index");
        assertEquals(2, sll.size(), "Size should be two");
    }

    @Test
    public void removeDataTest() {
        SinglyLinkedList sll = new SinglyLinkedList();
        int i = 1;
        int j = 2;
        int k = 3;
        sll.add(i);
        sll.add(j);
        sll.add(k);
        assertEquals(true, sll.removeData(k), "Method should return true - element removed");
        assertEquals(false, sll.removeData(k), "Method should return false - already removed");
        assertEquals(2, sll.size(), "Size should be two");
        assertEquals(-1, sll.getIndex(k), "Element should not be in list");
    }

    @Test
    public void containsTest() {
        SinglyLinkedList sll = new SinglyLinkedList();
        int i = 22;
        int j = 33;
        int k = 44;
        sll.add(i);
        sll.add(j);
        sll.add(k);
        assertEquals(true, sll.contains(i), "List should contain i");
        assertEquals(true, sll.contains(j), "List should contain j");
        assertEquals(false, sll.contains(55), "List should not contain 55");
    }

    @Test
    public void sizeTest() {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(1);
        sll.add(2);
        sll.add(0, 3);
        sll.add(4);
        sll.add(2, 5);
        assertEquals(5, sll.size(), "Size should be five");
        sll.add(6);
        sll.remove(3);
        sll.removeData(5);
        assertEquals(4, sll.size(), "Size should be four");
    }

    @Test
    public void setTest() {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(1);
        sll.add(2);
        int i = 10;
        int j = 20;
        sll.set(0, i);
        sll.set(1, j);
        assertEquals(i, sll.get(0), "Object at index zero should be replaced to i");
        assertEquals(j, sll.get(1), "Object at index zero should be replaced to j");
    }

    @Test
    public void addExceptionTest() {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(1);
        sll.add(2);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            sll.add(-1, 1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            sll.add(3, 1);
        });
    }

    @Test
    public void emptyListTest() {
        SinglyLinkedList sll = new SinglyLinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            sll.get(0);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            sll.set(0, 1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            sll.remove(0);
        });
    }
}
