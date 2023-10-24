package br.study.trees.binary;

import org.apache.commons.lang3.NotImplementedException;

public class BinaryTree<E> {

    private BTNode<E> root;

    private final BTPropria<E> checkPropria;

    private BTSize<E> size;

    // TODO: extract interfaces
    public BinaryTree(BTNode<E> root, BTPropria<E> checkPropria, BTSize<E> size) {
        this.root = root;

        this.checkPropria = checkPropria;
        this.size = size;
    }

    public void replace() {
        throw new NotImplementedException();
    }

    public int size() {
        return this.size.execute(this.root);
    }

    public boolean isPropria() {
        return this.checkPropria.check(this.root);
    }
}
