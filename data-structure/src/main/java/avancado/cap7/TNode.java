/*
 * Created on 19/06/2011, 21:00:37
 * Locate at Natal, Rio Grande do Norte
 *
 * TNode.java
 *
 * @autor torugo
 */
package avancado.cap7;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Nodo para arvore generica.
 */
public class TNode<E> {

    private E elemento;

    private TNode<E> pai;

    private Collection<TNode<E>> filhos;

    public TNode(E elemento, TNode<E> pai) {
        this.elemento = elemento;
        this.pai = pai;

        filhos = new ArrayList<TNode<E>>();
    }

    public E getElemento() {
        return elemento;
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public TNode<E> getPai() {
        return pai;
    }

    public void setPai(TNode<E> pai) {
        this.pai = pai;
    }

    public Collection<TNode<E>> getFilhos() {
        return filhos;
    }

    public void setFilhos(Collection<TNode<E>> filhos) {
        this.filhos = filhos;
    }

}
