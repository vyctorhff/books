/*
 * Created on 16/02/2011, 15:14:30
 * Locate at Natal, Rio Grande do Norte
 *
 * ListaCircular.java
 *
 * @autor torugo
 */
package br.study.base.cap3.listas.circular;

/**
 * É uma lista encadeada que não possui head nem tail. E o último elemento
 * aponta para o primeiro.
 * <p>
 * As operações de insert e remove são sempre feitas no próximo, já que não há referência para o prev.
 * Desta forma, sempre devesse avaliar o next do cursor, nunca ele mesmo.
 */
public class ListaCircular {

    /**
     * Nao e um elemento, funciona com um sentinela de lista duplamente enc.
     * É um nodo especial para ser usado com ponto de partida para acessar a lista.
     */
    private CircularNode cursor;

    private int size;

    public void inserir(CircularNode insertNode) {

        if (insertNode == null) {
            throw new IllegalArgumentException("No invalido");
        }

        if (cursor == null) {
            cursor = insertNode;
            insertNode.setNext(insertNode);
        } else {
            CircularNode node = cursor.getNext();
            cursor.setNext(insertNode);

            insertNode.setNext(node);
            cursor = insertNode;
        }

        size++;
    }

    public void next() {
        if (cursor == null) {
            throw new IllegalStateException("A lista esta vazia");
        }

        cursor = cursor.getNext();
    }

    public CircularNode remover() {

        if (cursor == null) {
            return null;
        }

        CircularNode nodoRemovido = cursor.getNext();

        //No caso da lista possuir 1 elemento
        if (cursor == nodoRemovido) {
            cursor = null;
        } else {
            cursor.setNext(nodoRemovido.getNext());
            nodoRemovido.setNext(null);
        }

        size--;
        return nodoRemovido;
    }

    public String getElement() {
        return cursor.getNext().getName();
    }

    public int getSize() {
        return this.size;
    }
}
