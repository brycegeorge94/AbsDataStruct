package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import struct.sll.SinglyLinkedList;

public class SinglyLinkedListTests {

    @Test
    public void addAndGet() {
        SinglyLinkedList sll = new SinglyLinkedList();
        int i = 28;
        sll.add(i);
        assertEquals(i, sll.get(0), "Value i should match");
        assertEquals(1, sll.size(), "Size should be one");
    }

    @Test
    public void addAndGetMulti() {
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
    public void getIndex() {
        SinglyLinkedList sll = new SinglyLinkedList();
        int i = 82;
        int j = 91;
        int k = 36;
        sll.add(i);
        sll.add(j);
        sll.add(k);
        assertEquals(0, sll.getIndex(i), "Index should equal 0");
        assertEquals(1, sll.getIndex(j), "Index should equal 1");
        assertEquals(2, sll.getIndex(k), "Index should equal 2");
    }

}
