package br.study.trees.base;

import helpers.trees.GenericTreeHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith({MockitoExtension.class})
class HeightGenericTreeTest {

    private HeightGenericTree<Integer> height;

    private GenericTreeHelper helper;

    @BeforeEach
    void setUp() {
        this.height = new HeightGenericTree();
        this.helper = new GenericTreeHelper<Integer>();
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
        var root = helper.createNodeLevelOne(7, 8);

        assertEquals(1, height.execute(root));
    }

    @Test
    void shouldHeightForNodeLevelTwo() {
        var root = helper.createNodeLevelTwo(7, 8, 9);

        assertEquals(2, height.execute(root));
    }
}