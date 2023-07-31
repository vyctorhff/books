/*
 * Created on 18/02/2011, 19:35:18
 * Locate at Natal, Rio Grande do Norte
 *
 * Pino.java
 *
 * @autor torugo
 */
package br.study.base.cap3.exercicios.hanoi;

/**
 * Referente ao problema da Torre de Hanoi.
 * <p>
 * Representa um pino e contem suas operacoes de manipulacao de discos.
 */
public class Pino {

    public static final int DISCO_VAZIO = -1;
    public static final int INDICE_POSICAO_INICIAL = -1;

    private final int[] pino;
    private int posicaoAtual;
    private int tamanhoPino;

    public Pino(int tamanhoPino) {
        this.setTamanhoPino(tamanhoPino);

        pino = new int[tamanhoPino];

        //O pino esta vazio.
        posicaoAtual = INDICE_POSICAO_INICIAL;

        //Inicializa o pino com valor - 1.
        for (int cont = 0; cont < tamanhoPino; cont++)
            pino[cont] = DISCO_VAZIO;
    }

    /**
     * Inserir um numero do pino.
     *
     * @param numero
     * @throws IllegalArgumentException se o valor for menor que zero ou se
     *                                  o numero for maior que o disco o qual ja esta no pino.
     */
    public void inserirDisco(int numero) {
        if ((pino.length - 1) == posicaoAtual) {
            throw new ArrayIndexOutOfBoundsException("Posicao invalida");
        }

        if (numero <= 0) {
            throw new IllegalArgumentException("Valor para disco nao permitido");
        }

        if (!this.isPinoVazio()) {

            if (numero > pino[posicaoAtual]) {
                throw new IllegalArgumentException("Nao e permitido colocar um disco maior em cima de um menor");
            }
        }

        pino[++posicaoAtual] = numero;
    }

    /**
     * @return true se o pino estiver vazio; false se nao.
     */
    private boolean isPinoVazio() {
        return posicaoAtual == INDICE_POSICAO_INICIAL;
    }

    /**
     * Remove o disco que esta na parte de cima do disco, ou seja no final
     * do arranjo.
     *
     * @return disco
     */
    public int removerDisco() {
        if (posicaoAtual <= INDICE_POSICAO_INICIAL)
            throw new IllegalArgumentException("Pino esta vazio!");


        if (pino[posicaoAtual] < DISCO_VAZIO)
            throw new IllegalArgumentException("Nao ha disco a ser removido!");


        int disco = pino[posicaoAtual];
        pino[posicaoAtual] = DISCO_VAZIO;

        posicaoAtual--;
        return disco;
    }


    public int[] getPino() {
        return pino;
    }

    public int getPosicaoAtual() {
        return posicaoAtual;
    }

    public int getTamanhoPino() {
        return tamanhoPino;
    }

    public void setTamanhoPino(int tamanhoPino) {

        if (tamanhoPino <= 0)
            throw new IllegalArgumentException("Tamanho invalido!");

        this.tamanhoPino = tamanhoPino;
    }

    public int size() {
        return posicaoAtual + 1;
    }
}
