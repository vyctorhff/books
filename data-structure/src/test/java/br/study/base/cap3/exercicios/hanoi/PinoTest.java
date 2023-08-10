/*
 * Created on 21/02/2011, 14:37:11
 * Locate at Natal, Rio Grande do Norte
 *
 * PinoTest.java
 *
 * @autor torugo
 */
package br.study.base.cap3.exercicios.hanoi;


import br.study.base.cap3.exercicios.hanoi.Pino;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PinoTest {

    @Test
    public void testInserirDisco() {
        Pino pino = new Pino(3);

        assertEquals(Pino.INDICE_POSICAO_INICIAL, pino.getPosicaoAtual());
        pino.inserirDisco(3);
        assertEquals(0, pino.getPosicaoAtual());

        //Verifica se o numero inserir esta na posicao atual.
        int[] arranjoPino = pino.getPino();
        int numeroInserir = arranjoPino[pino.getPosicaoAtual()];

        assertEquals(3, numeroInserir);
    }

    @Test
    public void testInserirDiscoLitimeArranjo() {
        Pino pino = new Pino(3);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            pino.inserirDisco(4);
            pino.inserirDisco(3);
            pino.inserirDisco(2);
            pino.inserirDisco(1);
        });
    }

    @Test
    public void testInserirDiscoInvalido() {
        Pino pino = new Pino(3);
        assertThrows(IllegalArgumentException.class, () -> pino.inserirDisco(0));
    }

    @Test
    public void testInserirDiscoMaiorQueAtual() {
        Pino pino = new Pino(3);
        assertThrows(IllegalArgumentException.class, () -> {
            pino.inserirDisco(3);
            pino.inserirDisco(4);
        });
    }

    @Test
    public void testRemoverDisco() {
        Pino pino = new Pino(3);
        pino.inserirDisco(4);

        assertEquals(0, pino.getPosicaoAtual());
        int discoRemovido = pino.removerDisco();
        assertEquals(Pino.INDICE_POSICAO_INICIAL, pino.getPosicaoAtual());

        //Removeu o valor correto
        assertEquals(4, discoRemovido);

        //Configurou o indice removido para -1.
        int[] arranjoPino = pino.getPino();
        assertEquals(Pino.DISCO_VAZIO, arranjoPino[0]);
    }

    @Test
    public void testRemoverDiscoVazio() {
        Pino pino = new Pino(3);
        assertThrows(IllegalArgumentException.class, () -> pino.removerDisco());
    }

    @Test
    public void testTamanhoPinoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Pino(-3));
    }

    @Test
    public void testTamanhoPinoNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Pino(0));
    }

    @Test
    public void testSize() {
        Pino pino = new Pino(3);

        pino.inserirDisco(4);
        assertEquals(1, pino.size());

        pino.inserirDisco(3);
        assertEquals(2, pino.size());

        pino.inserirDisco(2);
        assertEquals(3, pino.size());
    }
}
