/*
 * Created on 21/02/2011, 17:27:31
 * Locate at Natal, Rio Grande do Norte
 *
 * TorreDeHanoiTest.java
 *
 * @autor torugo
 */
package base.cap3.exercicios.hanoi;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TorreDeHanoiTest {

    @Test
    public void testInicializarPinoDeOrigem() throws Exception {
        TorreDeHanoi torre = new TorreDeHanoi(3, false);
        Pino pinoA = torre.getPinoA();

        assertEquals(3, pinoA.size());

        int[] arranjoPino = pinoA.getPino();

        assertEquals(3, arranjoPino[0]);
        assertEquals(2, arranjoPino[1]);
        assertEquals(1, arranjoPino[2]);
    }

    @Test
    public void testResolver() {
        TorreDeHanoi torre = new TorreDeHanoi(3, false);

        Pino pinoA = torre.getPinoA();
        Pino pinoB = torre.getPinoB();
        Pino pinoC = torre.getPinoC();

        int[] arranjoPinoA = pinoA.getPino();
        int[] arranjoPinoC = pinoC.getPino();

        // Verifica a integridade antes da resolucao.
        // Pino A
        assertEquals(3, arranjoPinoA[0]);
        assertEquals(2, arranjoPinoA[1]);
        assertEquals(1, arranjoPinoA[2]);

        // Pino B
        verificaPinoVazio(pinoB);

        // Pino C
        verificaPinoVazio(pinoC);

        torre.resolver();

        // Verifica a integridade antes da resolucao.
        // Pino A
        verificaPinoVazio(pinoA);

        // Pino B
        verificaPinoVazio(pinoB);

        // Pino C
        assertEquals(3, arranjoPinoC[0]);
        assertEquals(2, arranjoPinoC[1]);
        assertEquals(1, arranjoPinoC[2]);
    }

    private void verificaPinoVazio(Pino pino) {

        int[] arranjoPino = pino.getPino();

        for (int valorDisco : arranjoPino)
            assertEquals(Pino.DISCO_VAZIO, valorDisco);
    }

    @Test
    public void testMoverQuantoAoTamanho() {
        final int numeroDiscos = 3;

        TorreDeHanoi torre = new TorreDeHanoi(numeroDiscos, false);

        Pino pinoA = new Pino(numeroDiscos);
        pinoA.inserirDisco(3);
        pinoA.inserirDisco(2);
        pinoA.inserirDisco(1);

        Pino pinoB = new Pino(numeroDiscos);
        Pino pinoC = new Pino(numeroDiscos);

        assertEquals(3, pinoA.size());
        assertEquals(0, pinoB.size());

        torre.mover(pinoA, pinoB);

        assertEquals(1, pinoB.size());
        assertEquals(2, pinoA.size());

        assertEquals(1, pinoB.size());
        assertEquals(0, pinoC.size());

        torre.mover(pinoB, pinoC);

        assertEquals(0, pinoB.size());
        assertEquals(1, pinoC.size());
    }


    @Test
    public void testMoverQuantoAoDeslocamentoDisco() throws Exception {

        TorreDeHanoi torre = new TorreDeHanoi(3, false);

        Pino pinoA = torre.getPinoA();
        Pino pinoB = torre.getPinoB();
        Pino pinoC = torre.getPinoC();

        int[] arranjoPinoA = pinoA.getPino();
        int[] arranjoPinoB = pinoB.getPino();
        int[] arranjoPinoC = pinoC.getPino();

        // Verficacao sa sequencia do discos antes do movimento.
        assertEquals(3, arranjoPinoA[0]);
        assertEquals(2, arranjoPinoA[1]);
        assertEquals(1, arranjoPinoA[2]);

        torre.mover(pinoA, pinoB);

        assertEquals(3, arranjoPinoA[0]);
        assertEquals(2, arranjoPinoA[1]);
        assertEquals(Pino.DISCO_VAZIO, arranjoPinoA[2]);

        // O disco 1 foi movido para B.
        assertEquals(1, arranjoPinoB[0]);

        torre.mover(pinoB, pinoC);

        assertEquals(Pino.DISCO_VAZIO, arranjoPinoB[0]);
        assertEquals(1, arranjoPinoC[0]);

    }

    @Test
    public void testMoverInvalido() {
        final int numeroDiscos = 3;

        TorreDeHanoi torre = new TorreDeHanoi(numeroDiscos, false);

        Pino pinoA = new Pino(numeroDiscos);
        pinoA.inserirDisco(3);
        pinoA.inserirDisco(2);
        pinoA.inserirDisco(1);

        Pino pinoB = new Pino(numeroDiscos);

        assertEquals(3, pinoA.size());
        assertEquals(0, pinoB.size());

        torre.mover(pinoA, pinoB);

        assertEquals(1, pinoB.size());
        assertEquals(2, pinoA.size());

        // Tentando mover o diso 2 do pino A para o pino B que ja tem um disco
        // de valor 1
        assertThrows(IllegalArgumentException.class, () -> {
            torre.mover(pinoA, pinoB);
        });
    }
}
