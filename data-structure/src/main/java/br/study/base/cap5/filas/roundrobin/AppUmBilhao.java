/*
 * Created on 12/06/2011, 17:43:30
 * Locate at Natal, Rio Grande do Norte
 *
 * AppUmBilhao.java
 *
 * @autor torugo
 */
package br.study.base.cap5.filas.roundrobin;

/**
 * Aplicacao que executa um interacao 1 bilha de vezes.
 */
public class AppUmBilhao implements Aplicacao {

    private final int NUMERO_ITERACOES = 1_000_000_000;

    private final String NOME = "Aplicacao 1 Bilhao de .";

    private boolean finished;

    @Override
    public String getAppName() {
        return NOME;
    }

    @Override
    public void execute() throws Exception {
        for (int x = 0; x < NUMERO_ITERACOES; x++)
            this.imprime(x);
    }

    @Override
    public boolean isFinished() {
        return finished;
    }

    public void imprime(int numero) {
        final int FATOR_IMPRESSAO = 1000000;

        synchronized (System.err) {

            if (numero % (FATOR_IMPRESSAO * 20) == 0) {
//                System.err.println();
            }

            if (numero % FATOR_IMPRESSAO == 0) {
//                System.err.print("Mil . ");
            }
        }

        this.finished = true;
    }
}
