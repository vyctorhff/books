/*
 * Created on 06/2023
 * Locate at Majestic, Parnamirm, Rio Grande do Norte
 *
 * @autor torugo
 */
package br.study.base.cap3.exercicios.forest.domain;

public record Meeting(int index1, int index2) {
    public boolean isTheSamePlayer() {
        return index1 == index2;
    }
}
