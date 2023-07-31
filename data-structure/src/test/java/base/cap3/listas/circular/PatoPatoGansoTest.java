/*
 * Created on 16/02/2011, 17:07:41
 * Locate at Natal, Rio Grande do Norte
 *
 * PatoPatoGansoTest.java
 *
 * @autor torugo
 */
package base.cap3.listas.circular;

import br.study.base.cap3.listas.circular.PatoPatoGanso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PatoPatoGansoTest {

    private PatoPatoGanso patoPatoGanso;

    @BeforeEach
    void setup() {
        patoPatoGanso = new PatoPatoGanso();

        patoPatoGanso.addChild("Vic");
        patoPatoGanso.addChild("Albe");
        patoPatoGanso.addChild("Miguel");
        patoPatoGanso.addChild("Alba");
        patoPatoGanso.addChild("Beirinho");
    }

    @Test
    public void testIniciarBricadeira() {
        patoPatoGanso.play();
    }
}
