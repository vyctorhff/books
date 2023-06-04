/*
 * Created on 21/02/2011, 16:06:25
 * Locate at Natal, Rio Grande do Norte
 *
 * ImprimeTorreDeHanoiTest.java
 *
 * @autor torugo
 */
package base.cap3.exercicios.hanoi;

import org.junit.jupiter.api.Test;

public class ImprimeTorreDeHanoiTest {

    @Test
    public void testMostrarTorreHanoi() {

        TorreDeHanoi torre = new TorreDeHanoi(3, false);
        torre.resolver();

        Printer imprime = new Printer(torre);
        imprime.mostrarTorreHanoi();
    }

    @Test
    public void testPassoAPassoTorreHanoi() {
        TorreDeHanoi torre = new TorreDeHanoi(3, true);
        torre.resolver();
    }

}
