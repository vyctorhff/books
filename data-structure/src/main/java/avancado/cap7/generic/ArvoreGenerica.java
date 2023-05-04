/*
 * Created on 19/06/2011, 21:24:04
 * Locate at Natal, Rio Grande do Norte
 *
 * ArvoreGenerica.java
 *
 * @autor torugo
 */
package avancado.cap7.generic;

import avancado.cap7.TNode;
import base.cap6.iterator.Iterador;

/**
 * Implementacao da TAD arvore generica.
 */
public class ArvoreGenerica<E> implements Arvore<E> {

    private TNode<E> raiz;

    private int numeroElementos;

    public ArvoreGenerica() {
    }

    @Override
    public TNode<E> getRaiz() {
        return raiz;
    }


    @Override
    public int size() {
        return numeroElementos;
    }

    @Override
    public boolean isEmpty() {
        return raiz == null;
    }

    @Override
    public Iterador<E> iterator() {
        return null;
    }

    @Override
    public Iterador<E> positions() {
        return null;
    }

    @Override
    public E replace(TNode<E> nodo, E elemento) {
        E elementoRemovido = nodo.getElemento();

        nodo.setElemento(elemento);

        return elementoRemovido;
    }

    @Override
    public TNode<E> parent(TNode<E> nodo) {

        if (this.isEmpty())
            throw new IllegalStateException("Arvore vazia");

        if (hasParent(nodo))
            throw new IllegalArgumentException("O no raiz nao tem pai");

        return nodo.getPai();
    }

    public boolean hasParent(TNode<E> nodo) {
        return nodo == raiz;
    }

    @Override
    public boolean isInternal(TNode<E> nodo) {
        return !this.isExternal(nodo);
    }

    @Override
    public boolean isExternal(TNode<E> nodo) {
        return nodo.getFilhos().isEmpty();
    }

    @Override
    public int altura(TNode<E> nodo) {
        return 0;
    }

    @Override
    public int profundidade(TNode<E> nodo) {
        return profundidadeHelper(parent(nodo));
    }

    private int profundidadeHelper(TNode<E> nodo) {
        int cont = 0;

        if (hasParent(nodo))
            cont += profundidade(nodo.getPai()) + 1;

        return cont;
    }

    public String preOrder(TNode<E> nodo) {

        StringBuffer saida = new StringBuffer();
        this.preOrderHelper(nodo, saida);

        return saida.toString();
    }

    public void preOrderHelper(TNode<E> node, StringBuffer saida) {

        if (node == null)
            return;

        //Visita o pai primeiro
        saida.append(node.getElemento() + ", ");

        if (isExternal(node))
            return;

        //Visita os filhos.
        for (TNode<E> no : node.getFilhos()) {
            preOrderHelper(no, saida);
        }
    }

    @Override
    public String posOrder(TNode<E> nodo) {
        StringBuffer buffer = new StringBuffer();
        posOrderHelper(getRaiz(), buffer);
        return buffer.toString();
    }

    public void posOrderHelper(TNode<E> node, StringBuffer saida) {
        if (node == null)
            return;

        if (isExternal(node)) {
            saida.append(node.getElemento() + ", ");
            return;
        }

        for (TNode<E> no : node.getFilhos())
            posOrderHelper(no, saida);
    }

    public TNode<E> pesquisar(TNode<E> nodo, E elemento) {

        if (nodo == null)
            return null;

        if (nodo.getElemento().equals(elemento))
            return nodo;


        if (this.isExternal(nodo))
            return null;

        TNode<E> nodoEncontrado = null;

        for (TNode<E> no : nodo.getFilhos()) {

            nodoEncontrado = pesquisar(no, elemento);

            if (nodoEncontrado != null) //Encontrou o node, pare a pesquisa.
                break;
        }

        return nodoEncontrado;
    }

}
