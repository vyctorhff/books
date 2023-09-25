package br.study.trees.binary;

import helpers.trees.BinaryTreeHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith({MockitoExtension.class})
class BTNodeTest {

    private BinaryTreeHelper helper;

    @BeforeEach
    void setUp() {
        this.helper = new BinaryTreeHelper();
    }

    @Test
    void shouldBeInternalWithBothNodes() {
        var root = helper.createNodeWithLeftAndRight(1, 2, 3);
        assertTrue(root.isInternal());
    }

    @Test
    void shouldBeInternalWithLeft() {
        var root = helper.createNodeWithLeft(1, 2);

        assertTrue(root.hasLeftNode());
        assertTrue(root.isInternal());
    }

    @Test
    void shouldBeInternalWithRight() {
        var root = helper.createNodeWithRight(1, 2);

        assertTrue(root.hasRightNode());
        assertTrue(root.isInternal());
    }

    @Test
    void shouldBeExternal() {
        var root = BTNode.createRoot(1);

        assertFalse(root.hasLeftNode());
        assertFalse(root.hasRightNode());
        assertTrue(root.isExternal());
    }

    @Test
    void shouldNodeBeProprioTrue() {
        var root = helper.createNodeWithLeftAndRight(1, 2, 3);
        assertTrue(root.isNodeProprio());

        root = BTNode.createRoot(1);
        assertTrue(root.isNodeProprio());
    }
}