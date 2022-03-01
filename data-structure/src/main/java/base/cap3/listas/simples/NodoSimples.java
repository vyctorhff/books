/*
 * Created on 15/02/2011, 21:38:51
 * Locate at Natal, Rio Grande do Norte
 *
 * NodoSimples.java
 *
 * @autor torugo
 */
package base.cap3.listas.simples;

/**
 * No de uma lista.
 */
public class NodoSimples {

    private int elemento;

    private NodoSimples proximo;


    public NodoSimples() {
    }


    public NodoSimples(int elemento) {
        this.elemento = elemento;
    }


    public int getElemento() {
        return elemento;
    }


    public void setElemento(int elemento) {
        this.elemento = elemento;
    }


    public NodoSimples getProximo() {
        return proximo;
    }


    public void setProximo(NodoSimples proximo) {
        this.proximo = proximo;
    }


}
