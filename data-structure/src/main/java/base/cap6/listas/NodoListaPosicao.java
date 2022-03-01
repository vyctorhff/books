/*
 * Created on 19/06/2011, 15:39:16
 * Locate at Natal, Rio Grande do Norte
 *
 * NodoListaPosicao.java
 *
 * @autor torugo
 */
package base.cap6.listas;

/**
 * Nodo Duplo com suporte a posicoes.
 */
public class NodoListaPosicao<T> implements Position<T> {

    private T elemento;

    private NodoListaPosicao<T> proximo, anterior;


    public NodoListaPosicao(T elemento) {
        this.elemento = elemento;
    }


    public NodoListaPosicao<T> getProximo() {
        return proximo;
    }


    public void setProximo(NodoListaPosicao<T> proximo) {
        this.proximo = proximo;
    }


    public NodoListaPosicao<T> getAnterior() {
        return anterior;
    }


    public void setAnterior(NodoListaPosicao<T> anterior) {
        this.anterior = anterior;
    }

    @Override
    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

}
