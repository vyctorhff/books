/*
 * Created on 15/02/2011, 22:09:20
 * Locate at Natal, Rio Grande do Norte
 *
 * ListaSimplesTest.java
 *
 * @autor torugo
 */
package br.study.base.cap3.listas.simples;


import br.study.base.cap3.listas.simples.ListaSimples;
import br.study.base.cap3.listas.simples.SimpleNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListaSimplesTest {

    private ListaSimples listaSimples;

    @BeforeEach
    void setup() {
        this.listaSimples = new ListaSimples();
    }

    @Test
    public void testInserirCabeca() {
        final int NUMERO_LISTA_VAZIA = 0;
        assertEquals(NUMERO_LISTA_VAZIA, listaSimples.getSize());

        final int ELEMENTO_1 = 5;
        final int NUMERO_LISTA_UM = 1;

        listaSimples.insertHead(ELEMENTO_1);
        assertEquals(NUMERO_LISTA_UM, listaSimples.getSize());

        SimpleNode cabeca = listaSimples.getHead();
        assertEquals(ELEMENTO_1, cabeca.getElemento());

        listaSimples.insertHead(6);
        assertEquals(2, listaSimples.getSize());

        cabeca = listaSimples.getHead();
        assertEquals(6, cabeca.getElemento());
    }

    @Test
    public void testInserirElementoAposNodo() {
        fillDataInListForTest();

        listaSimples.insertAfter(3, 7);
        assertEquals(5, listaSimples.getSize());

        SimpleNode nodoInserido = listaSimples.findNodeByElement(7);
        assertNotNull(nodoInserido);
        assertEquals(7, nodoInserido.getElemento());
    }

    @Test
    public void testProcurarNodoByElemento() {
        fillDataInListForTest();

        SimpleNode nodo = listaSimples.findNodeByElement(3);

        assertNotNull(nodo);
        assertEquals(3, nodo.getElemento());
    }

    @Test
    public void testRemoverNodoByElemento() {
        fillDataInListForTest();

        listaSimples.removerNodoByElemento(1);
        assertEquals(3, listaSimples.getSize());

        SimpleNode nodo = listaSimples.findNodeByElement(1);
        assertNull(nodo);
    }

    @Test
    public void testRemoverNodoByElementoListaVazia() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ListaSimples().removerNodoByElemento(4);
        });
    }

    @Test
    public void testRemoverNodoByElementoInvalido() {
        fillDataInListForTest();

        assertThrows(IllegalArgumentException.class, () -> {
            listaSimples.removerNodoByElemento(10);
        });
    }

    @Test
    void testRemoveHead() {
        fillDataInListForTest();

        var value = listaSimples.removeHead();
        assertEquals(5, value);

        value = listaSimples.removeHead();
        assertEquals(3, value);

        value = listaSimples.removeHead();
        assertEquals(1, value);

        value = listaSimples.removeHead();
        assertEquals(2, value);
    }

    @Test
    public void testSubstituirElemento() {
        fillDataInListForTest();

        listaSimples.substituirElemento(3, 7);
        assertEquals(4, 4);

        SimpleNode nodo = listaSimples.findNodeByElement(7);
        assertNotNull(nodo);
        assertEquals(7, nodo.getElemento());
    }

    @Test
    public void testOrdenarLista() {
        fillDataInListForTest();

        listaSimples.sort();

        var value = listaSimples.removeHead();
        assertEquals(1, value);

        value = listaSimples.removeHead();
        assertEquals(2, value);

        value = listaSimples.removeHead();
        assertEquals(3, value);

        value = listaSimples.removeHead();
        assertEquals(5, value);
    }

    private void fillDataInListForTest() {
        listaSimples.insertHead(2);
        listaSimples.insertHead(1);
        listaSimples.insertHead(3);
        listaSimples.insertHead(5);
    }

}
