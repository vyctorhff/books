package br.study.trees.binary;

public class BTBalanceDefaultTree<T> {

    private final BinaryTree<T> tree;

    public BTBalanceDefaultTree(BinaryTree<T> tree) {
        this.tree = tree;
    }

    public void balance() {}

    private void helper(BTNode<T> node) {
        if (node == null || node.isExternal()) {
            return ;
        }

        // TODO: continue
    }

    private void balanceNode(BTNode<T> node) {
        if (node.isNodeProprio()) {
            return;
        }

        // TODO: continue
    }
}
