/*
 * Created on 16/02/2011, 16:46:47
 * Locate at Natal, Rio Grande do Norte
 *
 * ListaCircularTest.java
 *
 * @autor torugo
 */
package base.cap3.listas.circular;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListaCircularTest {

    @Test
    public void testInserir() {
        ListaCircular listaCircular = new ListaCircular();

        listaCircular.inserir(new NodoCircular("aaaa"));
        assertEquals("aaaa", listaCircular.getElementoCursor());
    }

    @Test
    public void testAvancar() {
        ListaCircular listaCircular = new ListaCircular();

        listaCircular.inserir(new NodoCircular("aaaa"));
        listaCircular.inserir(new NodoCircular("bbbb"));
        listaCircular.inserir(new NodoCircular("cccc"));
        listaCircular.inserir(new NodoCircular("dddd"));

        listaCircular.avancar();
        assertEquals("cccc", listaCircular.getElementoCursor());

        listaCircular.avancar();
        assertEquals("bbbb", listaCircular.getElementoCursor());

        listaCircular.avancar();
        assertEquals("aaaa", listaCircular.getElementoCursor());
    }

    @Test
    public void testRemover() {
        ListaCircular listaCircular = new ListaCircular();

        listaCircular.inserir(new NodoCircular("aaaa"));
        listaCircular.inserir(new NodoCircular("bbbb"));
        listaCircular.inserir(new NodoCircular("cccc"));
        listaCircular.inserir(new NodoCircular("dddd"));

        NodoCircular nodo = listaCircular.remover();
        assertEquals("dddd", nodo.getNome());

        listaCircular.avancar();
        assertEquals("bbbb", listaCircular.getElementoCursor());
    }
}
