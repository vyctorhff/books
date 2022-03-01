/*
 * Created on 16/02/2011, 17:07:41
 * Locate at Natal, Rio Grande do Norte
 *
 * PatoPatoGansoTest.java
 *
 * @autor torugo
 */
package base.cap3.listas.circular;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PatoPatoGansoTest {

    @Test
    public void testParticipantes() {
        PatoPatoGanso patoGanso = new PatoPatoGanso();
        patoGanso.participantes();
    }

    @Test
    public void testSorteioAleatorio() {
        PatoPatoGanso patoPatoGanso = new PatoPatoGanso();

        int numeroTrue = 0;
        int numeroFalse = 0;

        for (int cont = 0; cont < 100; cont++) {

            if (patoPatoGanso.sorteioAleatorio())
                numeroTrue++;
            else
                numeroFalse++;
        }

        var limiteMinimo = 0;
        assertNotEquals(limiteMinimo, numeroTrue);
        assertNotEquals(limiteMinimo, numeroFalse);

        var limiteMaximo = 100;
        assertNotEquals(limiteMaximo, numeroTrue);
        assertNotEquals(limiteMaximo, numeroFalse);
    }

    @Test
    public void testIniciarBricadeira() {
        new PatoPatoGanso().iniciarBricadeira();
    }
}
