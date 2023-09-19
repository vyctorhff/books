package br.study.trees.base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class GenericTreeTest {

    private DepthGenericTree<Integer> mockDepth;

    private HeightGenericTree<Integer> mockHeight;

    @BeforeEach
    void setUp() {
        mockDepth = Mockito.mock(DepthGenericTree.class);
        mockHeight = Mockito.mock(HeightGenericTree.class);
    }

    @Test
    void shouldBeEmpty() {
        var tree = new GenericTree<Integer>(null, mockDepth, mockHeight);
        assertTrue(tree.isEmpty());
    }

    @Test
    void shouldHaveRootOnly() {
        var root = Node.createRoot(7);
        var tree = new GenericTree<Integer>(root, mockDepth, mockHeight);

        assertFalse(tree.isEmpty());
        assertEquals(1, tree.size());
    }

    @Test
    void shouldHaveRootAndThreeChildren() {
        var root = Node.createRoot(7);
        var tree = new GenericTree<Integer>(root, mockDepth, mockHeight);

        var son1 = new Node<>(root, 1);
        var son2 = new Node<>(root, 2);
        var son3 = new Node<>(root, 3);

        tree.add(root, son1);
        tree.add(root, son2);
        tree.add(root, son3);

        assertEquals(4, tree.size());
    }

}