/*
 * Created on 23/02/2011, 10:48:32
 * Locate at Natal, Rio Grande do Norte
 *
 * PilhaLista.java
 *
 * @autor torugo
 */
package br.study.base.cap5.pilhas;

import br.study.base.cap3.listas.simples.ListaGenerica;

/**
 * Implementacoa de pilha usando um lista encadeada.
 */
public class PilhaLista<T> implements Pilha<T> {

    private ListaGenerica<T> lista;


    public PilhaLista() {
        lista = new ListaGenerica<T>();


    }


    /*
     * (non-Javadoc)
     *
     * @see cap5.pilhas.Pilha#push(java.lang.Object)
     */
    @Override
    public void push(T objeto) {
        lista.inserirNaFrente(objeto);
    }


    /*
     * (non-Javadoc)
     *
     * @see cap5.pilhas.Pilha#pop()
     */
    @Override
    public T pop() {
        return lista.removerNaFrente();
    }


    /*
     * (non-Javadoc)
     *
     * @see cap5.pilhas.Pilha#top()
     */
    @Override
    public T top() {
        return lista.getPrimeiroElemento();
    }


    /*
     * (non-Javadoc)
     *
     * @see cap5.pilhas.Pilha#size()
     */
    @Override
    public int size() {
        return lista.getTamanho();
    }


    /*
     * (non-Javadoc)
     *
     * @see cap5.pilhas.Pilha#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }


    /*
     * (non-Javadoc)
     *
     * @see cap5.pilhas.Pilha#isFull()
     */
    @Override
    public boolean isFull() {
        return false;
    }


}
