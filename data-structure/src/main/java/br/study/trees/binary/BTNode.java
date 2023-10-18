package br.study.trees.binary;

import lombok.Getter;
import lombok.Setter;

public class BTNode<E> {

    @Getter
    private boolean isRoot;

    @Getter @Setter
    private E element;

    @Getter @Setter
    private BTNode<E> parent;

    @Getter @Setter
    private BTNode<E> right;

    @Getter @Setter
    private BTNode<E> left;

    public BTNode(E element) {
        this.element = element;
    }

    public BTNode(BTNode<E> parent, E element) {
        this.parent = parent;
        this.element = element;
    }

    private BTNode(E element, boolean isRoot) {
        this.element = element;
        this.isRoot = isRoot;
    }

    public boolean isInternal() {
        return hasRightNode() || hasLeftNode();
    }

    public boolean isExternal() {
        return !hasRightNode() && !hasLeftNode();
    }

    public boolean isNodeProprio() {
        return hasBothSides() || isExternal();
    }

    public boolean hasBothSides() {
        return hasRightNode() && hasLeftNode();
    }

    public boolean hasRightNode() {
        return right != null;
    }

    public boolean hasLeftNode() {
        return left != null;
    }

    public static <E> BTNode<E> createRoot(E element) {
        return new BTNode<>(element, true);
    }
}
