/*
 * Created on 17/06/2011, 16:11:47
 * Locate at Natal, Rio Grande do Norte
 *
 * EscalonadorRoundRobinTest.java
 *
 * @autor torugo
 */
package br.study.base.cap5.filas.roundrobin;

import br.study.base.cap5.filas.roundrobin.AppUmBilhao;
import br.study.base.cap5.filas.roundrobin.AppUmBilhaoArrobas;
import br.study.base.cap5.filas.roundrobin.EscalonadorRoundRobin;
import br.study.base.cap5.filas.roundrobin.Processo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class EscalonadorRoundRobinTest {

    private EscalonadorRoundRobin escalonador;

    @BeforeEach
    void setup() {
        this.escalonador = new EscalonadorRoundRobin();
    }

    @Test
    @Disabled("Very long time for a test case!")
    void testInitEscalonador() {
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
