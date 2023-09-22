package br.study.trees.base;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class Node<E> {

    private boolean isRoot;

    private E element;

    private Node<E> parent;

    private List<Node<E>> children;

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

    public void addSon(Node<E> node) {
        this.getChildren().add(node);
    }

    public void addSon(E element) {
        this.getChildren().add(new Node<E>(this, element));
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

    @Override
    public String toString() {
        return "Node(%s)".formatted(element);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return isRoot == node.isRoot &&
            Objects.equals(element, node.element) &&
            Objects.equals(parent, node.parent) &&
            Objects.equals(children, node.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isRoot, element, parent, children);
    }
}
