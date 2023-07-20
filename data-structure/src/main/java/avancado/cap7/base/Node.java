package avancado.cap7.base;

public class Node<E> {

    private Node<E> parent;

    private Iterable<Node<E>> children;

    public boolean isRoot() {
        return false;
    }

    public Position<E> parent() {
        return null;
    }

    public Iterable<Position<E>> children() {
        return null;
    }

    public boolean isInternal() {
        return false;
    }

    public boolean isExternal() {
        return false;
    }
}
