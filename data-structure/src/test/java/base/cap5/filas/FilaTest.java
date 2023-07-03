/*
 * Created on 16/03/2011, 14:30:52
 * Locate at Natal, Rio Grande do Norte
 *
 * FilaTest.java
 *
 * @autor torugo
 */
package base.cap5.filas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilaTest {

    private Fila<Integer> fila;

    @BeforeEach
    public void setup() {
        fila = new FilaImp<>();
    }

    @Test
    public void testSize() {
        assertEquals(0, fila.size());

        fila.enqueue(1);
        assertEquals(1, fila.size());

        fila.enqueue(2);
        assertEquals(2, fila.size());

        fila.enqueue(3);
        assertEquals(3, fila.size());

        fila.enqueue(4);
        assertEquals(4, fila.size());

        fila.dequeue();
        assertEquals(3, fila.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(fila.isEmpty());

        fila.enqueue(1);
        assertFalse(fila.isEmpty());

        fila.dequeue();
        assertTrue(fila.isEmpty());
    }

    @Test
    public void testFront() {
        fila.enqueue(2);
        int numero = fila.front();

        assertEquals(2, numero);

        fila.enqueue(3);
        fila.enqueue(4);
        fila.enqueue(5);

        numero = fila.front();
        assertEquals(2, numero);
    }

    @Test
    public void testFrontFilaVazia() {
        assertThrows(IllegalStateException.class, () -> new FilaImp<>().front());
    }

    @Test
    public void testEnqueue() {
        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);
        fila.enqueue(4);
        fila.enqueue(5);

        assertEquals(5, fila.size());

        fila.dequeue();
        fila.dequeue();
        fila.dequeue();
        fila.dequeue();
        fila.dequeue();

        assertEquals(0, fila.size());
        assertTrue(fila.isEmpty());

        fila.enqueue(10);
        fila.enqueue(11);
        fila.enqueue(12);

        assertEquals(3, fila.size());
    }

    @Test
    public void testDequeue() {
        fila.enqueue(2);

        int numero = fila.dequeue();
        assertEquals(2, numero);
        assertTrue(fila.isEmpty());

        fila.enqueue(10);
        fila.enqueue(11);

        numero = fila.dequeue();
        assertEquals(10, numero);

        numero = fila.dequeue();
        assertEquals(11, numero);

        try {
            fila.dequeue(); // fila vazia.
            fail();
        } catch (IllegalStateException e) {
        }
    }

    @Test
    public void testDequeueFilaVazia() {
        assertThrows(IllegalStateException.class, () -> {
            new FilaImp<>().dequeue();
        });
    }
}
