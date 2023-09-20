package br.study.trees.base;

import br.study.helpers.GenericTreeHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DepthGenericTreeTest {

    private DepthGenericTree<Integer> depth;

    private HeightGenericTree<Integer> height;

    private GenericTreeHelper helper;

    @BeforeEach
    void setUp() {
        this.depth = new DepthGenericTree<>();
        this.height = new HeightGenericTree();

        this.helper = new GenericTreeHelper();
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
        GenericTree<Integer> tree = helper.createTreeLevelOne(7, 8);
        Node<Integer> nodeLevalOne = tree.getRoot().getChildren().get(0);

        assertEquals(1, depth.execute(tree, nodeLevalOne));
    }

    @Test
    void shouldDepthForNodeInLevalTwo() {
        GenericTree<Integer> tree = helper.createTreeLevelTwo(7, 8, 9);
        Node<Integer> nodeLevalTwo = tree.getRoot().getChildren().get(0).getChildren().get(0);

        assertEquals(2, depth.execute(tree, nodeLevalTwo));
    }
}