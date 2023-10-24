package br.study.trees.binary;

import helpers.trees.BinaryTreeHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith({MockitoExtension.class})
public class BTPropriaTest {

    private BinaryTreeHelper<Integer> helper;

    @BeforeEach
    void setUp() {
        this.helper = new BinaryTreeHelper<>();
    }

    @Test
    void shouldBePropriaWithNoneSons() {
        BinaryTree<Integer> tree = helper.createTreeWithRoot(1);
        assertTrue(tree.isPropria());
    }

    @Test
    void shouldBePropriaWithBothSons() {
        BinaryTree<Integer> tree = helper.createTreeWithRoot(1, 2, 3);
        assertTrue(tree.isPropria());
    }

    @Test
    void shouldBeNotProprieWithRightSon() {
        BinaryTree<Integer> tree = helper.createTreeWithRight(1, 2);
        assertFalse(tree.isPropria());
    }

    @Test
    void shouldBeNotProprieWithLeftSon() {
        BinaryTree<Integer> tree = helper.createTreeWithLeft(1, 3);
        assertFalse(tree.isPropria());
    }
}
