package br.study.trees.binary;

public class BTPropria<E> {

    public boolean check(BTNode<E> node) {
        if (node == null) {
            throw new IllegalArgumentException("Not valid node to check if it is propria");
        }

        if (node.isNodeProprio()) {
            return true;
        }

        return helper(node);
    }

    private boolean helper(BTNode<E> node) {
        return false;
    }
}
