package br.study.trees.base;

public class DepthGenericTree<E> {

    public int execute(GenericTree<E> tree, Node<E> node) {
        if (tree.isEmpty()) {
            throw new IllegalArgumentException("Invalid node to depth");
        }

        if (tree.getSize() == 1) {
            return 0;
        }

        return helper(node);
    }

    private int helper(Node<E> node) {
        if (node.isRoot()) {
            return 0;
        }

        return 1 + helper(node.getParent());
    }
}
