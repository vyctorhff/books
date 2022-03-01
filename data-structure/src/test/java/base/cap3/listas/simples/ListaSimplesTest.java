/*
 * Created on 15/02/2011, 22:09:20
 * Locate at Natal, Rio Grande do Norte
 *
 * ListaSimplesTest.java
 *
 * @autor torugo
 */
package base.cap3.listas.simples;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListaSimplesTest {

    @Test
    public void testInserirCabeca() {
        ListaSimples listaSimples = new ListaSimples();

        final int NUMERO_LISTA_VAZIA = 0;
        assertEquals(NUMERO_LISTA_VAZIA, listaSimples.getNumeroElementos());

        final int ELEMENTO_1 = 5;
        final int NUMERO_LISTA_UM = 1;

        listaSimples.inserirCabeca(ELEMENTO_1);
        assertEquals(NUMERO_LISTA_UM, listaSimples.getNumeroElementos());


        NodoSimples cabeca = listaSimples.getCabeca();
        assertEquals(ELEMENTO_1, cabeca.getElemento());


        listaSimples.inserirCabeca(6);
        assertEquals(2, listaSimples.getNumeroElementos());

        cabeca = listaSimples.getCabeca();
        assertEquals(6, cabeca.getElemento());
    }


    @Test
    public void testInserirOrdenada() {
        fail("Not yet implemented");
    }


    @Test
    public void testInserirElementoAposNodo() {
        ListaSimples listaSimples = new ListaSimples();

        listaSimples.inserirCabeca(2);
        listaSimples.inserirCabeca(1);
        listaSimples.inserirCabeca(3);
        listaSimples.inserirCabeca(5);


        listaSimples.inserirElementoApos(3, 7);
        assertEquals(5, listaSimples.getNumeroElementos());


        NodoSimples nodoInserido = listaSimples.procurarNodoByElemento(7);
        assertNotNull(nodoInserido);
        assertEquals(7, nodoInserido.getElemento());
    }

    @Test
    public void testProcurarNodoByElemento() {
        ListaSimples listaSimples = new ListaSimples();

        listaSimples.inserirCabeca(2);
        listaSimples.inserirCabeca(1);
        listaSimples.inserirCabeca(3);
        listaSimples.inserirCabeca(5);


        NodoSimples nodo = listaSimples.procurarNodoByElemento(3);


        assertNotNull(nodo);
        assertEquals(3, nodo.getElemento());
    }

    @Test
    public void testRemoverNodoByElemento() {
        ListaSimples listaSimples = new ListaSimples();

        listaSimples.inserirCabeca(2);
        listaSimples.inserirCabeca(1);
        listaSimples.inserirCabeca(3);
        listaSimples.inserirCabeca(5);


        listaSimples.removerNodoByElemento(1);
        assertEquals(3, listaSimples.getNumeroElementos());


        NodoSimples nodo = listaSimples.procurarNodoByElemento(1);
        assertNull(nodo);
    }

    @Test
    public void testRemoverNodoByElementoListaVazia() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            new ListaSimples().removerNodoByElemento(4);
        });
    }

    @Test
    public void testRemoverNodoByElementoInvalido() throws Exception {
        ListaSimples listaSimples = new ListaSimples();

        listaSimples.inserirCabeca(2);
        listaSimples.inserirCabeca(1);
        listaSimples.inserirCabeca(3);
        listaSimples.inserirCabeca(5);

        assertThrows(IllegalArgumentException.class, () -> {
            listaSimples.removerNodoByElemento(10);
        });
    }

    @Test
    public void testSubstituirElemento() {
        ListaSimples listaSimples = new ListaSimples();

        listaSimples.inserirCabeca(2);
        listaSimples.inserirCabeca(1);
        listaSimples.inserirCabeca(3);
        listaSimples.inserirCabeca(5);

        listaSimples.substituirElemento(3, 7);
        assertEquals(4, 4);

        NodoSimples nodo = listaSimples.procurarNodoByElemento(7);
        assertNotNull(nodo);
        assertEquals(7, nodo.getElemento());
    }

    @Test
    public void testOrdenarLista() {
        fail("Not yet implemented");
    }
}
