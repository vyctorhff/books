package br.study.trees.binary;

/**
 * Numbers of element in a subtree. The passing node will be counted
 */
public class BTSize<E> {
    
    public int execute(BTNode<E> node) {
        if (node == null || node.getElement() == null) {
            return 0;
        }

        return 1 + execute(node.getLeft()) + execute(node.getRight());
    }
}