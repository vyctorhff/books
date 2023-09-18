package br.study.trees.base;

import java.util.HashMap;

public class GenericTree<E> {

    private int size;

    private final Node<E> root;

    public GenericTree(Node<E> root) {
        this.root = root;

        if (!isEmpty()) {
            this.size++;
        }
    }

    public void add(Node<E> parent, Node<E> node) {
        parent.getChildren().add(node);
        this.size++;
    }

    public void replace() {
    }

    /**
     * The number os parent until reach root
     */
    public int depth(Node<E> node) {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Invalid node to depth");
        }

        if (this.size == 1) {
            return 1;
        }

        return 0;
    }

    /**
     * The most depth in the tree
     */
    public int heigth(Node<E> node) {
        return 0;
    }

    public void visit(VisitAlgorithm<E> visit) {
        visit.execute(this, new HashMap<>());
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.root == null;
    }
}
