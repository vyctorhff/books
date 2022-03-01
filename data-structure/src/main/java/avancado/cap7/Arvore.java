/*
 * Created on 19/06/2011, 21:06:17
 * Locate at Natal, Rio Grande do Norte
 *
 * Arvore.java
 *
 * @autor torugo
 */
package avancado.cap7;

import base.cap6.iterator.Iterador;

/**
 * TAD arvore.
 * Os pais podem ter quantos filhos for necessario.
 */
public interface Arvore<E> {

    /**
     * Retorna o nodo raiz da arvore.
     *
     * @return
     */
	TNode<E> getRaiz();


    int size();


    /**
     * A arvore esta vazia se nao existe nem o raiz.
     *
     * @return
     */
	boolean isEmpty();


    /**
     * Iterador de todos os elementos da arvore.
     *
     * @return
     */
	Iterador<E> iterator();


    /**
     * Iterador de todos os nodos da arvore
     *
     * @return
     */
	Iterador<E> positions();


    /**
     * Substitui o elemento armazenado em um dado nodo.
     *
     * @param nodo
     * @param elemento
     * @return Retorna o elementos substituido.
     */
	E replace(TNode<E> nodo, E elemento);


    /**
     * Retorna o pai do nodo
     *
     * @param nodo
     * @return
     */
	TNode<E> parent(TNode<E> nodo);


    /**
     * @param nodo
     * @return True se o nodo tem filhos
     */
	boolean isInternal(TNode<E> nodo);


    /**
     * @param nodo
     * @return True se o nodo nao tem filhos.
     */
	boolean isExternal(TNode<E> nodo);


    /**
     * E a maior distancia entre o raiz e um nodo externo da
     * arvore.
     *
     * @param nodo
     * @return
     */
	int altura(TNode<E> nodo);


    /**
     * Numero de ancestrais do nodo, excluindo o proprio nodo.
     *
     * @param nodo
     * @return
     */
	int profundidade(TNode<E> nodo);


    /**
     * Visita primeiro o pai e depois os filhos.
     *
     * @param nodo
     */
	String preOrder(TNode<E> nodo);


    /**
     * Visita primeiro os filhos e depois o pai.
     *
     * @param nodo
     */
	String posOrder(TNode<E> nodo);


    /**
     * Pesquisa na subarvore do node pelo elemento.
     *
     * @param nodo
     * @param elemento
     * @return Elemento da subarvore, senao null.
     */
	TNode<E> pesquisar(TNode<E> nodo, E elemento);
}
