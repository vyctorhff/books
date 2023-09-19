package br.study.trees.base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DepthGenericTreeTest {

    private DepthGenericTree<Integer> depth;

    private HeightGenericTree<Integer> height;

    @BeforeEach
    void setUp() {
        this.depth = new DepthGenericTree<>();
        this.height = new HeightGenericTree();
    }

    @Test
    void shouldDepthForRootOnly() {
        var root = Node.createRoot(7);
        var tree = new GenericTree<Integer>(root, depth, height);

        assertEquals(0, depth.execute(tree, root));
    }

    @Test
    void shouldDepthNullNode() {
        var tree = new GenericTree<Integer>(null, depth, height);

        assertThrows(IllegalArgumentException.class, () -> {
            depth.execute(tree, null);
        });
    }

    @Test
    void shouldDepthForNodeInLevalOne() {
        var root = Node.createRoot(7);
        var tree = new GenericTree<Integer>(root, depth, height);

        Node<Integer> nodeLevalOne = new Node<>(root, 8);
        tree.add(root, nodeLevalOne);

        assertEquals(1, depth.execute(tree, nodeLevalOne));
    }

    @Test
    void shouldDepthForNodeInLevalTwo() {
        var root = Node.createRoot(7);
        var tree = new GenericTree<Integer>(root, depth, height);

        Node<Integer> nodeLevalOne = new Node<>(root, 8);
        tree.add(root, nodeLevalOne);

        Node<Integer> nodeLevalTwo = new Node<>(nodeLevalOne, 9);
        tree.add(nodeLevalOne, nodeLevalTwo);

        assertEquals(2, depth.execute(tree, nodeLevalTwo));
    }
}