package br.study.trees.base;

import lombok.Getter;
import org.apache.commons.lang3.NotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class GenericTree<E> {

    @Getter
    private int size;

    @Getter
    private final Node<E> root;

    private final DepthGenericTree<E> depth;

    private final HeightGenericTree<E> height;

    public GenericTree(
        Node<E> root,
        DepthGenericTree<E> depth,
        HeightGenericTree<E> height
    ) {
        this.root = root;
        this.depth = depth;
        this.height = height;

        if (!isEmpty()) {
            this.size++;
        }
    }

    public void add(Node<E> parent, Node<E> node) {
        parent.addSon(node);
        this.size++;
    }

    public void replace() {
        throw new NotImplementedException();
    }

    /**
     * The number os parent until reach root
     */
    public int depth(Node<E> node) {
        return depth.execute(this, node);
    }

    /**
     * The most depth in the tree
     */
    public int height(Node<E> node) {
        return height.execute(node);
    }

    public Map<Object, Object> visit(VisitAlgorithm<E> visit) {
        Map<Object, Object> context = new HashMap<>();
        visit.execute(this, context);

        return context;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.root == null;
    }
}
