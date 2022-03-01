/*
 * Created on 17/06/2011, 15:23:04
 * Locate at Natal, Rio Grande do Norte
 *
 * AppUmBilhaoArroba.java
 *
 * @autor torugo
 */
package base.cap5.filas.roundrobin;

/**
 * Imprime um Bilha de @
 */
public class AppUmBilhaoArrobas implements Aplicacao {

    private final int NUMERO_ITERACOES = 1000000000;

    private final String NOME = "Aplicacao 1 Bilhao de @";

    @Override
    public void execute() throws Exception {

        final int FATOR_IMPRESSAO = 1000;


        for (int x = 0; x < NUMERO_ITERACOES; x++) {

            if (x % (FATOR_IMPRESSAO * 20) == 0) {
//                System.out.println();
            }

            if (x % FATOR_IMPRESSAO == 0) {
//                System.out.print("Mil @ ");
            }
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }


    @Override
    public String getAppName() {
        return NOME;
    }
}
