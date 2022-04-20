/*
 * Created on 23/02/2011, 11:56:32
 * Locate at Natal, Rio Grande do Norte
 *
 * PilhaListaTest.java
 *
 * @autor torugo
 */
package base.cap5.pilhas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PilhaListaTest {

    @Test
    public void testPush() {
        Pilha<String> pilha = new PilhaLista<String>();

        assertEquals(0, pilha.size());

        pilha.push("aaa");
        assertEquals(1, pilha.size());

        pilha.push("bbb");
        assertEquals(2, pilha.size());

        pilha.push("ccc");
        assertEquals(3, pilha.size());
    }

    @Test
    public void testPop() {
        Pilha<String> pilha = new PilhaLista<>();

        pilha.push("aaa");
        pilha.push("bbb");
        pilha.push("ccc");

        assertEquals("ccc", pilha.pop());
        assertEquals(2, pilha.size());

        assertEquals("bbb", pilha.pop());
        assertEquals(1, pilha.size());

        assertEquals("aaa", pilha.pop());
        assertEquals(0, pilha.size());
    }

    @Test
    public void testTop() {
        Pilha<String> pilha = new PilhaLista<>();

        pilha.push("aaa");
        assertEquals("aaa", pilha.top());

        pilha.push("bbb");
        assertEquals("bbb", pilha.top());

        pilha.push("ccc");
        assertEquals("ccc", pilha.top());
    }

    @Test
    public void testIsEmpty() {
        Pilha<String> pilha = new PilhaLista<>();

        assertTrue(pilha.isEmpty());
        pilha.push("vic");
        assertFalse(pilha.isEmpty());
    }
}
