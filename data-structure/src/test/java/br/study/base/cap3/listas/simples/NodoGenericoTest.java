/*
 * Created on 01/04/2011, 18:12:37
 * Locate at Natal, Rio Grande do Norte
 *
 * NodoGenericoTest.java
 *
 * @autor torugo
 */
package br.study.base.cap3.listas.simples;

import br.study.base.cap3.listas.simples.NodoGenerico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NodoGenericoTest {

    @Test
    public void testEqualsDouble() {
        NodoGenerico<Double> nodo1 = new NodoGenerico<Double>(3.4);
        NodoGenerico<Double> nodo2 = new NodoGenerico<Double>(5.4);
        NodoGenerico<Double> nodo3 = new NodoGenerico<Double>(5.4);

        assertFalse(nodo1.equals(nodo2));
        assertTrue(nodo2.equals(nodo3));
    }

    @Test
    public void testEqualsString() {
        NodoGenerico<String> nodo1 = new NodoGenerico<>("vic");
        NodoGenerico<String> nodo2 = new NodoGenerico<>("hugo");
        NodoGenerico<String> nodo3 = new NodoGenerico<>("hugo");

        assertFalse(nodo1.equals(nodo2));
        assertTrue(nodo2.equals(nodo3));
    }

    @Test
    public void testEqualsBoolean() {
        NodoGenerico<Boolean> nodo1 = new NodoGenerico<>(true);
        NodoGenerico<Boolean> nodo2 = new NodoGenerico<>(false);
        NodoGenerico<Boolean> nodo3 = new NodoGenerico<>(false);

        assertFalse(nodo1.equals(nodo2));
        assertTrue(nodo2.equals(nodo3));
    }
}
