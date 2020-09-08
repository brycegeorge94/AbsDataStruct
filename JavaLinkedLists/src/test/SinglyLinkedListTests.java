package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import struct.sll.SinglyLinkedList;

public class SinglyLinkedListTests {

    @Test
    public void addAndGetDataTest() {
        SinglyLinkedList sll = new SinglyLinkedList();
        int i = 28;
        sll.add(i);
        assertEquals(i, sll.get(0), "Value i should match");
        assertEquals(1, sll.size(), "Size should be one");
    }

    @Test
    public void addAndGetMultiTest() {
        SinglyLinkedList sll = new SinglyLinkedList();
        int i = 28;
        int j = 91;
        int k = 40;
        sll.add(i);
        sll.add(j);
        sll.add(k);
        assertEquals(i, sll.get(0), "Value i should match");
        assertEquals(j, sll.get(1), "Value j should match");
        assertEquals(k, sll.get(2), "Value k should match");
        assertEquals(3, sll.size(), "Size should be three");
    }

    @Test
    public void getIndexTest() {
        SinglyLinkedList sll = new SinglyLinkedList();
        int i = 82;
        sll.add(i);
        assertEquals(0, sll.getIndex(i), "Index should equal 0");
    }

    @Test
    @Ignore
    public void removeIndexTest() {
        SinglyLinkedList sll = new SinglyLinkedList();
        int i = 69;
        int j = 32;
        int k = 45;
        sll.add(i);
        sll.add(j);
        sll.add(k);
        sll.remove(0);
        assertEquals(k, sll.get(1), "Third element should now be at second index");
        assertEquals(2, sll.size(), "Size should be two");
    }

    @Test
    @Ignore
    public void removeDataTest() {
        SinglyLinkedList sll = new SinglyLinkedList();
        int i = 69;
        int j = 32;
        int k = 45;
        sll.add(i);
        sll.add(j);
        sll.add(k);
        sll.removeData(k);
        assertEquals(2, sll.size(), "Size should be two");
        assertEquals(-1, sll.getIndex(k), "Element should not be in list");
    }
}
