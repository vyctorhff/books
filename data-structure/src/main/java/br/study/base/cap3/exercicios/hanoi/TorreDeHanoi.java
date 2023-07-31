/*
 * Created on 17/02/2011, 17:25:37
 * Locate at Natal, Rio Grande do Norte
 *
 * TorreDeHanoi.java
 *
 * @autor torugo
 */
package br.study.base.cap3.exercicios.hanoi;

import lombok.Getter;

/**
 * Quebra-cabeca das torres de hanois.
 * <p>
 * Existe uma plataforma com tres pinos - a, b, c - fincados na mesma. No pina
 * 'a' temos uma pilha de discos um maior que o outro, de maneira que o menor
 * esta no topo e o maior na base.
 * <p>
 * O desafio e mover todos os discos do pino 'a' para o pino 'c', movendo um
 * disco de cada vez, de maneira que nunca seja colocado um disco maior sobre um
 * disco menor.
 * <p>
 * Crie um algoritmo que resolve o quebra-cabeca para qualquer numero de discos
 * usando tres torres.
 * <p>
 * <p>
 * Metodo de Resolucao:
 * <p>
 * Cada pino sera representado como uma arranjo de 'n' posicoes.
 * Para cada dois pino, so existe um movimento possivel para um disco realizar.
 * Cada disco recebe um valor numerico de 1 ate o numero de discos.
 * <p>
 * Caso Base: Movimento do disco de valor 1 consiste em mover o disco de A para C,
 * pulando assim o pino B.
 * <p>
 * Metodo de Investigacao: Fazer os desenhos das torre para  1, 2, 3 e 4 discos.
 * Supondo que o 1 pode pular de A para C e C para A; e o outros valores so podem
 * avancar para o pino seguinte( para frente ou para tras).
 * <p>
 * Observando as representacoes das torres e suas mudancas de posicoes, constatei
 * que para resolver 'n' discos deveria resolver para 'n - 1' discos e assim por diante.
 * <p>
 * Tambem constatei que para cada disco e necessario:
 * 1) resolver para 'n - 1'
 * 2) mover o disco atual para o proximo pino(A -> B)
 * 3) inverter a resolucao de 'n - 1'
 * 4) mover o disco atual para o proximo pino(B -> C)
 * 5) resolver novamento para 'n - 1'
 * <p>
 * O mais importante e entender por que e como funciona a inversao. Ela e importante
 * porque, apos o movimento do disco de maior valor, os discos de menor valor precisando
 * voltar ao ponto de partida para que o de maior valor continue a avancar. Desta forma
 * a resolucao do problema para n - 1 e realiza passando o discos do pino A para C; e sera
 * invertida quando estes discos forem passandos do pino C para o A. Ou seja, a inversar
 * anula a resolucao do problema, fazendo com que os discos voltem aos seu ponto de partida.
 * <p>
 * Um vez feita a inversao o disco de maior valor podera avancas. Feito isso, devesse resolver
 * novamente para 'n - 1', um vez que o disco >= 'n - 1' esta no ponto de partida.
 */
@Getter
public class TorreDeHanoi {

    private final Pino pinoA;
    private final Pino pinoB;
    private final Pino pinoC;

    private Printer imprimirTorre;

    private int numeroPassosResolucao;

    private final int numeroTotalDiscos;

    public TorreDeHanoi(int numeroDiscos, boolean mostrar) {
        this.numeroTotalDiscos = numeroDiscos;

        pinoA = new Pino(numeroDiscos);
        pinoB = new Pino(numeroDiscos);
        pinoC = new Pino(numeroDiscos);

        inicializarPinoOrigem(pinoA);

        if (mostrar) {
            imprimirTorre = new Printer(this);
        }
    }

    /**
     * Insere os disco em ordem decrescente de discos. Primeiro os disco de maior
     * valor e depois os de menor valor.
     *
     * @param pino
     */
    private void inicializarPinoOrigem(Pino pino) {
        int tamanhoPino = pino.getTamanhoPino();

        for (int cont = tamanhoPino; cont > 0; cont--) {
            pino.inserirDisco(cont);
        }
    }

    public void resolver() {
        resolverHelper(numeroTotalDiscos);
    }

    /**
     * Metodo principal para a resolucao do problema. Admite-se que o disco com
     * valor 1 pode saltar do pino A para C e de C para A. Os demais discos so podem
     * mover-se para o proximo pino, podendo faze-lo para frente(no caso do avanco)
     * ou para atras(no caso da inversao).
     *
     * @param numeroDiscos
     */
    private void resolverHelper(int numeroDiscos) {

        //Caso base para o avanco.
        if (numeroDiscos == 1) {
            mover(pinoA, pinoC);
            return;
        }

        resolverHelper(numeroDiscos - 1);
        progredir(numeroDiscos);
        resolverHelper(numeroDiscos - 1);
    }

    /**
     * Metodo que movimenta o disco de maior valor do pino A para o C, procedendo
     * a inversao antes de realizar o segundo movimento
     *
     * @param numeroDiscos
     */
    private void progredir(int numeroDiscos) {
        mover(pinoA, pinoB);
        inverterProgressao(numeroDiscos - 1);
        mover(pinoB, pinoC);
    }

    /**
     * Metodo que inverte(anula a resolucao do problema, fazendo com que os
     * discos, um vez movimentados, voltem ao ponto de partida.
     * <p>
     * Para isso, movimento o disco de maior valor do pino C para o A.
     *
     * @param numeroDiscos
     */
    private void inverterProgressao(int numeroDiscos) {
        //Caso base para a inversao.
        if (numeroDiscos == 1) {
            mover(pinoC, pinoA);
            return;
        }

        mover(pinoC, pinoB);
        inverterProgressao(numeroDiscos - 1);
        mover(pinoB, pinoA);
    }

    /**
     * Move o disco que esta no pinoOrigem para o pinoDestino.
     *
     * @param pinoOrigem
     * @param pinoDestino
     */
    public void mover(Pino pinoOrigem, Pino pinoDestino) {
        int disco = pinoOrigem.removerDisco();
        pinoDestino.inserirDisco(disco);

        numeroPassosResolucao++;

        //Apos cada movimentos, mostra-se as torres.
        if (imprimirTorre != null) {
            imprimirTorre.mostrarTorreHanoi();
        }
    }

    public int getNumeroDiscos() {
        return numeroTotalDiscos;
    }

}
