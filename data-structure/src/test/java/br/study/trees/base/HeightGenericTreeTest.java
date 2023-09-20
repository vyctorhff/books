package br.study.trees.base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith({MockitoExtension.class})
class HeightGenericTreeTest {

    private HeightGenericTree<Integer> height;

    @BeforeEach
    void setUp() {
        this.height = new HeightGenericTree();
    }

    @Test
    void shouldHeightForNodeInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            height.execute(null);
        });
    }

    @Test
    void shouldHeightForRootOnly() {
        var root = Node.createRoot(7);
        assertEquals(0, height.execute(root));
    }

    @Test
    void shouldHeightForNodeLevelOne() {
        var root = Node.createRoot(7);

        Node<Integer> nodeLevalOne = new Node<>(root, 8);
        root.addSon(nodeLevalOne);

        assertEquals(1, height.execute(root));
    }

    @Test
    void shouldHeightForNodeLevelTwo() {
        var root = Node.createRoot(7);

        Node<Integer> nodeLevalOne = new Node<>(root, 8);
        root.addSon(nodeLevalOne);

        Node<Integer> nodeLevalTwo = new Node<>(nodeLevalOne, 9);
        nodeLevalOne.addSon(nodeLevalTwo);

        assertEquals(2, height.execute(root));
    }
}