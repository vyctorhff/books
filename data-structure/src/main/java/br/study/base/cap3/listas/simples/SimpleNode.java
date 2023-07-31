/*
 * Created on 15/02/2011, 21:38:51
 * Locate at Natal, Rio Grande do Norte
 *
 * NodoSimples.java
 *
 * @autor torugo
 */
package br.study.base.cap3.listas.simples;

import lombok.Data;

/**
 * No de uma lista.
 */
@Data
public class SimpleNode {

    private int elemento;

    private SimpleNode proximo;

    public SimpleNode() {
    }

    public SimpleNode(int elemento) {
        this.elemento = elemento;
    }
}
