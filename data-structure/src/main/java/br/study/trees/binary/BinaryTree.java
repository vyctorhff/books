package br.study.trees.binary;

import org.apache.commons.lang3.NotImplementedException;

public class BinaryTree<E> {

    private BTNode<E> root;

    private final BTPropria<E> checkPropria;

    public BinaryTree(BTNode<E> root, BTPropria<E> checkPropria) {
        this.root = root;
        this.checkPropria = checkPropria;
    }

    public void replace() {
        throw new NotImplementedException();
    }

    public int size() {
        return 0;
    }

    public boolean isPropria() {
        return this.checkPropria.check(this.root);
    }
}
