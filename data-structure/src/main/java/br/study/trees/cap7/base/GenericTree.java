package br.study.trees.cap7.base;

public class GenericTree<E> {

    public boolean isEmpty() {
        return false;
    }

    public void replace() {
    }

    public int size() {
        return 0;
    }

    public Iterable<Position<E>> positions() {
        return null;
    }

    public int depth() {
        return 0;
    }

    /**
     * The most depth in the tree
     * @return
     */
    public int heigth() {
        return 0;
    }

    /**
     * parent first then children
     * TODO: think to refact for a especific class
     */
    public void preorder() {}

    /**
     * children first, then the parent
     * TODO: think to refact for a especific class
     */
    public void posorder() {}

    // exercices: sum directores length; print elements
}
