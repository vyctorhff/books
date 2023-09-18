package br.study.trees.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class GenericTreeTest {

    @Test
    void shouldBeEmpty() {
        var tree = new GenericTree<Integer>(null);
        assertTrue(tree.isEmpty());
    }

    @Test
    void shouldHaveRootOnly() {
        var root = Node.createRoot(7);
        var tree = new GenericTree<Integer>(root);

        assertFalse(tree.isEmpty());
        assertEquals(1, tree.size());
    }

    @Test
    void shouldHaveRootAndThreeChildren() {
        var root = Node.createRoot(7);
        var tree = new GenericTree<Integer>(root);

        var son1 = new Node<>(root, 1);
        var son2 = new Node<>(root, 2);
        var son3 = new Node<>(root, 3);

        tree.add(root, son1);
        tree.add(root, son2);
        tree.add(root, son3);

        assertEquals(4, tree.size());
    }

    @Test
    void shouldDepthForRootOnly() {
        var root = Node.createRoot(7);
        var tree = new GenericTree<Integer>(root);

        assertEquals(1, tree.depth(root));
    }

    @Test
    void shouldDepthNullNode() {
        var tree = new GenericTree<Integer>(null);

        assertThrows(IllegalArgumentException.class, () -> {
            tree.depth(null);
        });
    }

    @Test
    void shouldDepthForNodeRootAsParent() {
        var root = Node.createRoot(7);
        var tree = new GenericTree<Integer>(root);

        Assertions.fail("to do");
    }

    @Test
    void shouldDepthForNodeInLeval2() {
        Assertions.fail("to do");
    }

}