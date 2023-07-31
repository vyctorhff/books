/*
 * Created on 23/02/2011, 10:21:07
 * Locate at Natal, Rio Grande do Norte
 *
 * Pilha.java
 *
 * @autor torugo
 */
package br.study.base.cap5.pilhas;

/**
 * Expecificacao para a TAD Pilha.
 */
public interface Pilha<T> {

    /**
     * Adiciona um elemento na primeira posicao da pilha.
     *
     * @param objeto
     */
    public void push(T objeto);


    /**
     * Remove o primeiro elemento da pilha.
     *
     * @return
     */
    public T pop();


    /**
     * @return Primeiro elemento da pilha se remove-lo
     */
    public T top();


    /**
     * @return Numero de elementos da pilha.
     */
    public int size();


    /**
     * @return true se a pilha estiver vazia; false se nao.
     */
    public boolean isEmpty();


    /**
     * @return true se a pilha estiver cheia; false se nao.
     */
    public boolean isFull();

}
