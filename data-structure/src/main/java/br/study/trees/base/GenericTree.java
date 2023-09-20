package br.study.trees.base;

import lombok.Getter;

import java.util.HashMap;

public class GenericTree<E> {

    @Getter
    private int size;

    @Getter
    private final Node<E> root;

    private final DepthGenericTree<E> depth;

    private final HeightGenericTree<E> height;

    public GenericTree(
        Node<E> root,
        DepthGenericTree<E> depth,
        HeightGenericTree height
    ) {
        this.root = root;
        this.depth = depth;
        this.height = height;

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
        return depth.execute(this, node);
    }

    /**
     * The most depth in the tree
     */
    public int height(Node<E> node) {
        return height.execute(node);
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
