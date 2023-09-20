package br.study.helpers;

import br.study.trees.base.DepthGenericTree;
import br.study.trees.base.GenericTree;
import br.study.trees.base.HeightGenericTree;
import br.study.trees.base.Node;

public class GenericTreeHelper<E> {

    public Node<E> createNodeLevelZero(E element0) {
        return Node.createRoot(element0);
    }

    public Node<E> createNodeLevelOne(E element0, E element1) {
        var root = Node.createRoot(element0);

        Node<E> nodeLevalOne = new Node<>(root, element1);
        root.addSon(nodeLevalOne);

        return root;
    }

    public Node<E> createNodeLevelTwo(E element0, E element1, E element2) {
        var root = Node.createRoot(element0);

        Node<E> nodeLevalOne = new Node<>(root, element1);
        root.addSon(nodeLevalOne);

        Node<E> nodeLevalTwo = new Node<>(nodeLevalOne, element2);
        nodeLevalOne.addSon(nodeLevalTwo);

        return root;
    }

    public GenericTree<E> createTreeLevelOne(E element0, E element1) {
        GenericTree<E> tree = createTree(element0);

        Node<E> nodeLevalOne = new Node<>(tree.getRoot(), element1);
        tree.add(tree.getRoot(), nodeLevalOne);

        return tree;
    }

    public GenericTree<E> createTreeLevelTwo(E element0, E element1, E element2) {
        GenericTree<E> tree = createTree(element0);

        Node<E> nodeLevalOne = new Node<>(tree.getRoot(), element1);
        tree.add(tree.getRoot(), nodeLevalOne);

        Node<E> nodeLevalTwo = new Node<>(nodeLevalOne, element2);
        tree.add(nodeLevalOne, nodeLevalTwo);

        return tree;
    }

    public GenericTree<E> createTree(E elementRoot) {
        DepthGenericTree<E> depth = new DepthGenericTree<>();
        HeightGenericTree<E> height = new HeightGenericTree();

        var root = Node.createRoot(elementRoot);
        return new GenericTree<E>(root, depth, height);
    }
}
