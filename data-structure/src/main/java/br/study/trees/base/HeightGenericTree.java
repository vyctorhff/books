package br.study.trees.base;

import java.util.ArrayList;

public class HeightGenericTree<E> {

    public int execute(Node<E> node) {
        if (node == null) {
            throw new IllegalArgumentException("Node invalid for evaluate height");
        }

        return helper(node);
    }

    private int helper(Node<E> node) {
        if (node.isExternal()) {
            return 0;
        }

        var listResult = new ArrayList<Integer>();
        for (Node<E> son : node.getChildren()) {
            listResult.add(1 + helper(son));
        }

        return listResult.stream()
            .max(Integer::compareTo)
            .get();
    }
}
