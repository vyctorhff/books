package br.study.trees.binary;

import br.study.trees.base.Node;
import org.apache.commons.lang3.NotImplementedException;

/**
 * Própria(ou cheias)
 * É uma árvore binharia que tem exatamente zero ou dois filhos em cada nó
 */
public class BinaryTree<E> {

    private Node<E> root;

    public BinaryTree(Node<E> root) {
        this.root = root;
    }

    public void replace() {
        throw new NotImplementedException();
    }

    public boolean isPropria() {
        return false;
    }

    public int size() {
        return 0;
    }
}
