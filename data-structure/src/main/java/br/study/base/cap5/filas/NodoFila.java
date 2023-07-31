/*
 * Created on 16/03/2011, 14:20:56
 * Locate at Natal, Rio Grande do Norte
 *
 * NodoFila.java
 *
 * @autor torugo
 */
package br.study.base.cap5.filas;

/**
 *
 */
public class NodoFila<E> {

    private E elemento;

    private NodoFila<E> proximo;


    public NodoFila(E elemento) {
        this.elemento = elemento;
    }


    public E getElemento() {
        return elemento;
    }


    public void setElemento(E elemento) {
        this.elemento = elemento;
    }


    public NodoFila<E> getProximo() {
        return proximo;
    }


    public void setProximo(NodoFila<E> proximo) {
        this.proximo = proximo;
    }


}
