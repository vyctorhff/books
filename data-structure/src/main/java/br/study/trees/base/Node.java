package br.study.trees.base;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Node<E> {

    private Node<E> parent;

    private List<Node<E>> children;

    private E element;

    private boolean isRoot;

    public Node(Node<E> parent, E element) {
        this(parent, element, new ArrayList<>());
    }

    private Node(E element, boolean isRoot) {
        this(null, element, new ArrayList<>());
        this.setRoot(isRoot);
    }

    public Node(Node<E> parent, E element, List<Node<E>> children) {
        this.parent = parent;
        this.element = element;
        this.children = children;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public boolean isInternal() {
        return !this.isExternal();
    }

    public boolean isExternal() {
        return this.children.isEmpty();
    }

    public static <E> Node<E> createRoot(E element) {
        return new Node<>(element, true);
    }
}
