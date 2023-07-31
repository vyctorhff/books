/*
 * Created on 02/03/2011, 14:47:53
 * Locate at Natal, Rio Grande do Norte
 *
 * Fila.java
 *
 * @autor torugo
 */
package br.study.base.cap5.filas;

/**
 * Operacoes para a TAD Fila
 */
public interface Fila<E> {

    /**
     * @return Numero de elemento da fila.
     */
    public int size();


    /**
     * @return true se a fila estiver vazia, senao, false.
     */
    public boolean isEmpty();


    /**
     * @return Elemento que esta na primeira posicao da fila.
     */
    public E front();


    /**
     * Insere o elemento na fila. Se a fila estiver vazia, entao
     * sera o primeiro, senao sera colocado na ultima posicao.
     *
     * @param element
     */
    public void enqueue(E element);


    /**
     * @return Remove o primeiro elemento da fila
     */
    public E dequeue();
}
