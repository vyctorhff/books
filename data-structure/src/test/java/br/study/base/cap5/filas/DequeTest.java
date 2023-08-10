/*
 * Created on 16/03/2011, 15:48:00
 * Locate at Natal, Rio Grande do Norte
 *
 * DequeTest.java
 *
 * @autor torugo
 */
package br.study.base.cap5.filas;


import br.study.base.cap5.filas.Deque;
import br.study.base.cap5.filas.DequeImp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DequeTest {

    @Test
    public void testSize() {
        Deque<Double> deque = new DequeImp<Double>();

        assertEquals(0, deque.size());

        deque.addFirst(3.0);
        assertEquals(1, deque.size());

        deque.addFirst(5.0);
        assertEquals(2, deque.size());

        deque.addFirst(4.0);
        assertEquals(3, deque.size());

        deque.removeFirst();
        assertEquals(2, deque.size());
    }

    @Test
    public void testIsEmpty() {
        Deque<Double> deque = new DequeImp<Double>();
        assertTrue(deque.isEmpty());

        deque.addFirst(3.3);
        assertFalse(deque.isEmpty());

        deque.removeFirst();
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testGetFirst() {
        Deque<Double> deque = new DequeImp<Double>();

        deque.addFirst(2.4);
        assertEquals(2.4, deque.getFirst(), 0.1);

        deque.addFirst(7.4);
        assertEquals(7.4, deque.getFirst(), 0.1);

        deque.addFirst(9.4);
        assertEquals(9.4, deque.getFirst(), 0.1);
    }

    @Test
    public void testGetLast() {
        Deque<Double> deque = new DequeImp<Double>();

        deque.addLast(2.4);
        assertEquals(2.4, deque.getLast(), 0.1);

        deque.addLast(7.4);
        assertEquals(7.4, deque.getLast(), 0.1);

        deque.addLast(9.4);
        assertEquals(9.4, deque.getLast(), 0.1);
    }

    @Test
    public void testAddFirst() {
        Deque<Double> deque = new DequeImp<Double>();

        deque.addFirst(2.4);
        deque.addFirst(3.5);
        deque.addFirst(5.5);
    }

    @Test
    public void testAddLast() {
        Deque<Double> deque = new DequeImp<Double>();
        deque.addLast(2.4);
    }

    @Test
    public void testRemoveFirst() {
        Deque<Double> deque = new DequeImp<Double>();

        deque.addFirst(2.4);
        deque.addFirst(3.5);
        deque.addFirst(5.5);

        assertEquals(5.5, deque.removeFirst(), 0.1);
        assertEquals(3.5, deque.removeFirst(), 0.1);
        assertEquals(2.4, deque.removeFirst(), 0.1);

        deque.addFirst(8.4);
        assertEquals(8.4, deque.removeFirst(), 0.1);
    }

    @Test
    public void testRemoveLast() {
        Deque<Double> deque = new DequeImp<Double>();

        deque.addLast(3.5);
        deque.addLast(5.5);
        deque.addLast(2.4);

        double x = deque.removeLast();
        assertEquals(2.4, x, 0.1);
        assertEquals(5.5, deque.removeLast(), 0.1);
        assertEquals(3.5, deque.removeLast(), 0.1);

        deque.addLast(8.4);
        assertEquals(8.4, deque.removeLast(), 0.1);
    }
}
