/*
 * Created on 14/02/2011, 11:51:49
 * Locate at Natal, Rio Grande do Norte
 *
 * ExemploOrdenacao.java
 *
 * @autor torugo
 */
package base.cap3.arranjos;

import java.util.Optional;
import java.util.Random;

/**
 * Ordenacao para arranjos simples.
 */
public class ExemploOrdenacao {

    public static final int TAMANHO_ARRANJO = 15;

    private int tamanho;

    private final int[] arranjo;

    public ExemploOrdenacao(int tamanho) {
        this.tamanho = TAMANHO_ARRANJO;

        if (tamanho <= 0) {
            this.tamanho = tamanho;
        }

        arranjo = new int[tamanho];
        this.inicializaArranjo();
    }

    private void inicializaArranjo() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        for (int count = 0; count < this.tamanho; count++) {
            arranjo[count] = random.nextInt(200);
        }
    }

    public void ordenar() {
        int cont = 0;
        while (cont < this.tamanho) {

            for (int indiceAtual = 0; indiceAtual < this.tamanho; indiceAtual++) {

                if (isUltimoIndice(indiceAtual))
                    break;

                int indiceProximo = indiceAtual + 1;

                if (isMaiorQue(indiceAtual, indiceProximo))
                    trocarPosicoes(indiceAtual, indiceProximo);
            }

            cont++;
        }
    }

    public int[] getArranjo() {
        return arranjo;
    }

    private boolean isUltimoIndice(int indice) {
        return indice >= (TAMANHO_ARRANJO - 1);
    }

    private boolean isMaiorQue(int indiceAtual, int indiceProximo) {
        return arranjo[indiceAtual] > arranjo[indiceProximo];
    }

    private void trocarPosicoes(int indiceAtual, int indiceProximo) {
        int atual = arranjo[indiceAtual];

        arranjo[indiceAtual] = arranjo[indiceProximo];
        arranjo[indiceProximo] = atual;
    }

    public void ordenarByComparador() {
        throw new UnsupportedOperationException();
    }
}
