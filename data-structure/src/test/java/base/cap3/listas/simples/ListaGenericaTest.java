/*
 * Created on 23/02/2011, 11:15:19
 * Locate at Natal, Rio Grande do Norte
 *
 * ListaGenericaTest.java
 *
 * @autor torugo
 */
package base.cap3.listas.simples;

import br.study.base.cap3.listas.simples.ListaGenerica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListaGenericaTest {

    @Test
    public void testInserir() {
        ListaGenerica<Boolean> lista = new ListaGenerica<>();

        assertEquals(0, lista.getTamanho());
        lista.inserirNaFrente(Boolean.TRUE);
        assertEquals(1, lista.getTamanho());

        lista.inserirNaFrente(Boolean.TRUE);
        assertEquals(2, lista.getTamanho());
    }

    @Test
    public void testRemover() {
        ListaGenerica<Boolean> lista = new ListaGenerica<>();

        lista.inserirNaFrente(Boolean.TRUE);
        lista.inserirNaFrente(Boolean.FALSE);

        Boolean bFalse = lista.removerNaFrente();
        assertFalse(bFalse);

        Boolean bTrue = lista.removerNaFrente();
        assertTrue(bTrue);
    }

    @Test
    public void testIsEmpty() {
        ListaGenerica<Boolean> lista = new ListaGenerica<>();
        assertTrue(lista.isEmpty());

        lista.inserirNaFrente(Boolean.TRUE);
        assertFalse(lista.isEmpty());
    }
}
