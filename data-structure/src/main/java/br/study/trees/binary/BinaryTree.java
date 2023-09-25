package br.study.trees.binary;

import org.apache.commons.lang3.NotImplementedException;

/**
 * Própria(ou cheias)
 * É uma árvore binharia que tem exatamente zero ou dois filhos em cada nó
 */
public class BinaryTree<E> {

    private BTNode<E> root;

    public BinaryTree(BTNode<E> root) {
        this.root = root;
    }

    public void replace() {
        throw new NotImplementedException();
    }

    public int size() {
        return 0;
    }

    public boolean isPropria() {
        return false;
    }
}
