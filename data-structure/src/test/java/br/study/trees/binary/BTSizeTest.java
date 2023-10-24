package br.study.trees.binary;

import helpers.trees.BinaryTreeHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({MockitoExtension.class})
public class BTSizeTest {

    private BinaryTreeHelper<Integer> helper;

    @BeforeEach
    void setUp() {
        this.helper = new BinaryTreeHelper<>();
    }

    @Test
    void shouldSizeOnlyWithRoot() {
        BinaryTree<Integer> tree = helper.createTreeWithRoot(1);
        assertEquals(1, tree.size());
    }

    @Test
    void shouldSizeWithTwoElements() {
        BinaryTree<Integer> tree = helper.createTreeWithRight(1, 2);
        assertEquals(2, tree.size());
    }

    @Test
    void shouldSizeWithTreeElements() {
        BinaryTree<Integer> tree = helper.createTreeWithRoot(1, 2, 3);
        assertEquals(3, tree.size());
    }
}
