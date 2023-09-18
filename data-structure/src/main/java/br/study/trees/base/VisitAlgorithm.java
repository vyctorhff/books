package br.study.trees.base;

import java.util.Map;

public interface VisitAlgorithm<E> {
    void execute(GenericTree<E> tree, Map<Object, Object> contect);
}
