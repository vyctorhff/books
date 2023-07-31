/*
 * Created on 16/02/2011, 23:49:01
 * Locate at Natal, Rio Grande do Norte
 *
 * CasosGerais.java
 *
 * @autor torugo
 */
package br.study.base.cap3.recursao;

public class CasosGerais {

    public int somaArranjo(int[] arranjo) {

        if (arranjo == null) {
            throw new IllegalArgumentException("Arranjo null ou invalido");
        }

        if (arranjo.length <= 0) {
            throw new IllegalArgumentException("Arranjo vazio");
        }

        return somaArranjoHelper(arranjo, 0);
    }

    private int somaArranjoHelper(int[] arranjo, int indice) {
        if (indice >= arranjo.length) return 0;

        return arranjo[indice] + somaArranjoHelper(arranjo, indice + 1);
    }

    public int[] inverteArranjo(int[] arranjo) {

        if (arranjo == null) {
            throw new IllegalArgumentException("Arranjo null ou invalido");
        }

        final int tamanhoArranjo = arranjo.length;

        if (tamanhoArranjo <= 0) {
            throw new IllegalArgumentException("Arranjo vazio");
        }

        int[] arranjoInvertido = new int[tamanhoArranjo];
        return inverteArranhoHelper(arranjo, 0, arranjoInvertido, tamanhoArranjo - 1);
    }

    private int[] inverteArranhoHelper(int[] arranjo, int indice, int[] arranjoInvertido, int indiceInvertido) {

        if (indice >= (arranjo.length)) {
            return arranjoInvertido;
        }

        arranjoInvertido[indiceInvertido] = arranjo[indice];
        return inverteArranhoHelper(arranjo, ++indice, arranjoInvertido, --indiceInvertido);
    }

}
