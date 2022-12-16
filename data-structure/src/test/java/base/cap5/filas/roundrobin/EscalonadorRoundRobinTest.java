/*
 * Created on 17/06/2011, 16:11:47
 * Locate at Natal, Rio Grande do Norte
 *
 * EscalonadorRoundRobinTest.java
 *
 * @autor torugo
 */
package base.cap5.filas.roundrobin;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class EscalonadorRoundRobinTest {

    @Test
    @Disabled("Devido o tempo de execução, será desabilitado")
    public void testInitEscalonador() {
        EscalonadorRoundRobin escalonador = new EscalonadorRoundRobin();

        Processo procPonto = new Processo(new AppUmBilhao());
        Processo procArroba = new Processo(new AppUmBilhaoArrobas());

        escalonador.addProcesso(procPonto);
        escalonador.addProcesso(procArroba);

        try {
            escalonador.initEscalonador();
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail();
        }
    }
}
