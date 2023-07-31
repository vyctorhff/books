/*
 * Created on 16/03/2011, 15:16:10
 * Locate at Natal, Rio Grande do Norte
 *
 * DequeImp.java
 *
 * @autor torugo
 */
package br.study.base.cap5.filas;

import br.study.base.cap3.listas.simples.NodoGenerico;

/**
 * Implementacao da estrutura de dados Deque. Esta TAD permite insercao e
 * remocao apenas no inicio ou no final da lista.
 *
 * @param <E>
 */
public class DequeImp<E> implements Deque<E> {

    private final String MENSAGEM_DEQUE_VAZIO = "Deque esta vazio.";
    private int tamanho;
    private NodoGenerico<E> cabeca;
    private NodoGenerico<E> cauda;

    @Override
    public int size() {
        return tamanho;
    }


    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }


    @Override
    public E getFirst() {

        if (isEmpty())
            throw new IllegalStateException(MENSAGEM_DEQUE_VAZIO);


        return cabeca.getElemento();
    }


    @Override
    public E getLast() {

        if (isEmpty())
            throw new IllegalStateException(MENSAGEM_DEQUE_VAZIO);


        return cauda.getElemento();
    }


    @Override
    public void addFirst(E element) {

        if (isEmpty()) {
            cabeca = new NodoGenerico<E>(element);
            cauda = cabeca;

        } else {
            NodoGenerico<E> nodo = new NodoGenerico<E>(element);

            nodo.setProximo(cabeca);
            cabeca = nodo;
        }


        tamanho++;
    }


    @Override
    public void addLast(E element) {
        if (isEmpty()) {
            this.addFirst(element);

        } else {
            NodoGenerico<E> nodo = new NodoGenerico<E>(element);
            cauda.setProximo(nodo);
            cauda = nodo;

            tamanho++;
        }
    }


    @Override
    public E removeFirst() {

        if (isEmpty())
            throw new IllegalStateException(MENSAGEM_DEQUE_VAZIO);


        NodoGenerico<E> nodo = cabeca;
        cabeca = cabeca.getProximo();


        tamanho--;
        return nodo.getElemento();
    }


    @Override
    public E removeLast() {

        if (isEmpty())
            throw new IllegalStateException(MENSAGEM_DEQUE_VAZIO);


        NodoGenerico<E> nodoAtual = cabeca;
        E elemento = null;


        //So existe um elemento no deque.
        if (cabeca.equals(cauda)) {
            elemento = nodoAtual.getElemento();
            cabeca = cauda = null;

        } else {
            while (true) {

                if (nodoAtual.getProximo().equals(cauda)) {

                    NodoGenerico<E> nodoRemovido = nodoAtual.getProximo();
                    elemento = nodoRemovido.getElemento();

                    nodoAtual.setProximo(nodoRemovido.getProximo());
                    nodoRemovido.setProximo(null);

                    cauda = nodoAtual;
                    break;
                }

                nodoAtual = nodoAtual.getProximo();
            }
        }


        tamanho--;
        return elemento;
    }

}
