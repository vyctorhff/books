package br.study.trees.binary;

/**
 * Própria(ou cheias)
 * É uma árvore binharia que tem exatamente zero ou dois filhos em cada nó
 */
public class BTPropria<E> {

    public boolean check(BTNode<E> node) {
        if (node == null) {
            throw new IllegalArgumentException("Not valid node to check if it is propria");
        }

        return helper(node);
    }

    private boolean helper(BTNode<E> node) {
        if (node.isNodeProprio()) {
            return true;
        }

        return helper(node.getLeft()) && helper(node.getRight());
    }
}
