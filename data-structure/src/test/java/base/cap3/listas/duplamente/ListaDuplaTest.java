/*
 * Created on 16/02/2011, 13:22:16
 * Locate at Natal, Rio Grande do Norte
 *
 * ListaDuplaTest.java
 *
 * @autor torugo
 */
package base.cap3.listas.duplamente;

import br.study.base.cap3.listas.duplamente.ListaDupla;
import br.study.base.cap3.listas.duplamente.NodoDuplo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ListaDuplaTest {

    private ListaDupla listaDupla;

    @BeforeEach
    public void setup() {
        this.listaDupla = new ListaDupla();
    }

    @Test
    public void testInserirCabeca() {
        NodoDuplo nodo;

        listaDupla.inserirCabeca(2);

        nodo = listaDupla.getCabeca().getProximo();
        validarReferencias(nodo, 0, 0);
        assertEquals(1, listaDupla.getNumeroElementos());

        listaDupla.inserirCabeca(8);

        nodo = listaDupla.getCabeca().getProximo();
        validarReferencias(nodo, 0, 2);
        assertEquals(2, listaDupla.getNumeroElementos());

        listaDupla.inserirCabeca(7);

        nodo = listaDupla.getCabeca().getProximo();
        validarReferencias(nodo, 0, 8);
        assertEquals(3, listaDupla.getNumeroElementos());

        listaDupla.inserirCabeca(5);

        nodo = listaDupla.getCabeca().getProximo();
        validarReferencias(nodo, 0, 7);
        assertEquals(4, listaDupla.getNumeroElementos());
    }

    @Test
    public void testInserirCalda() {
        NodoDuplo nodo;

        listaDupla.inserirCalda(2);

        nodo = listaDupla.getCalda().getAnterior();
        validarReferencias(nodo, 0, 0);
        assertEquals(1, listaDupla.getNumeroElementos());

        listaDupla.inserirCalda(3);

        nodo = listaDupla.getCalda().getAnterior();
        validarReferencias(nodo, 2, 0);
        assertEquals(2, listaDupla.getNumeroElementos());

        listaDupla.inserirCalda(5);

        nodo = listaDupla.getCalda().getAnterior();
        validarReferencias(nodo, 3, 0);
        assertEquals(3, listaDupla.getNumeroElementos());

        listaDupla.inserirCalda(6);

        nodo = listaDupla.getCalda().getAnterior();
        validarReferencias(nodo, 5, 0);
        assertEquals(4, listaDupla.getNumeroElementos());
    }

    @Test
    public void testInserirAposElemento() {
        listaDupla.inserirCabeca(2);
        listaDupla.inserirCabeca(3);
        listaDupla.inserirCabeca(5);
        listaDupla.inserirCabeca(7);

        //Lista = {7, 5, 3, 2}
        listaDupla.inserirAposElemento(5, 10);

        NodoDuplo nodo = listaDupla.procurarByElemento(10);
        assertEquals(10, nodo.getElemento());
        validarReferencias(nodo, 5, 3);
    }

    private void validarReferencias(NodoDuplo nodo, int elementoAnterior, int elementoProximo) {
        assertEquals(elementoAnterior, nodo.getAnterior().getElemento());
        assertEquals(elementoProximo, nodo.getProximo().getElemento());
    }

    @Test
    public void testProcurarByElemento() {
        //Lista vazia.
        NodoDuplo nodo = listaDupla.procurarByElemento(3);
        assertNull(nodo);

        listaDupla.inserirCabeca(2);
        listaDupla.inserirCabeca(3);
        listaDupla.inserirCabeca(5);
        listaDupla.inserirCabeca(7);

        //Lista = {7, 5, 3, 2}

        nodo = listaDupla.procurarByElemento(5);

        assertEquals(5, nodo.getElemento());
        validarReferencias(nodo, 7, 3);
    }

    @Test
    public void testRemoverByElemento() {
        listaDupla.inserirCabeca(2);
        listaDupla.inserirCabeca(3);
        listaDupla.inserirCabeca(5);
        listaDupla.inserirCabeca(7);

        //Lista = {7, 5, 3, 2}

        listaDupla.removerByElemento(3);
        assertEquals(3, listaDupla.getNumeroElementos());

        NodoDuplo nodo = listaDupla.procurarByElemento(3);
        assertNull(nodo);

        //Verifica se o anterior ao elemento removido aponta o proximo do removido.
        nodo = listaDupla.procurarByElemento(5);
        validarReferencias(nodo, 7, 2);

        nodo = listaDupla.procurarByElemento(2);
        validarReferencias(nodo, 5, 0);
    }
}
