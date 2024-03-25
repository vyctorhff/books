package helpers.trees;

import br.study.trees.binary.BTNode;
import br.study.trees.binary.BTPropria;
import br.study.trees.binary.BTSize;
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
        return createTree(root);
    }

    public BinaryTree<E> createTreeWithRoot(E element, E elementLeft, E elementRith) {
        var root = BTNode.createRoot(element);

        root.setLeft(new BTNode<>(root, elementLeft));
        root.setRight(new BTNode<>(root, elementRith));

        return createTree(root);
    }

    public BinaryTree<E> createTreeWithRight(E element, E elementRith) {
        var root = BTNode.createRoot(element);
        root.setRight(new BTNode<>(root, elementRith));

        return createTree(root);
    }

    public BinaryTree<E> createTreeWithLeft(E element, E elementLeft) {
        var root = BTNode.createRoot(element);
        root.setLeft(new BTNode<>(root, elementLeft));

        return createTree(root);
    }

    private BinaryTree<E> createTree(BTNode<E> root) {
        var bt = new BinaryTree<E>(root);

        bt.setSize(new BTSize<>());
        bt.setCheckPropria(new BTPropria<>());

        return bt;
    }
}
