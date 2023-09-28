package helpers.trees;

import br.study.trees.binary.BTNode;
import br.study.trees.binary.BTPropria;
import br.study.trees.binary.BinaryTree;

public class BinaryTreeHelper<E> {

    public BTNode<E> createNodeWithLeftAndRight(E element, E elementRith, E elementLeft) {
        var root = BTNode.createRoot(element);
        root.setRight(new BTNode<E>(elementRith));
        root.setLeft(new BTNode<E>(elementLeft));

        return root;
    }

    public BTNode<E> createNodeWithLeft(E element, E elementLeft) {
        var root = BTNode.createRoot(element);
        root.setLeft(new BTNode<E>(elementLeft));

        return root;
    }

    public BTNode<E> createNodeWithRight(E element, E elementRith) {
        var root = BTNode.createRoot(element);
        root.setRight(new BTNode<E>(elementRith));

        return root;
    }

    public BinaryTree<E> createTreeWithRoot(E element) {
        var root = BTNode.createRoot(element);
        return new BinaryTree<E>(root, new BTPropria<>());
    }
}
