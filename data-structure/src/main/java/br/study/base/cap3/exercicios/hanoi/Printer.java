/*
 * Created on 21/02/2011, 15:47:56
 * Locate at Natal, Rio Grande do Norte
 *
 * ImprimeTorreDeHanoi.java
 *
 * @autor torugo
 */
package br.study.base.cap3.exercicios.hanoi;

import org.apache.commons.lang3.StringUtils;

public class Printer {

    public static final String STR_JOGO_DA_VELHA = "#";
    private final int TAMANHO_ESPACO_ANTES_TORRE = 10;
    private final int TAMANHO_ESPACO_ENTRE_TORRE = 20;

    private final int numeroDiscos;

    private final String BARRA = "|";

    private final Pino pinoA;
    private final Pino pinoB;
    private final Pino pinoC;

    public Printer(TorreDeHanoi torre) {
        pinoA = torre.getPinoA();
        pinoB = torre.getPinoB();
        pinoC = torre.getPinoC();

        numeroDiscos = torre.getNumeroDiscos();
    }

    /**
     * Sera impresso cada linha de cima para baixo do pino deixando um
     * espaco de 10 caracteres antes do inicia do desenho das torres e
     * 20 caracteres entre cada torre.
     */
    public void mostrarTorreHanoi() {

        StringBuilder saida = new StringBuilder();
        saida.append("\n");

        for (int cont = numeroDiscos - 1; cont >= 0; cont--) {

            saida.append(getEspacoEmBranco(TAMANHO_ESPACO_ANTES_TORRE));
            saida.append(formataLinha(cont));
            saida.append(getEspacoEmBranco(TAMANHO_ESPACO_ANTES_TORRE));

            saida.append("\n");
        }

        int numeroSustenidos = (2 * TAMANHO_ESPACO_ANTES_TORRE) + (2 * TAMANHO_ESPACO_ENTRE_TORRE) + 5;
        saida.append(getSustenidos(numeroSustenidos));

        System.out.print(saida);
    }

    private String formataLinha(int indicePino) {
        StringBuilder saida = new StringBuilder();

        int[] arranjoPinoA = pinoA.getPino();
        int[] arranjoPinoB = pinoB.getPino();
        int[] arranjoPinoC = pinoC.getPino();

        saida.append(BARRA);
        saida.append(formataValorDisco(arranjoPinoA[indicePino]));
        saida.append(getEspacoEmBranco(TAMANHO_ESPACO_ENTRE_TORRE));

        saida.append(BARRA);
        saida.append(formataValorDisco(arranjoPinoB[indicePino]));
        saida.append(getEspacoEmBranco(TAMANHO_ESPACO_ENTRE_TORRE));

        saida.append(BARRA);
        saida.append(formataValorDisco(arranjoPinoC[indicePino]));

        return saida.toString();
    }

    private String formataValorDisco(int disco) {
        if (disco == Pino.DISCO_VAZIO)
            return " ";

        return String.valueOf(disco);
    }

    private String getEspacoEmBranco(int numero) {
        return StringUtils.EMPTY.repeat(numero);
    }

    private String getSustenidos(int numero) {
        return STR_JOGO_DA_VELHA.repeat(numero);
    }
}
