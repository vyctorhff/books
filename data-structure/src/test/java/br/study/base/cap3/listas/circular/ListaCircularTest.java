/*
 * Created on 16/02/2011, 16:46:47
 * Locate at Natal, Rio Grande do Norte
 *
 * ListaCircularTest.java
 *
 * @autor torugo
 */
package br.study.base.cap3.listas.circular;


import br.study.base.cap3.listas.circular.CircularNode;
import br.study.base.cap3.listas.circular.ListaCircular;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListaCircularTest {

    private ListaCircular listaCircular;

    @BeforeEach
    void setup() {
        this.listaCircular = new ListaCircular();
    }

    @Test
    public void testInserir() {
        listaCircular.inserir(new CircularNode("aaaa"));
        assertEquals("aaaa", listaCircular.getElement());
        assertEquals(1, listaCircular.getSize());
    }

    @Test
    public void testNext() {
        listaCircular.inserir(new CircularNode("aaaa"));
        listaCircular.inserir(new CircularNode("bbbb"));
        listaCircular.inserir(new CircularNode("cccc"));
        listaCircular.inserir(new CircularNode("dddd"));

        /**
         * O getElement mostra o valor do next, pois - quando na operação de
         * remoção - será processado o próximo e não o curso do elemento corrento.
         */

        listaCircular.next();
        assertEquals("bbbb", listaCircular.getElement());

        listaCircular.next();
        assertEquals("cccc", listaCircular.getElement());

        listaCircular.next();
        assertEquals("dddd", listaCircular.getElement());

        listaCircular.next();
        assertEquals("aaaa", listaCircular.getElement());

    }

    @Test
    public void testRemover() {
        listaCircular.inserir(new CircularNode("aaaa"));
        listaCircular.inserir(new CircularNode("bbbb"));
        listaCircular.inserir(new CircularNode("cccc"));
        listaCircular.inserir(new CircularNode("dddd"));

        CircularNode nodo = listaCircular.remover();
        assertEquals("aaaa", nodo.getName());

        assertEquals("bbbb", listaCircular.getElement());

        listaCircular.next();
        assertEquals("cccc", listaCircular.getElement());
    }
}
