/*
 * Created on 19/06/2011, 21:36:58
 * Locate at Natal, Rio Grande do Norte
 *
 * ArvoreBinaria.java
 *
 * @autor torugo
 */
package avancado.cap7.binaria;

import avancado.cap7.TNode;

public interface ArvoreBinaria<E> {

    /**
     * Caso ja exista, retorna um erro.
     *
     * @param elemento
     */
    void addRaiz(E elemento);

    void inserirEsquerdo(TNode<E> node, E elemento);

    void inserirDireito(TNode<E> node, E elemento);

    E remover(TNode<E> node);

    /**
     * Conecta a arvore esquerda e direita como subarvore no nodo
     * externo 'node'. Se 'node' nao e externo, lanca um erro.
     *
     * @param node
     * @param esquerda
     * @param direita
     */
    void attach(TNode<E> node, ArvoreBinaria<E> esquerda, ArvoreBinaria<E> direita);

    TNode<E> esquerda(TNode<E> node);

    TNode<E> direita(TNode<E> node);

    boolean hasEsquerdo(TNode<E> node);

    boolean hasDireita(TNode<E> node);

    /**
     * Verifica se cada node tem dois filhos ou se nao tem nenhum filho.
     *
     * @param node
     * @return
     */
    boolean isPropria(TNode<E> node);
}
