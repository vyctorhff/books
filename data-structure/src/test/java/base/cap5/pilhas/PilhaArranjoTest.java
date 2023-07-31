/*
 * Created on 23/02/2011, 11:24:30
 * Locate at Natal, Rio Grande do Norte
 *
 * PilhaArranjoTest.java
 *
 * @autor torugo
 */
package base.cap5.pilhas;

import br.study.base.cap5.pilhas.Pilha;
import br.study.base.cap5.pilhas.PilhaArranjo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PilhaArranjoTest {

    public static final int TAMANHO_PILHA = 3;

    private Pilha<Double> pilha;

    @BeforeEach
    public void setup() {
        this.pilha = new PilhaArranjo<>(TAMANHO_PILHA);
    }

    @Test
    public void testPush() {
        pilha.push(3.0);
        pilha.push(3.0);
        pilha.push(3.0);

        assertEquals(3, pilha.size());
    }

    @Test
    public void testPop() {
        pilha.push(3.0);
        pilha.push(4.0);
        pilha.push(5.0);

        assertEquals(5.0, pilha.pop(), 0.1);
        assertEquals(2, pilha.size());

        assertEquals(4.0, pilha.pop(), 0.1);
        assertEquals(1, pilha.size());

        assertEquals(3.0, pilha.pop(), 0.1);
        assertEquals(0, pilha.size());
    }

    @Test
    public void testTop() {
        Pilha<Double> pilha = new PilhaArranjo<>(TAMANHO_PILHA);

        pilha.push(3.0);
        assertEquals(3.0, pilha.top(), 0.1);

        pilha.push(4.0);
        assertEquals(4.0, pilha.top(), 0.1);

        pilha.push(5.0);
        assertEquals(5.0, pilha.top(), 0.1);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(pilha.isEmpty());

        pilha.push(3.0);
        assertFalse(pilha.isEmpty());
    }

    @Test
    public void testIsFull() {
        assertFalse(pilha.isFull());

        pilha.push(3.0);
        assertFalse(pilha.isFull());

        pilha.push(3.0);
        assertFalse(pilha.isFull());

        pilha.push(3.0);
        assertTrue(pilha.isFull());
    }
}
